package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;
import com.olx.entity.StatusEntity;
import com.olx.repository.CategoryRepository;

import com.olx.repository.StatusRepository;
import com.olx.utils.MasterDataConverter;

@Service
public class MasterDataServiceImpl implements MasterDataService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Category> getAllCategories() {
		
		List<CategoryEntity>categoryEntities = categoryRepository.findAll();
		List<Category>categoriesDtoList = new ArrayList<Category>();
		for(CategoryEntity categoryEntity : categoryEntities) {
			
		/*	TypeMap<CategoryEntity, Category>typeMap =this.modelMapper.typeMap(CategoryEntity.class, Category.class);
			typeMap.addMappings((mapper)->{mapper.map(source->source.getCategoryName(), Category::setCategoryName);
			});*/
			Category categoryDto = this.modelMapper.map(categoryEntity, Category.class);
			
			categoriesDtoList.add(categoryDto);
			//System.out.println(categoryDto);
		}
		return  categoriesDtoList;
	}

	@Override
	public List<Status> getAllStatus() {
		List<StatusEntity>statusEntities = statusRepository.findAll();
		List<Status>statusList = new ArrayList<Status>();
		for(StatusEntity statusEntity : statusEntities) {
			Status statusDto = new Status();
			statusDto.setId(statusEntity.getId());
			statusDto.setStatus(statusEntity.getStatus());
			statusList.add(statusDto);
			/*Status statusDto = this.modelMapper.map(statusEntity, Category.class); 
			statusList.add(statusDto);*/
		}
		
		return statusList;
		
	}

	@Override
	public Status getStatusById(int statusId) {
		Optional<StatusEntity> opStatEntity = statusRepository.findById(statusId);
		if(opStatEntity.isPresent()) { //Correct advertisementId
			StatusEntity statEntity = opStatEntity.get();
			Status statDto = this.modelMapper.map(statEntity, Status.class);
			
			return statDto;
		}
		return null;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Optional<CategoryEntity> opCategoryEntity = categoryRepository.findById(categoryId);
		if(opCategoryEntity.isPresent()) { //Correct categoryId
			CategoryEntity categoryEntity = opCategoryEntity.get();
			Category catDto = this.modelMapper.map(categoryEntity, Category.class);
			
			return catDto;
		}
		return null;
	}
	

}
