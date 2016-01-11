/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.BuildingModel;
import java.util.List;
/**
 *
 * @author ShaileshKushwaha
 */
public interface BuildingDAO {
    public List<BuildingModel> getBuildings(String keywords);
    public void removeBuilding(int id);
    public void updateBuilding(BuildingModel buildingModel);
    public void createBuilding(BuildingModel buildingModel);
     public List<BuildingModel> getAllBuildings();
}
