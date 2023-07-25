package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.dao.RentBookDao;
import com.callor.rent.models.RentBookDto;
import com.callor.rent.service.RentBookService;

@Service
public class RentBookServiceImplV1 implements RentBookService {
	
	
	protected final RentBookDao rentBookDao;
	
	public RentBookServiceImplV1(RentBookDao rentBookDao) {
		super();
		this.rentBookDao = rentBookDao;
	}

	@Autowired
	public void create_table() {
		rentBookDao.create_rent_table(null);
	}

	@Override
	public List<RentBookDto> selectAll() {
		
		return rentBookDao.selectAll();
	}

	@Override
	public int insert(RentBookDto rentBookDto) {
		
		return rentBookDao.insert(rentBookDto);
	}
	
}
