package com.example.coffee_helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.coffee_helper.controller.MainController;
import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.entity.BestCondition;
import com.example.coffee_helper.entity.TestC;
import com.example.coffee_helper.extractSoftware.ExtractSoftService;
import com.example.coffee_helper.mapper.BestConditionMapper;
import com.example.coffee_helper.mapper.Test_cMapper;
import com.example.coffee_helper.service.BestConditionService;
import com.example.coffee_helper.service.ExtractFeedbackServiceImpl;
import com.example.coffee_helper.mapper.TestDMapper;

@SpringBootTest
class CoffeeHelperApplicationTests {

	@Autowired
	BestConditionMapper conditionMapper;
	@Autowired
	BestConditionService conditionService;
	
	@Autowired
	ExtractSoftService soft;

	@Autowired
	ExtractFeedbackServiceImpl feedback;



	@Test
	void contextLoads() {
	}


	@Autowired
	Test_cMapper cMapper;
	@Autowired
	TestDMapper dMapper;

	@Test
	void mapperTest(){
		TestC c=cMapper.findALl();
		TestC c2=cMapper.findAll2();
		// assertNull(c2);
		assertNotNull(c2);
	}

	@Test
	void condition(){
		List<BestCondition>list = conditionMapper.findAllCondition();
		assertNotNull(list);
	}
	@Test
	void conditionServiceTest(){
		List<BestConditionDTO>list=conditionService.findAllCondition();
		assertNotNull(list);
		// assertNull(list);

	}

	@Test
	void rowOrOver(){
		int r=feedback.optionRow("extraction amount");
		assertNotNull(r);
		// assertNull(r)
		r = feedback.optionOver("extraction amount");
		// assertNull(r);	
		assertNotNull(r);
		
	}
	@Test
	void conditionServiceTestdd(){
		// MainController c = new MainController();
		// int r=c.tq();
		// assertNotNull(r);

	}

	@Test
	void mapperTest2(){
		
		TestC c2=dMapper.findAll2();
		// assertNull(c2);
		assertNotNull(c2);
	}

	@Test
	void softTest(){
		
		ExtractDTO d =  soft.extractSoft();
		assertNull(d);
	}

}//classEnd

