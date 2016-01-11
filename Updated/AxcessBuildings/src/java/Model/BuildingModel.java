/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ShaileshKushwaha
 */
public class BuildingModel {

    String name;
    AddressModel addressline;
    List<FloorModel> floors;
    int id;

    public BuildingModel() {
        //floors = new ArrayList<FloorModel>();
        //floors.add(new FloorModel(this.id, 1, 1));
    }

    public BuildingModel(String name, AddressModel addressline, List<FloorModel> floors, int id) {
        this.name = name;
        this.addressline = addressline;
        this.floors = floors;      
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressModel getAddressline() {
        return addressline;
    }

    public void setAddressline(AddressModel addressline) {
        this.addressline = addressline;
    }

    public List<FloorModel> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorModel> floors) {
        this.floors = floors;
    }

  

}
