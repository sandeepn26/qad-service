package com.qad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qad.db.service.IRoleDBService;

@RestController
public class ClientsController {
	
	@Autowired
	private IRoleDBService tradesDBService;
	
	@RequestMapping("/createrole") 
	public boolean clserror() {
		return tradesDBService.createRole();
	}

}
