package com.example.Topology.models;

import java.util.HashMap;

public abstract class Transistor extends Device{


    public Transistor(String type, String id, HashMap<String, String> netlist) {
        super(type , id , netlist);
    }
}
