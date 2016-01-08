/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.BuildingDAOImpl;
import Model.Address;
import entity.Buildings;
import Model.Building;
import Model.Search;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author ShaileshKushwaha
 */
@Controller
@RequestMapping(value = "")
public class BuildingsController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getBuildings(Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();       
        m.addAttribute("buildingList", buildingDAOImpl.getAllBuildings());
        return "index";
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String getBuildings(@ModelAttribute(value = "search")Search s,Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();       
        m.addAttribute("buildingList", buildingDAOImpl.getBuildings(s.getKeyword()));
        return "index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBuildings(@RequestParam(value = "id") int id) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        // Buildings building = buildingDAOImpl.getBuilding(id);
        buildingDAOImpl.removeBuilding(id);
        return "redirect:search.htm";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String redirectUpdateBuilding(@RequestParam(value = "id") int id, Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        Buildings building = buildingDAOImpl.getBuilding(id);
        Building model = new Building();
        model.setFloors(building.getFloors());
        model.setRooms(building.getRooms());
        model.setName(building.getId().getName());
        model.setId(building.getId().getBId());
        model.setAddressline(new Address(building.getAddress(),building.getCity(),building.getState(),building.getZip()));
           
        m.addAttribute("editBuilding",model);
        return "editBuilding";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBuilding(@ModelAttribute(value = "building") Building building, Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        buildingDAOImpl.updateBuilding(building);
        return "redirect:search.htm";
    }

    @RequestMapping(value = "/newBuilding", method = RequestMethod.GET)
    public String redirectNewBuilding() {
        return "newBuilding";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBuilding(@ModelAttribute(value = "building") Building building, Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        buildingDAOImpl.createBuilding(building);
        return "redirect:search.htm";
    }

}
