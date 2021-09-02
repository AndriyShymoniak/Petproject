package com.shymoniak.model.impl;

import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.model.MatrixUtility;
import com.shymoniak.model.RegressionRunner;

import com.shymoniak.repository.AccommodationRepository;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegressionRunnerImpl implements RegressionRunner {
    private AccommodationRepository accommodationRepository;
    private MatrixUtility matrixUtility;

    @Autowired
    public RegressionRunnerImpl(AccommodationRepository accommodationRepository, MatrixUtility matrixUtility) {
        this.accommodationRepository = accommodationRepository;
        this.matrixUtility = matrixUtility;
    }

    // TODO: 2021-09-02 Refactor
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
            innerList.add(Double.valueOf(accommodation.getDistanceToCityCenter()));
            innerList.add(Double.valueOf(accommodation.getAccommodationClass().getId()));
            innerList.add(Double.valueOf(accommodation.getAccommodationCondition().getId()));
            innerList.add(Double.valueOf(accommodation.getAccommodationType().getId()));
            innerList.add((double) accommodation.getRoomList().size());
            predictionValues.add(innerList);
            resultValues.add(Double.valueOf(accommodation.getPrice()));
        }
        regression.newSampleData(matrixUtility.listToArray(resultValues), matrixUtility.listTo2DArray(predictionValues));
        double[] regressionParameters = regression.estimateRegressionParameters();
        System.out.println(regressionParameters);
    }
}
