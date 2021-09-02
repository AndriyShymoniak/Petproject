package com.shymoniak.model.impl;

import com.shymoniak.model.MatrixUtility;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatrixUtilityImpl implements MatrixUtility {
    @Override
    public double[] listToArray(List<Double> list) {
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    @Override
    public double[][] listTo2DArray(List<List<Double>> list) {
        double[][] arr = new double[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(0).size(); j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
}
