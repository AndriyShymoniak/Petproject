package com.shymoniak.model;

import java.util.List;

public interface PricePredictor<T> {
    Float predict(T toPredict, List<T> trainingList);
}
