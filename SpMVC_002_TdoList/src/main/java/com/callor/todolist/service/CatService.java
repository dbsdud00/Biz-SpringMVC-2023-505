package com.callor.todolist.service;

import com.callor.todolist.models.CategoryDto;

public interface CatService extends TodoGeneric<CategoryDto, String>{
	public void printCategory();
}
