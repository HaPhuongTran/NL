package com.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.AC;
import com.sm.service.ACService;

@RestController
@CrossOrigin
@RequestMapping("/smarthome")
public class ACController {

	@Autowired
	ACService acService;
	
	@RequestMapping(value = "/createac", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<HttpStatus> createAC(@RequestBody AC ac) {
			acService.saveOrUpdate(ac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getlistac/{name_room}", method = RequestMethod.GET, headers="Accept=application/json")
	public List<AC> getListAC(@PathVariable("name_room") String roomName){
		return acService.getListAC(roomName);
	}
	
//	@RequestMapping(value = "/getac/{ip_ac}", method = RequestMethod.GET, headers="Accept=application/json")
//	public AC getAC(@RequestBody AC ac) {
//		return acService.getAC(ac);
//	}
}
