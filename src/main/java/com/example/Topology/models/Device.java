package com.example.Topology.models;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;



public abstract class Device {

    String type;
    String id;
    HashMap<String, String> netlist;

    public Device(String type,
           String id,
           HashMap<String, String> netlist) {
        this.type = type;
        this.id = id;
        this.netlist = netlist;
    }


    public Device(){}

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setNetlist(HashMap<String, String> netlist) {
        this.netlist = netlist;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }


    public HashMap<String, String> getNetlist() {
        return netlist;
    }


}
