package com.shymoniak.model.impl;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.model.RegressionRunner;

import org.springframework.stereotype.Component;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.IOException;

@Component
public class RegressionRunnerImpl implements RegressionRunner {
    /**
     * This method is used to process the input and return the statistics.
     */
    @Override
    public void run() {
        Instances trainingDataSet = getDataSet(ApplicationConstants.TRAINING_DATA_SET_FILENAME);
        Instances testingDataSet = getDataSet(ApplicationConstants.TESTING_DATA_SET_FILENAME);
        try {
            Classifier classifier = new weka.classifiers.functions.LinearRegression();
            classifier.buildClassifier(trainingDataSet);

            // Trains the algorithm on training data and evaluates on testing data
            Evaluation eval = new Evaluation(trainingDataSet);
            eval.evaluateModel(classifier, testingDataSet);
            // Print the algorithm summary
            System.out.println("** Linear Regression Evaluation with Datasets **");
            System.out.println(eval.toSummaryString());
            System.out.print(" the expression for the input data as per alogorithm is ");
            System.out.println(classifier);

            Instance predicationDataSet = getDataSet(ApplicationConstants.PREDICTION_DATA_SET_FILENAME).lastInstance();
            double value = classifier.classifyInstance(predicationDataSet);
            /** Prediction Output */
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiRequestException("Regression algorithm failed to process");
        }
    }

    /**
     * This method loads the data set.
     *
     * @param fileName
     * @return
     */
    public static Instances getDataSet(String fileName) {
        // Class index is used to specify class
        int classIndex = 1;
        ArffLoader loader = new ArffLoader();
        try {
            loader.setSource(RegressionRunnerImpl.class.getResourceAsStream("/" + fileName));
            Instances dataSet = loader.getDataSet();
            dataSet.setClassIndex(classIndex);
            return dataSet;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApiRequestException("Failed to load regression data, .arff file problems");
        }
    }
}
