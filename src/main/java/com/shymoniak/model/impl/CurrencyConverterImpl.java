package com.shymoniak.model.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;
import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.model.CurrencyConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Component
public class CurrencyConverterImpl implements CurrencyConverter {
    public Map<String, Double> getExchangeValues() {
        try {
            URL url = new URL(ApplicationConstants.EXCHANGER_API_URL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonObj = root.getAsJsonObject();
            return new Gson().fromJson(jsonObj.get(ApplicationConstants.EXCHANGER_RATES).toString(), LinkedTreeMap.class);
        } catch (IOException ex) {
            throw new ApiRequestException("Couldn't get response from " + "https://exchangerate.host");
        }
    }
}
