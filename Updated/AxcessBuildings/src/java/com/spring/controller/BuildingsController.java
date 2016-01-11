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
import Model.AddressModel;
import entity.Building;
import Model.BuildingModel;
import Model.SearchModel;
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
        m.addAttribute("buildingList", buildingDAOImpl.getBuildings(""));
        return "index";
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String getBuildings(@ModelAttribute(value = "search")SearchModel s,Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        List<BuildingModel> buildingModelList = buildingDAOImpl.getBuildings(s.getKeyword());
        if(buildingModelList.isEmpty()){
            m.addAttribute("buildingResult",0 );
        } else{
            m.addAttribute("buildingResult",1 );
            m.addAttribute("buildingList",buildingModelList );
        }
        
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
        BuildingModel model= buildingDAOImpl.getBuilding(id);
        m.addAttribute("editBuilding",model);
        m.addAttribute("totalFloor",model.getFloors().size());
        return "editBuilding";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBuilding(@ModelAttribute(value = "building") BuildingModel building, Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        buildingDAOImpl.updateBuilding(building);
        return "redirect:search.htm";
    }

    @RequestMapping(value = "/newBuilding", method = RequestMethod.GET)
    public String redirectNewBuilding() {
        return "newBuilding";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBuilding(@ModelAttribute(value = "building") BuildingModel building, Model m) {
        BuildingDAOImpl buildingDAOImpl = new BuildingDAOImpl();
        buildingDAOImpl.createBuilding(building);
        return "redirect:search.htm";
    }

}
