package com.olx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;

@RestController
@RequestMapping("olx")
public class MasterDataController {
	@Autowired
	private MasterDataService masterDataService;
	
	@GetMapping(value="/advertise/category",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Category> getAllCategories(){
		List<Category>categories = masterDataService.getAllCategories();
		return new ResponseEntity(categories, HttpStatus.FOUND);
	}
	
	@GetMapping(value="/advertise/status",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<Status> getAllStatus(){
		List<Status> status = masterDataService.getAllStatus();
		return new ResponseEntity(status, HttpStatus.FOUND);
	}
	
	@GetMapping(value="/advertise/status/{id}",produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<Status> getStatusById(@PathVariable("id") int statusId){
		Status status = masterDataService.getStatusById(statusId);
		String statusText = status.getStatus();
		System.out.println(statusText);
		return new ResponseEntity(status.getStatus(), HttpStatus.FOUND);
	}
	
	@GetMapping(value="/advertise/category/{id}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int categoryId){
		Category category = masterDataService.getCategoryById(categoryId);
		String categoryText = category.getCategoryName();
		System.out.println(categoryText);
		return new ResponseEntity(category.getCategoryName(), HttpStatus.FOUND);
	}

}
