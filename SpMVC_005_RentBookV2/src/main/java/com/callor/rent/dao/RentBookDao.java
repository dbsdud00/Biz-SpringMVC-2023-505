package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.RentBookVO;

public interface RentBookDao {
	public void create_rent_table(String dumy);
	
	public List<RentBookVO> selectAll();
	public RentBookVO findById(long id);
	public List<RentBookVO> findByBCode(String bcode);
	public List<RentBookVO> findByMCode(String mcode);
	public int insert(RentBookVO dto);
	public int update(RentBookVO dto);
}
