/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.AddressModel;
import entity.Building;
import Model.BuildingModel;
import Model.FloorModel;
import java.util.List;
import java.util.ArrayList;
import Util.HibernateUtil;
import entity.Floor;
import entity.FloorId;
import java.beans.Expression;
import java.util.HashSet;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ShaileshKushwaha
 */
public class BuildingDAOImpl implements BuildingDAO {

    @Override
    public List<BuildingModel> getBuildings(String keywords) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Building> buildingList = new ArrayList<Building>();
        List<Floor> floorList = new ArrayList<Floor>();
        try {
            session.beginTransaction();
            Criteria buildingcr = session.createCriteria(Building.class);
            buildingcr.add(Restrictions.like("name", "%" + keywords + "%")).addOrder(Order.asc("BId"));

            buildingList = buildingcr.list();
            Criteria floorcr = session.createCriteria(Floor.class);
            HashSet<Integer> uniquesBuildingIds = getUniqueID(buildingList);
            floorcr.add(Restrictions.in("id.BId", uniquesBuildingIds)).addOrder(Order.asc("id.BId"));;
            floorList = floorcr.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //check if nothing is returned for the entered keyword
        List<BuildingModel> buildingModelList = new ArrayList<BuildingModel>();
        
        if(buildingList.size()==0){
            return buildingModelList;
        }
        //List<BuildingModel> buildingModelList = new ArrayList<BuildingModel>();
        List<ArrayList<FloorModel>> floorModelList = new ArrayList<ArrayList<FloorModel>>();
        ArrayList<FloorModel> singleFloor = new ArrayList<FloorModel>();
        int id = floorList.get(0).getId().getBId();

        for (int i = 0; i < floorList.size(); i++) {
            if (id == floorList.get(i).getId().getBId()) {
                singleFloor.add(new FloorModel(floorList.get(i).getId().getBId(), floorList.get(i).getId().getFloorNumber(), floorList.get(i).getRooms()));
            } else {
                id = floorList.get(i).getId().getBId();
                floorModelList.add(singleFloor);
                singleFloor = new ArrayList<FloorModel>();
                singleFloor.add(new FloorModel(floorList.get(i).getId().getBId(), floorList.get(i).getId().getFloorNumber(), floorList.get(i).getRooms()));
            }
        }
        floorModelList.add(singleFloor);
        for (int i = 0; i < buildingList.size(); i++) {
            BuildingModel model = new BuildingModel();
            model.setFloors(floorModelList.get(i));
            model.setName(buildingList.get(i).getName());
            model.setId(buildingList.get(i).getBId());
            model.setAddressline(new AddressModel(buildingList.get(i).getAddress(), buildingList.get(i).getCity(), buildingList.get(i).getState(), buildingList.get(i).getZip()));
            buildingModelList.add(model);
        }
        return buildingModelList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BuildingModel> getAllBuildings() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Building> buildingList = new ArrayList<Building>();
        try {
            session.beginTransaction();
            buildingList = session.createCriteria(Building.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        List<BuildingModel> buildingModelList = new ArrayList<BuildingModel>();

        for (int i = 0; i < buildingList.size(); i++) {
            BuildingModel model = new BuildingModel();
//            model.setFloors(buildingList.get(i).getFloors());
            //          model.setRooms(buildingList.get(i).getRooms());
            model.setName(buildingList.get(i).getName());
            model.setId(buildingList.get(i).getBId());
            model.setAddressline(new AddressModel(buildingList.get(i).getAddress(), buildingList.get(i).getCity(), buildingList.get(i).getState(), buildingList.get(i).getZip()));
            buildingModelList.add(model);
        }
        return buildingModelList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BuildingModel getBuilding(int bid) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Building> buildingList = new ArrayList<Building>();
        List<Floor> floorList = new ArrayList<Floor>();
        try {
            session.beginTransaction();
            Criteria buildingcr = session.createCriteria(Building.class);
            buildingcr.add(Restrictions.eq("BId", bid)).addOrder(Order.asc("BId"));

            buildingList = buildingcr.list();
            Criteria floorcr = session.createCriteria(Floor.class);
            HashSet<Integer> uniquesBuildingIds = getUniqueID(buildingList);
            floorcr.add(Restrictions.in("id.BId", uniquesBuildingIds)).addOrder(Order.asc("id.BId"));;
            floorList = floorcr.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        List<BuildingModel> buildingModelList = new ArrayList<BuildingModel>();
        List<ArrayList<FloorModel>> floorModelList = new ArrayList<ArrayList<FloorModel>>();
        ArrayList<FloorModel> singleFloor = new ArrayList<FloorModel>();
        int id = floorList.get(0).getId().getBId();

        for (int i = 0; i < floorList.size(); i++) {
            if (id == floorList.get(i).getId().getBId()) {
                singleFloor.add(new FloorModel(floorList.get(i).getId().getBId(), floorList.get(i).getId().getFloorNumber(), floorList.get(i).getRooms()));
            } else {
                id = floorList.get(i).getId().getBId();
                floorModelList.add(singleFloor);
                singleFloor = new ArrayList<FloorModel>();
                singleFloor.add(new FloorModel(floorList.get(i).getId().getBId(), floorList.get(i).getId().getFloorNumber(), floorList.get(i).getRooms()));
            }
        }
        floorModelList.add(singleFloor);
        for (int i = 0; i < buildingList.size(); i++) {
            BuildingModel model = new BuildingModel();
            model.setFloors(floorModelList.get(i));
            model.setName(buildingList.get(i).getName());
            model.setId(buildingList.get(i).getBId());
            model.setAddressline(new AddressModel(buildingList.get(i).getAddress(), buildingList.get(i).getCity(), buildingList.get(i).getState(), buildingList.get(i).getZip()));
            buildingModelList.add(model);
        }
        return buildingModelList.get(0);
    }

    @Override
    public void removeBuilding(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            session.beginTransaction();
            Criteria cr = session.createCriteria(Building.class);
            cr.add(Restrictions.eq("BId", id));
            List<Building> buildingList = new ArrayList<Building>();
            buildingList = cr.list();
            //get list of floor for the selected building
            Criteria fcr = session.createCriteria(Floor.class);
            fcr.add(Restrictions.eq("id.BId", id));
            List<Floor> floorList = new ArrayList<Floor>();
            floorList = fcr.list();
            //delete building
            session.delete(buildingList.get(0));
            //delete floors
            for (int i = 0; i < floorList.size(); i++) {
                session.delete(floorList.get(i));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void updateBuilding(BuildingModel buildingModel) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Building building = new Building();
        building.setBId(buildingModel.getId());
        building.setName(buildingModel.getName());
        building.setAddress(buildingModel.getAddressline().getAddress());
        building.setCity(buildingModel.getAddressline().getCity());
        building.setState(buildingModel.getAddressline().getState());
        building.setZip(buildingModel.getAddressline().getZip());
        try {
            session.beginTransaction();
            session.update(building);
            for (int i = 0; i < buildingModel.getFloors().size(); i++) {
                session.update(new Floor(new FloorId(buildingModel.getId(), buildingModel.getFloors().get(i).getFloorNumber()),
                        buildingModel.getFloors().get(i).getRoomNumber()));
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void createBuilding(BuildingModel buildingModel) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Building building = new Building();
//        building.setFloors(buildingModel.getFloors());
        //      building.setRooms(buildingModel.getRooms());
        building.setBId(buildingModel.getId());
        building.setName(buildingModel.getName());
        building.setAddress(buildingModel.getAddressline().getAddress());
        building.setCity(buildingModel.getAddressline().getCity());
        building.setState(buildingModel.getAddressline().getState());
        building.setZip(buildingModel.getAddressline().getZip());
        try {
            session.beginTransaction();
            session.save(building);
            for (int i = 0; i < buildingModel.getFloors().size(); i++) {
                session.update(new Floor(new FloorId(buildingModel.getId(), buildingModel.getFloors().get(i).getFloorNumber()),
                        buildingModel.getFloors().get(i).getRoomNumber()));
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    private HashSet<Integer> getUniqueID(List<Building> buildingList) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (int i = 0; i < buildingList.size(); i++) {
            ids.add(buildingList.get(i).getBId());
        }
        HashSet<Integer> uniqueBuildingID = new HashSet<Integer>(ids);
        return uniqueBuildingID;
    }
}
