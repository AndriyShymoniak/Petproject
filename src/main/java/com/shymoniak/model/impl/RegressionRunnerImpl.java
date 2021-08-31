package com.shymoniak.model.impl;

import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.model.RegressionRunner;

import com.shymoniak.repository.AccommodationRepository;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegressionRunnerImpl implements RegressionRunner {
    @Autowired
    AccommodationRepository accommodationRepository;

    /**
     * This method is used to process the input and return the statistics.
     */
    @Override
    public void run() {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        regression.setNoIntercept(true);
        List<AccommodationEntity> accommodations = accommodationRepository.findAll();
        List<Double> resultValues = new ArrayList<>();
        List<List<Double>> predictionValues = new ArrayList<>();

        for (AccommodationEntity accommodation : accommodations) {
            List<Double> innerList = new ArrayList<>();
            innerList.add((double) accommodation.getBuildIn().toEpochDay());
            innerList.add(Double.valueOf(accommodation.getTotalArea()));
            innerList.add(Double.valueOf(accommodation.getDistanceToCityCenter()));
            innerList.add(Double.valueOf(accommodation.getAccommodationClass().getId()));
            innerList.add(Double.valueOf(accommodation.getAccommodationCondition().getId()));
            innerList.add(Double.valueOf(accommodation.getAccommodationType().getId()));
            innerList.add((double) accommodation.getRoomList().size());
            predictionValues.add(innerList);
            resultValues.add(Double.valueOf(accommodation.getPrice()));
        }
        regression.newSampleData(listToArray(resultValues), listTo2DArray(predictionValues));
        double[] regressionParameters = regression.estimateRegressionParameters();
        System.out.println(regressionParameters);
    }

    private double[] listToArray(List<Double> list) {
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private double[][] listTo2DArray(List<List<Double>> list) {
        double[][] arr = new double[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
             arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
}
