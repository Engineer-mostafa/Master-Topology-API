package com.example.Topology.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class NMOS extends Transistor{

    public HashMap<String, Double> getM() {
        return m;
    }

    public void setM(HashMap<String, Double> m) {
        this.m = m;
    }

    HashMap<String, Double> m;

    public NMOS(String type ,
                String id ,
                HashMap<String, Double> m ,
                HashMap<String, String> netlist){
        super(type ,  id  ,  netlist);
        this.m = m;
    }

}
