package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentBookDto {

	private long rent_seq;//	BIGINT		PRIMARY KEY
	private String rent_date;//	VARCHAR(10)	NOT NULL	
	private String rent_return_date;//	VARCHAR(10)	NOT NULL	
	private String rent_bcode;//	VARCHAR(13)	NOT NULL	
	private String rent_mcode;//	VARCHAR(6)	NOT NULL	
	private String rent_return_yn;//	VARCHAR(1)		
	private int rent_point;//	INT		
	private int rent_price;//	INT		

}
