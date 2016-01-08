/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Address;
import entity.Buildings;
import Model.Building;
import java.util.List;
import java.util.ArrayList;
import Util.HibernateUtil;
import entity.BuildingsId;
import java.beans.Expression;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ShaileshKushwaha
 */
public class BuildingDAOImpl implements BuildingDAO {

    
     @Override
    public List<Building> getBuildings(String keywords) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Buildings> buildingList = new ArrayList<Buildings>();
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Buildings.class);
            cr.add(Restrictions.like("id.name", "%"+keywords+"%"));            
            buildingList = cr.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        List<Building> buildingModelList = new ArrayList<Building>();
        
        for(int i=0;i<buildingList.size();i++){
            Building model =  new Building();
            model.setFloors(buildingList.get(i).getFloors());
            model.setRooms(buildingList.get(i).getRooms());
            model.setName(buildingList.get(i).getId().getName());
            model.setId(buildingList.get(i).getId().getBId());
            model.setAddressline(new Address(buildingList.get(i).getAddress(),buildingList.get(i).getCity(),buildingList.get(i).getState(),buildingList.get(i).getZip()));
            buildingModelList.add(model);
        }
        return buildingModelList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Building> getAllBuildings() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Buildings> buildingList = new ArrayList<Buildings>();
        try {
            session.beginTransaction();
            buildingList = session.createCriteria(Buildings.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        List<Building> buildingModelList = new ArrayList<Building>();
        
        for(int i=0;i<buildingList.size();i++){
            Building model =  new Building();
            model.setFloors(buildingList.get(i).getFloors());
            model.setRooms(buildingList.get(i).getRooms());
            model.setName(buildingList.get(i).getId().getName());
            model.setId(buildingList.get(i).getId().getBId());
            model.setAddressline(new Address(buildingList.get(i).getAddress(),buildingList.get(i).getCity(),buildingList.get(i).getState(),buildingList.get(i).getZip()));
            buildingModelList.add(model);
        }
        return buildingModelList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Buildings getBuilding (int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         List<Buildings> buildingList = new ArrayList<Buildings>();
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Buildings.class);
            cr.add(Restrictions.eq("id.BId", id));            
            buildingList = cr.list();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return buildingList.get(0);
    }
    
    
    @Override
    public void removeBuilding(int id) {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       
        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Buildings.class);
            cr.add(Restrictions.eq("id.BId", id));  
            List<Buildings> buildingList = new ArrayList<Buildings>();
            buildingList = cr.list();
            session.delete(buildingList.get(0));
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }       
    }

    @Override
    public void updateBuilding(Building buildingModel) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Buildings building = new Buildings();
        building.setFloors(buildingModel.getFloors());
        building.setRooms(buildingModel.getRooms());
        building.setId(new BuildingsId(buildingModel.getId(), buildingModel.getName()));
        building.setAddress(buildingModel.getAddressline().getAddress());
        building.setCity(buildingModel.getAddressline().getCity());
        building.setState(buildingModel.getAddressline().getState());
        building.setZip(buildingModel.getAddressline().getZip());
        try {
            session.beginTransaction();
            session.update(building);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } 
    }
    
    @Override
    public void createBuilding(Building buildingModel) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Buildings building = new Buildings();
        building.setFloors(buildingModel.getFloors());
        building.setRooms(buildingModel.getRooms());
        building.setId(new BuildingsId(buildingModel.getId(), buildingModel.getName()));
        building.setAddress(buildingModel.getAddressline().getAddress());
        building.setCity(buildingModel.getAddressline().getCity());
        building.setState(buildingModel.getAddressline().getState());
        building.setZip(buildingModel.getAddressline().getZip());
        try {
            session.beginTransaction();
            session.save(building);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } 
    }
}
