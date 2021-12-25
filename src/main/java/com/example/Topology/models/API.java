package com.example.Topology.models;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


public class API {


    // memory
    private final ArrayList<Topology> topologies;


    public API() {
        topologies = new ArrayList<>();
    }

    /**
     * @param {String} TopologyID
     * @returns required toplology
     */
    private Topology getTopology(String TopologyID) {

        for (Topology topology : topologies) {
            if (topology.id.equals(TopologyID)) {
                return topology;
            }
        }
        return null;
    }

    /**
     * @param {string} FileName
     * @return
     */
    public ArrayList<Topology> readJSON(String FileName) {
        try{


            ObjectMapper mapper = new ObjectMapper();


            Topology topology = mapper.readValue(new File("src/main/java/com/example/Topology/models/"+FileName+".json") , Topology.class);


            String newtopId = topology.getId();
            for (Topology t : topologies) {
                if (t.getId().equals(newtopId)) {
                    return topologies;
                }
            }

            HashMap currComponentToHash;
            ArrayList<Device> devices = new ArrayList<>();
            for (Object component : topology.getComponents()) {
                currComponentToHash = (HashMap)component;
                switch (currComponentToHash.get("type").toString()){
                    case "resistor":
                        Resistance r = new Resistance((String)currComponentToHash.get("type") ,
                                (String) currComponentToHash.get("id") ,
                                (HashMap<String, Double>) currComponentToHash.get("resistance"),
                                (HashMap<String, String>) currComponentToHash.get("netlist"));
                        devices.add(r);
                        break;
                    case "nmos":
                        NMOS nmos = new NMOS((String)currComponentToHash.get("type") ,
                                (String) currComponentToHash.get("id") ,
                                (HashMap<String, Double>) currComponentToHash.get("m"),
                                (HashMap<String, String>) currComponentToHash.get("netlist"));
                        devices.add(nmos);
                        break;
                    case "pmos":
                        PMOS pmos = new PMOS((String)currComponentToHash.get("type") ,
                                (String) currComponentToHash.get("id") ,
                                (HashMap<String, Double>) currComponentToHash.get("m"),
                                (HashMap<String, String>) currComponentToHash.get("netlist"));
                        devices.add(pmos);

                }
            }

            Topology memoTopology = new Topology();
            memoTopology.setComponents(devices);
            memoTopology.setId(topology.getId());
            topologies.add(memoTopology);

            System.out.println(topologies.size());

            return topologies;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    /**
     * @param {String} TopologyID
     * @returns to validate if we write or not
     */
    public boolean writeJSON(String TopologyID)  {

        try{
            for (Topology topology : topologies) {
                if(topology.getId().equals(TopologyID))
                {
                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = mapper.writeValueAsString(topology);

                    mapper.writeValue(new FileWriter("src/main/java/com/example/Topology/models/saveTopology.json"),
                            topology);
                    System.out.println("Hi");
                    break;
                }
            }


        }
        catch(Exception e){
           return false;
        }
        return true;
    }


    /**
     * @param
     * @returns list of topologies
     */
    public List<Topology> queryTopologies() {

        return topologies;
    }


    /**
     * @param TopologyID
     * @returns boolean to validate that the topology is deleted from memory or not
     */
    public Boolean deleteTopology(String TopologyID) {

        try {
            Topology delete_topology = getTopology(TopologyID);
            if (delete_topology == null) {
                System.out.println("We Don't have this topology so check id again");
                return false;
            }

            topologies.remove(delete_topology);
            return true;


        } catch (Exception e) {
            System.out.println("Some thing went wrong try again latter");
            return false;
        }
    }

    /**
     * @param {String} TopologyID
     * @returns list of devices in the topology
     */
    public ArrayList<Device> queryDevices(String TopologyID) {
        try {

            Topology topology = getTopology(TopologyID);
            if (topology == null) {
                System.out.println("We Don't have this topology so check id again");
                return null;
            }
            return topology.getComponents();

        } catch (Exception e) {
            System.out.println("Some thing went wrong try again latter");
            return null;
        }
    }


    /**
     * @param {String} TopologyID
     * @param {String} NetlistNodeID
     * @returns list of connected devices in specific Node in specific topology
     */
    public List<Device> queryDevicesWithNetlistNode(String TopologyID, String NetlistNodeID) {

        Topology topology = getTopology(TopologyID);
        if (topology == null) {
            System.out.println("We Don't have this topology so check id again");
            return new ArrayList<Device>();
        } else {
            try {
                return topology.getDevicesConnectedTo(NetlistNodeID );
            } catch (Exception e) {
                return new ArrayList<Device>();
            }

        }

    }
}
