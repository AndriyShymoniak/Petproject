package com.shymoniak.model.impl;

import com.shymoniak.model.RegressionRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegressionRunnerImplTest {
    @Autowired
    RegressionRunnerImpl regressionRunner;

    @Test
    public void testRun(){
//        regressionRunner.run();
    }

}