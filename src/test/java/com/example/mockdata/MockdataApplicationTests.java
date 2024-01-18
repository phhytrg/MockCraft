package com.example.mockdata;

import com.example.mockdata.domain.EDataType;
import com.example.mockdata.domain.generating_from_data.UniversityInVietnam;
import com.example.mockdata.service.impl.MockDataGenerateService;
import com.example.mockdata.service.impl.MockDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MockdataApplicationTests {

//	@Test
//	void contextLoads() {
//
//	}
//	@Autowired
//	private MockDataServiceImpl mockDataService;
//
//	@Autowired
//	private MockDataGenerateService mockDataGenerateService;
//
//	@Test
//	public void loadSampleDataTest() {
//		mockDataService.insertData("classpath:titles.csv", EDataType.TITLE);
//		mockDataService.insertData("classpath:colors.csv", EDataType.COLOR);
//		mockDataService.insertData("classpath:companies.csv", EDataType.COMPANY);
//		mockDataService.insertData("classpath:departments.csv", EDataType.DEPARTMENT);
//		mockDataService.insertData("classpath:job-titles.csv", EDataType.JOB_TITLE);
//		mockDataService.insertData("classpath:languages.csv", EDataType.LANGUAGE);
//		mockDataService.insertData("classpath:vietnam-universities.csv", EDataType.VIETNAM_UNIVERSITY);
//		mockDataService.insertData("classpath:vietnamese-firstnames.csv", EDataType.VIETNAMESE_FIRSTNAME);
//		mockDataService.insertData("classpath:vietnamese-lastnames.csv", EDataType.VIETNAMESE_LASTNAME);
//	}
//
//	@Test
//	public void getSampleDataTest() {
//		mockDataService.getDataByClass(UniversityInVietnam.class.getName())
//				.forEach((item) -> System.out.println(item.getData()));
//	}

//	@Test
//	public void createInstance(){
//		System.out.println(mockDataService.createInstance(EDataType.HEX_COLOR).getData());
//	}

//	@Test
//	public void test(){
//		Map<String, EDataType> attributes = new HashMap<>();
//		attributes.put("firstname", EDataType.VIETNAMESE_FIRSTNAME);
//		attributes.put("lastname", EDataType.VIETNAMESE_LASTNAME);
//		System.out.println(mockDataGenerateService.generate("json", 1, attributes));
//
//	}
}
