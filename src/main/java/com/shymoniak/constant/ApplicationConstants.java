package com.shymoniak.constant;

public class ApplicationConstants {
    // Exchanger constants
    public static final String EXCHANGER_API_URL = "https://api.exchangerate.host/latest";
    public static final String EXCHANGER_RATES = "rates";

    // Exception messages
    public static final String ERROR_MESSAGE_RECORD_NOT_FOUND = "There is no such record";

    // Linear regression files
    public static final String TRAINING_DATA_SET_FILENAME="linear-train.arff";
    public static final String TESTING_DATA_SET_FILENAME="linear-test.arff";
    public static final String PREDICTION_DATA_SET_FILENAME="test-confused.arff";

    // DistanceCalculator
    public static final Integer EARTH_RADIUS = 6371; //Kilometers
}
