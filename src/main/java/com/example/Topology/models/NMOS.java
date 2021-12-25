package com.example.Topology.models;


import java.util.HashMap;


public class NMOS extends Transistor {

    public HashMap<String, Double> getM() {
        return m;
    }

    public void setM(HashMap<String, Double> m) {
        this.m = m;
    }

    HashMap<String, Double> m;

    /**
     * @param {String}  type
     * @param {String}  id
     * @param {HashMap} resistance
     * @param {HashMap} netlist
     */
    public NMOS(String type,
                String id,
                HashMap<String, Double> m,
                HashMap<String, String> netlist) {
        super(type, id, netlist);
        this.m = m;
    }

}
