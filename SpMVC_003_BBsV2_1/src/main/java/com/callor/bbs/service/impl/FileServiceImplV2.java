package com.callor.bbs.service.impl;

import java.io.File;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.bbs.config.QualifierConfig;

import lombok.extern.slf4j.Slf4j;

/*
 *  V1 클래스에는 fileUp(), filsUp(), delete() method 가 있다.
 *  이 method 들을 기본적으로 상속받아서 사용하겠다.
 *  
 *  V1 클래스의 protected 로 선언된 2개의 변수(객체)를 여기에서
 *  상속받아서 사용하곘다.
 *  
 *  클래스를 상속받을때 V1 클래스의 생성자는 상속받지 않는다.
 */

@Slf4j
// Spring Project 에서 Qualifier : Bean 의 id, 이름
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 extends FileServiceImplV1{
	
	// fileup-context.xml 에 선언된 2개의 String bean 값을 
	// 사용할 수 있게 주입해달라
	protected final String windowsPath;
	protected final String winPath;
	protected final String macHome;
	protected final String macPath;
	public FileServiceImplV2(ResourceLoader resource, 
			String windowsPath,String winPath, String macHome, String macPath) {

		/*
		 *  super()
		 *  상속받은 클래스의 생성자에게 무언가 전달할 때 사용하는 method
		 *  일종의 전달자
		 *  V1 클래스의 생성자에게 resource 객체를 전달하여
		 *  final 로 선언된 2개의 변수(객체)를 초기화 해달라고 요청
		 */
		super(resource);
		
		this.windowsPath = windowsPath;
		this.winPath = winPath;
		this.macHome = macHome;
		this.macPath = macPath;
	}
	
	/*
	 *  V1.fileUp() method 를 다시 정의하겠다.
	 */
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		log.debug("winPath : {} ", winPath);
		log.debug("macPath : {} ", macPath);
		
//		String fileUpPath = winPath;
//		File path = new File(macHome);
//		
//		// macHome 폴더가 있느랴?
//		if(path.exists()) {
//			fileUpPath = macHome + macPath;
//		}
		
		String fileUpPath = macHome + macPath;
		File path = new File(windowsPath);
		if(path.exists()) {
			fileUpPath = winPath;
		}
		
		// 만약 System 에 Upload 할 path 가 없으면 생성하라
		path = new File(fileUpPath);
		if(!path.exists()) {
			path.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		File upLoadFile = new File(fileUpPath, fileName);
		file.transferTo(upLoadFile);
		return fileName;
		
	}
	
}
