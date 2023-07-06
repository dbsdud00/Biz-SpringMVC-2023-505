package com.callor.todolist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.todolist.dao.TodoDao;
import com.callor.todolist.models.TodoDto;
import com.callor.todolist.service.TodoService;

@Service
public class TodoServiceImplV1 implements TodoService {
	
	final protected TodoDao todoDao;
	

	public TodoServiceImplV1(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	@Override
	public List<TodoDto> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}

	@Override
	public TodoDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(TodoDto dto) {
		// TODO Auto-generated method stub
		return todoDao.insert(dto);
	}

	@Override
	public int update(TodoDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
