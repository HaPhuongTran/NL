package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.TemperatureDecive;
import com.sm.service.TemperatureDeciveService;

@RestController
@CrossOrigin
@RequestMapping("/smarthome")
public class TemperatureDeciveController {
	@Autowired
	TemperatureDeciveService temperatureDeciveService;
	
	@RequestMapping(value = "/createttemperaturedecive", method = RequestMethod.POST, headers = "application/json")
	public ResponseEntity<HttpStatus> createTemperatureDecive(@RequestBody TemperatureDecive temperatureDecive) {
		temperatureDeciveService.saveOrUpdate(temperatureDecive);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
