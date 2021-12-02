package com.olx.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.olx.dto.Category;
import com.olx.dto.Status;

public interface MasterDataService {
	public List<Category>getAllCategories();
	public List<Status> getAllStatus();
	public Status getStatusById(int statusId);
	public Category getCategoryById(int categoryId);

}
