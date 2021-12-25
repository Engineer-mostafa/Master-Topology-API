package com.example.Topology.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Resistance extends Device {

    HashMap<String, Double> resistance;


    public Resistance( String type,
                       String id,
                       HashMap<String, Double> resistance,
                       HashMap<String, String> netlist) {
        super(type ,  id  ,  netlist);
        this.resistance = resistance;
    }

    public HashMap<String, Double> getResistance() {
        return resistance;
    }

    public void setResistance(HashMap<String, Double> resistance) {
        this.resistance = resistance;
    }

}
