package com.terabits.meta.bo;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/15.
 */
public class BusinessElectricityBO {
    private HashMap<String, Double> electricity;

    public HashMap<String, Double> getElectricity() {
        return electricity;
    }

    public void setElectricity(HashMap<String, Double> electricity) {
        this.electricity = electricity;
    }
}
