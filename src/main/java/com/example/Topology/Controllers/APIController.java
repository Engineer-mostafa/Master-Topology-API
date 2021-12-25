package com.example.Topology.Controllers;

import com.example.Topology.models.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
public class APIController {
    final API api = new API();
    FullResponse fullResponse = new FullResponse();

    @RequestMapping("/readJSON/{fileName}")
    public FullResponse readJSON(@PathVariable String fileName) throws FileNotFoundException {
        ArrayList topList = api.readJSON(fileName);
        if (topList != null) {
            fullResponse.setTopologyList(topList);
            fullResponse.setHelper(new Helper("200", "Success"));
        } else {
            fullResponse.setTopologyList(new ArrayList<Topology>());
            fullResponse.setHelper(new Helper("404", "something went wrong check filename again"));
        }

        return fullResponse;
    }

    @RequestMapping("/queryTopologies")
    public ArrayList<Topology> queryTopologies() throws FileNotFoundException {

        return (ArrayList<Topology>) api.queryTopologies();
    }

    @RequestMapping("/writeJSON/{topId}")
    public FullResponse writeJSON(@PathVariable String topId) throws FileNotFoundException {


        if(api.writeJSON(topId)){
            fullResponse.setHelper(new Helper("200" , "wrote successfully"));
        }
        else {
            fullResponse.setHelper(new Helper("404" , "Some thing went wrong check id again"));
        }
        return  fullResponse;

    }

    @RequestMapping("/deleteTopology/{topId}")
    public String deleteTopology(@PathVariable String topId) throws FileNotFoundException {

        return api.deleteTopology(topId) ? "Deleated Succefully" : "Some thing went wrong check id again";
    }

    @RequestMapping("/queryDevices/{topId}")
    public FullResponse queryDevices(@PathVariable String topId) throws FileNotFoundException {
        ArrayList topList = api.queryDevices(topId);
        if (topList != null) {
            fullResponse.setTopologyList(topList);
            fullResponse.setHelper(new Helper("200", "Success"));
        } else {
            fullResponse.setTopologyList(new ArrayList<Topology>());
            fullResponse.setHelper(new Helper("404", "something went wrong check filename again"));
        }

        return fullResponse;
    }

    @RequestMapping("/queryDevicesWithNetlistNode/{topId}/{node}")
    public FullResponse queryDevicesWithNetlistNode(@PathVariable String topId, @PathVariable String node) throws FileNotFoundException {

        System.out.println(topId + "\n" + node);
        ArrayList topList = (ArrayList) api.queryDevicesWithNetlistNode(topId, node);
        if (topList != null) {
            fullResponse.setTopologyList(topList);
            fullResponse.setHelper(new Helper("200", "Success"));
        } else {
            fullResponse.setTopologyList(new ArrayList<Topology>());
            fullResponse.setHelper(new Helper("404", "something went wrong check filename again"));
        }

        return fullResponse;
    }


}
