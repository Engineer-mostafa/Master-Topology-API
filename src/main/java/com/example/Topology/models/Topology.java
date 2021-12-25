package com.example.Topology.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;
public class Topology {

    String id;


    ArrayList<Device> components;



    public Topology() {
        this.components = new ArrayList();

        System.out.println(components);

    }

    public Topology(String id, ArrayList topComponent) {
        this.components = topComponent;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComponents(ArrayList topComponent) {
        this.components = topComponent;
    }

    public ArrayList getDevicesConnectedTo(String NetlistNodeID) {


        ArrayList<Device> connectedDevices = new ArrayList<Device>();

        components.forEach(device -> {
            if (isConnectedToNode(device, device.getNetlist(), NetlistNodeID)) {
                connectedDevices.add(device);
            }
        });

            return connectedDevices;


    }

    private boolean isConnectedToNode(Device currDevice,
                                      HashMap<String, String> netlistOfDevice,
                                      String NetlistNodeID) {
        try {
            switch (currDevice.getType()) {
                case "resistor":
                case "battery":
                    System.out.println(netlistOfDevice.get("t2"));
                    if (netlistOfDevice.get("t1").equals(NetlistNodeID)
                            || netlistOfDevice.get("t2").equals(NetlistNodeID)) {
                        return true;
                    }
                    break;
                case "pmos":
                case "nmos":
                    System.out.println(netlistOfDevice.get("drain"));
                    if (netlistOfDevice.get("drain").equals(NetlistNodeID)
                            || netlistOfDevice.get("gate").equals(NetlistNodeID)
                            || netlistOfDevice.get("source").equals(NetlistNodeID)) {
                        return true;
                    }
                    break;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public ArrayList getComponents() {
        return this.components;
    }
}
