package com.example.coffee_helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.coffee_helper.entity.TestC;
import com.example.coffee_helper.mapper.Test_cMapper;

@SpringBootTest
class CoffeeHelperApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	Test_cMapper cMapper;


	@Test
	void mapperTest(){
		TestC c=cMapper.findALl();
		
	}
}
