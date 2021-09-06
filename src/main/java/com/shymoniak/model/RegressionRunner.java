package com.shymoniak.model;

import java.util.List;

/**
 * Performs regression on database data
 */
public interface RegressionRunner {
    List<Double> getRegressionParams(List<List<Double>> keyValues, List<Double> resultValues);
}
