package com.study.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.study.spring.dto.CategoryDTO;
import com.study.spring.entities.Category;
import com.study.spring.repositories.CategoryRepository;
import com.study.spring.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());		
	}
	
	@Transactional(readOnly = true)
	public Object findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()-> new EntityNotFoundException("Entity Not Found"));
		return new CategoryDTO(entity);
	}
}
