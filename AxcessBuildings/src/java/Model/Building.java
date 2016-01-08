/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ShaileshKushwaha
 */
public class Building {

    String name;
    Address addressline;
    int floors;
    int rooms;
    int id;

    public Building() {

    }

    public Building(String name, Address addressline, int floors, int rooms, int id) {
        this.name = name;
        this.addressline = addressline;
        this.floors = floors;
        this.rooms = rooms;
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

    public Address getAddressline() {
        return addressline;
    }

    public void setAddressline(Address addressline) {
        this.addressline = addressline;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

}
