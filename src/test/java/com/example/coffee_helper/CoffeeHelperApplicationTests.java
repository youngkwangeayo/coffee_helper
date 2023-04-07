package com.example.coffee_helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import com.example.coffee_helper.controller.MainController;
import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.ChartBestFiveDTO;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractInfoDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.dto.TtDTO;
import com.example.coffee_helper.entity.BestCondition;
import com.example.coffee_helper.entity.ChartBestFive;
import com.example.coffee_helper.entity.Extract;
import com.example.coffee_helper.entity.ExtractMent;
import com.example.coffee_helper.entity.ExtractResultMent;
import com.example.coffee_helper.entity.SettingCondition;
import com.example.coffee_helper.entity.TestC;
import com.example.coffee_helper.entity.Tt;
import com.example.coffee_helper.extractSoftware.ExtractSoftService;
import com.example.coffee_helper.mapper.ExtractMapper;
import com.example.coffee_helper.mapper.board.ExtractBoardMapper;
import com.example.coffee_helper.mapper.chart.ChartMapper;
import com.example.coffee_helper.mapper.condition.BestConditionMapper;
import com.example.coffee_helper.mapper.member.UserMapper;
import com.example.coffee_helper.service.BestConditionService;
import com.example.coffee_helper.service.ExtractFeedbackServiceImpl;
import com.example.coffee_helper.service.ExtractMentService;
import com.example.coffee_helper.service.ExtractSerive;
import com.example.coffee_helper.service.ParserService;
import com.example.coffee_helper.service.StandardExtract;
import com.example.coffee_helper.service.board.ExtractBoardService;
import com.example.coffee_helper.mapper.testMapper.TestDMapper;
import com.example.coffee_helper.mapper.testMapper.Test_cMapper;
import com.example.coffee_helper.service.member.user.UserServiceImpl;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import lombok.extern.log4j.Log4j2;

import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.User;

@SpringBootTest
@Log4j2
class CoffeeHelperApplicationTests {

	
	@Autowired
	BCryptPasswordEncoder encoder;


	@Autowired
	BestConditionMapper conditionMapper;
	@Autowired
	BestConditionService conditionService;
	
	@Autowired
	ExtractSoftService soft;

	@Autowired
	ExtractFeedbackServiceImpl feedback;

	@Autowired
	ParserService parserService;
	
    @Autowired
    StandardExtract standardExtract;

	@Autowired
	ExtractMentService mentService;

	@Autowired
	UserMapper userMapper;

	@Autowired
	ExtractSerive extractSerive;

	@Autowired
	ExtractMapper extractMapper;

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
		List<BestCondition>list = conditionMapper.findSettingCondition();
		assertNull(list);
		// assertNotNull(list);
		// Boolean d =conditionMapper.checkSetting();
		// assertNull(d);
	}
	@Test
	void conditionServiceTest(){
		List<BestConditionDTO>list=conditionService.findAllCondition();
		assertNotNull(list);
		// assertNull(list);

	}

	@Test
	void rowOrOver(){
		int r=standardExtract.optionRow("extraction amount");
		assertNotNull(r);
		// assertNull(r)
		r = standardExtract.optionOver("extraction amount");
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

	
	@Autowired
    UserServiceImpl userService;

	@Test
	void userTest(){
		UserDTO d = userService.nameToRole("임영광");
		// User d = userService.nameToRole2("임영광");		
		

		assertNull(d);
	}



	@Test
	void ParserTest(){
		ExtractMent m = ExtractMent.builder()
		.ment("gd")
		.build();
		ModelMapper modelMapper = new ModelMapper();	



		// ExtractMentDTO d= modelMapper.map(m, ExtractMentDTO.class);
		ExtractMentDTO d =new ExtractMentDTO();
		d=(ExtractMentDTO)parserService.parseDomain(m,d);
		assertNull(d);

		// 
		// List<PostDto.Get> collect = 
		// allPost.stream().map(p -> modelMapper.map(p, PostDto.Get.class)).collect(Collectors.toList());
		
		// List<PostDto.Get> postList = 
        // modelMapper.map(allPost, new TypeToken<List<PostDto.Get>>() {}.getType());
	}

	@Test
	void ee(){
		List<ExtractMentDTO>list=mentService.findMents(3);
		assertNull(list);
	}

	@Autowired
	ExtractFeedbackServiceImpl feedbackService;

	
	ModelMapper modelMapper = new ModelMapper();

	@Test
	void sss(){
		ExtractDTO d=soft.extractSoft();
		Extract e = modelMapper.map(d, Extract.class);
		
		// int r=mentService.findEqaulsId();
		// List<ExtractMentDTO> s=feedbackService.feedbakMent(d);
		// assertNull(r);

	}

	@Test
	void dfff(){
		UserDTO user=userService.findUserInfo("임영광");
		// User user=userMapper.findUserInfo("임영광");

		assertNull(user);

	}
	
	@Test
	void fffss(){
		ExtractResultMent s = ExtractResultMent.builder()
		.mentId(15)
		.extractId(1)
		.build();

		// int r = extractMapper.saveExtractSaveMent(s);
	
	}

	@Test
	void sfssfffss(){
		Extract e = Extract.builder()
		.beenAmount(4)
		.extractAmount(5)
		.extractTime(2)
		.userId(1)
		.build();


		ExtractResultMent s = ExtractResultMent.builder()
		.mentId(15)
		.extractId(1)
		.build();

		
		int r =extractMapper.saveMachineExtract(e);
		
	}
	@Autowired
	ExtractBoardMapper boardMapper;
	@Autowired
	ExtractBoardService boardService;
	@Test
	void pageTest(){
		PageRequestDTO dto = PageRequestDTO.builder()
		.build();		List<ExtractInfoDTO> dd=boardMapper.findExtractInfoOfUser(dto, 1);


		// =boardService.findBList(dto, 1);
		// int r = boardMapper.boardCount();
		
		// PageResponseDTO rs = new PageResponseDTO<>(dto, b, r);
		assertNull(dd);
	}

	@Test
	void testDTOENTITY(){
		TtDTO d = TtDTO.builder().d(2).id(1).is("굳").build();
		Tt e =modelMapper.map(d, Tt.class);
		assertNull(e);

		
	}

	@Autowired
	ChartMapper chartMapper;

	@Test
	void testDTO(){
		List<ChartBestFive> c = chartMapper.chartBestFive();
		// List<ChartBestFive> c = cMapper.testFive();
		assertNull(c);
	}


	
	@Test
	void pMapperTest(){
		// boardMapper.findExtractInfoOfUser(null, 0)

	}

	@Test
	void settingTest(){
		SettingCondition s = SettingCondition.builder()
		.amountOver(40).amountRow(32)
		.timeOver(36).timeRow(28)
		.beenOver(22).beenRow(12).build();

		conditionMapper.settingOptionChang(s);
		

	}

	@Test
	void joinTest(){
		User user = User.builder()
		.email("fake2@fak2")
		.password(encoder.encode("asf"))
		.username("임영광")
		.build();
		userMapper.findByUserEmail(user.getEmail());
		userMapper.findByUsername(user.getUsername());
		userMapper.join(user);
		
	}

}//classEnd

