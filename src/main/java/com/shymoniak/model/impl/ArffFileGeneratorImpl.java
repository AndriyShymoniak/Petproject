package com.shymoniak.model.impl;

import com.shymoniak.constant.ApplicationConstants;
import com.shymoniak.model.ArffFileGenerator;
import com.shymoniak.model.FileCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;

import java.util.ArrayList;

@Component
public class ArffFileGeneratorImpl implements ArffFileGenerator {
    private FileCreator fileCreator;

    @Autowired
    public ArffFileGeneratorImpl(FileCreator fileCreator) {
        this.fileCreator = fileCreator;
    }

    // TODO: 2021-08-25 FINISH FILE CREATION 
    public void generate() {
        String filePath = System.getProperty("user.dir");
        fileCreator.createFile(filePath, ApplicationConstants.TRAINING_DATA_SET_FILENAME);
        ArrayList<Attribute> attributeList = new ArrayList<>();
        ArrayList<Attribute> attributeValue = new ArrayList<>();
        attributeList.add(new Attribute("atribute name"));
        Instances data = new Instances("Random relation name", attributeList, 0);

    }
}
