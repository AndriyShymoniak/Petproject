package com.shymoniak.model.impl;

import com.shymoniak.model.MatrixUtility;
import com.shymoniak.model.RegressionRunner;

import com.shymoniak.repository.AccommodationRepository;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements Linear Regression
 */
@Component
public class RegressionRunnerImpl implements RegressionRunner {
    private AccommodationRepository accommodationRepository;
    private MatrixUtility matrixUtility;

    @Autowired
    public RegressionRunnerImpl(AccommodationRepository accommodationRepository, MatrixUtility matrixUtility) {
        this.accommodationRepository = accommodationRepository;
        this.matrixUtility = matrixUtility;
    }

    /**
     *  This method is used to process the input and return Regression
     *  parameters.
     * @param keyValues - values which are used for prediction
     * @param resultValues - prediction result
     * @return
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
