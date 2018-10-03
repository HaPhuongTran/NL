package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.HumidityDecive;
import com.sm.service.HumidityDeciveService;

@RestController
@CrossOrigin
@RequestMapping("/smarthome")
public class HumidityDeciveController {
	
	@Autowired
	HumidityDeciveService humidityDeciveService;
	
	@RequestMapping(value = "/createhumiditydecive", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<HttpStatus>createHumidityDecive(@RequestBody HumidityDecive humidityDecive){
		humidityDeciveService.saveOrUpdate(humidityDecive);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
