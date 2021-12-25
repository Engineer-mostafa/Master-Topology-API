package com.example.Topology.models;

import java.util.ArrayList;
import java.util.List;

public class FullResponse {

    List<Topology> topologyList;
    Helper meta;

    public FullResponse(List<Topology> topologyList, Helper helper) {
        this.meta = helper;
        this.topologyList = topologyList;
    }

    public FullResponse() {
        this.meta = new Helper();
        this.topologyList = new ArrayList<>();
    }

    public ArrayList getComponent(String topologyId) {
        for (Topology t : topologyList) {
            if (t.getId().equals(topologyId)) return t.getComponents();
        }
        return null;
    }

    public void setComponent(String topologyId, ArrayList component) {
        for (Topology t : topologyList) {
            if (t.getId().equals(topologyId)) {
                t.setComponents(component);
                return;
            }
        }
    }

    public void setDevices(String topologyId, ArrayList devices) {
        for (Topology t : topologyList) {
            if (t.getId().equals(topologyId)) {
                t.setComponents(devices);
                return;
            }
        }
    }

    public ArrayList getDevices(String topologyId) {
        for (Topology t : topologyList) {
            if (t.getId().equals(topologyId)) return t.getComponents();
        }
        return null;
    }

    public ArrayList<Topology> getTopologyList() {
        return (ArrayList<Topology>) this.topologyList;
    }

    public void setTopologyList(List<Topology> topologyList) {
        this.topologyList = topologyList;
    }

    public void addTopology(Topology t) {
        topologyList.add(t);
    }

    public void setHelper(Helper helper) {
        this.meta = helper;
    }

    public Helper getHelper() {
        return meta;
    }
}
