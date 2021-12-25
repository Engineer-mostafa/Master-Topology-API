package com.example.Topology.models;

import java.util.HashMap;

public class Battery extends Device{

    HashMap<String, Double> value;


    public Battery( String type,
                       String id,
                       HashMap<String, Double> value,
                       HashMap<String, String> netlist) {
        super(type ,  id  ,  netlist);
        this.value = value;
    }

    public HashMap<String, Double> getResistance() {
        return value;
    }

    public void setResistance(HashMap<String, Double> resistance) {
        this.value = resistance;
    }

}
