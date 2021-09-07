package com.shymoniak.model.impl;

import com.shymoniak.domain.AccommodationDTO;
import com.shymoniak.model.PricePredictor;
import com.shymoniak.model.RegressionRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Predicts price of Accommodation, relying on its characteristics.
 * @param <T> - class that extends AccommodationDTO
 */
@Component
public class AccommodationPricePredictor<T extends AccommodationDTO> implements PricePredictor<T> {
    private RegressionRunner regressionRunner;

    @Autowired
    public AccommodationPricePredictor(RegressionRunner regressionRunner) {
        this.regressionRunner = regressionRunner;
    }

    /**
     * Takes an accommodation to predict its value, based on
     * previous records in DB
     * @param toPredict
     * @return
     */
    @Override
    public Float predict(T toPredict, List<T> accommodationList) {
        List<Double> resultValues = new ArrayList<>();
        List<List<Double>> predictionValues = new ArrayList<>();

        for (AccommodationDTO accommodation : accommodationList) {
            predictionValues.add(keyAccommodationValues(accommodation));
            resultValues.add(Double.valueOf(accommodation.getPrice()));
        }
        List<Double> regressionParams = regressionRunner.getRegressionParams(predictionValues, resultValues);
        List<Double> toPredictValues = keyAccommodationValues(toPredict);
        Double result = 0D;
        for (int i = 0; i < regressionParams.size(); i++) {
            result += regressionParams.get(i) * toPredictValues.get(i);
        }
        return result.floatValue();
    }

    /**
     * Returns double list of key accommodation values
     * which are used to predict its price
     * @param accommodation
     * @return
     */
    private List<Double> keyAccommodationValues(AccommodationDTO accommodation){
        List<Double> resultList = new ArrayList<>();
        resultList.add((double) accommodation.getBuildIn().toEpochDay());
        resultList.add(Double.valueOf(accommodation.getDistanceToCityCenter()));
        resultList.add(Double.valueOf(accommodation.getAccommodationClass().getId()));
        resultList.add(Double.valueOf(accommodation.getAccommodationCondition().getId()));
        resultList.add((double) accommodation.getRoomList().size());
        Float sumSquare = accommodation.getRoomList().stream()
                .map(room -> room.getSquare())
                .reduce(0F, Float::sum);
        resultList.add((double) sumSquare);
        return resultList;
    }
}
