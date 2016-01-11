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
public class FloorModel {
    int buildingID;
    int floorNumber;
    int roomNumber;
    
    public FloorModel(){
        
    }
            
    public FloorModel(int buildingID, int floorNumber, int roomNumber) {
        this.buildingID = buildingID;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
}
