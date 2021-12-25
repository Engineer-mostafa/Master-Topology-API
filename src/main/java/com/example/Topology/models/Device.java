package com.example.Topology.models;



import java.util.HashMap;



/**
 * Device class
 * */
public abstract class Device {

    String type;
    String id;
    HashMap<String, String> netlist;


    /**
     * @param  {String} type
     * @param  {String} id
     * @param {HashMap} netlist
     * */
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
