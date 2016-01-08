/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Building;
import java.util.List;
/**
 *
 * @author ShaileshKushwaha
 */
public interface BuildingDAO {
    public List<Building> getBuildings(String keywords);
    public void removeBuilding(int id);
    public void updateBuilding(Building buildingModel);
    public void createBuilding(Building buildingModel);
     public List<Building> getAllBuildings();
}
