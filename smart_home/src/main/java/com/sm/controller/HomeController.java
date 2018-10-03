package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.HomeProject;
import com.sm.service.HomeService;

@RestController
@CrossOrigin
@RequestMapping("/smarthome")
public class HomeController {
	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = "/createhome", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<HttpStatus> createHome(@RequestBody HomeProject homeProject){
		homeService.createHome(homeProject);
        return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/gethome/{name_home}", method = RequestMethod.GET, headers="Accept=application/json")
	public HomeProject getHomeByName(@PathVariable("name_home") String name_home){
		HomeProject home =homeService.getHome(name_home);
        return home;
	}

}
