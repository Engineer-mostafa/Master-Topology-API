package com.example.Topology.models;

import java.util.HashMap;

public class PMOS extends Transistor {

    public HashMap<String, Double> getM() {
        return m;
    }


    public void setM(HashMap<String, Double> m) {
        this.m = m;
    }

    HashMap<String, Double> m;

    public PMOS(String type , String id , HashMap<String, Double> info , HashMap<String, String> netlist){
        super(type ,  id ,  netlist);
        this.m = info;
    }
}
