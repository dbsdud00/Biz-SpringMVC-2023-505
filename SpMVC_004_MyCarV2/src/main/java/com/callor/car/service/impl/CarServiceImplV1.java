package com.callor.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.car.model.CarDto;
import com.callor.car.persistance.CarDao;
import com.callor.car.service.CarService;

@Service
public class CarServiceImplV1 implements CarService {

	protected final CarDao carDao;

	public CarServiceImplV1(CarDao carDao) {
		this.carDao = carDao;
	}



	@Override
	public CarDto findTachoByCarNum(String carnum) {
		// TODO Auto-generated method stub
		return carDao.findTachoByCarNum(carnum);
	}



	@Override
	public int insert(CarDto carDto) {
		// TODO Auto-generated method stub
		return carDao.insert(carDto);
	}



	@Override
	public List<CarDto> selectAll() {
		// TODO Auto-generated method stub
		return carDao.SelectAll();
	}
	
	
	/*
	 *  프로젝트가 시작될 때
	 *  method 에 매개변수를 자동 주입해 달라 라는 요청
	 */
	@Autowired
	public void create_table() {
		carDao.create_carm_table(null);
	}
	
	
	
	
	
	
}
