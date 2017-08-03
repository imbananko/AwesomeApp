/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Graduate
 */
public class JUnitTest {
    @Test
    public void myTestMethod() {
        assertEquals(true, 1 == 1);
        //assertEquals(5, toCalculate(5));
    }
    
    private static int toCalculate(int n) {
        int count = 0;
        int sum = 1;
        while (count++ < n) {
            sum += toCalculate(count);
            System.out.println(sum);
        }
        return sum;
     }
    //changes
}
