package com.sathwik.shopspring.services.admin.category;

import java.util.List;

import com.sathwik.shopspring.dto.CategoryDto;
import com.sathwik.shopspring.model.Category;

public interface CategoryService {
	 Category createCategory(CategoryDto categoryDto);
	 List<Category> getAllCategory();
}
