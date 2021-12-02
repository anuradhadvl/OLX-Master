package com.olx.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.olx.dto.Category;
import com.olx.entity.CategoryEntity;

public class MasterDataConverter {
	
	
	@Autowired
	ModelMapper modelMapper;
	
	private static MasterDataConverter masterDataConverter;
	
	/*
	public static MasterDataConverter getInCategory categoryDto = this.modelMapper.map(categoryEntity, Category.class);
		return categoryDto;stance() {
		if(masterDataConverter==null) {
			masterDataConverter = new MasterDataConverter();
		}
		return masterDataConverter;
	}
	*/
	public  Category convertCategoryEntityIntoCategoryDto(CategoryEntity categoryEntity){
		
		/*
		Category categoryDto = new Category();
		categoryDto.setId(categoryEntity.getId());
		categoryDto.setCategory(categoryEntity.getCategory());
		*/
		
		return null;
	}

}
