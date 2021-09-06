package com.shymoniak.model.impl;

import com.shymoniak.entity.AccommodationEntity;
import com.shymoniak.model.MatrixUtility;
import com.shymoniak.model.RegressionRunner;

import com.shymoniak.repository.AccommodationRepository;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Double> getRegressionParams(List<List<Double>> keyValues, List<Double> resultValues) {
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        regression.setNoIntercept(true);
        regression.newSampleData(matrixUtility.listToArray(resultValues), matrixUtility.listTo2DArray(keyValues));
        return Arrays.stream(regression.estimateRegressionParameters())
                .boxed()
                .collect(Collectors.toList());
    }
}
