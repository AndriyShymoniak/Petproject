package com.shymoniak.model.impl;

import com.shymoniak.exception.ApiRequestException;
import com.shymoniak.model.FileCreator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileCreatorImpl implements FileCreator {
    @Override
    public void createFile(String filePath, String fileName) {
        try {
            File testFile = new File(filePath + fileName);
            testFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApiRequestException("Failed to create file " + fileName);
        }
    }
}
