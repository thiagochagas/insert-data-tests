package com.project.example.repositories;

import com.project.example.base.IntegrationBaseTest;
import com.project.example.vo.ExampleVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ExampleRepositoryTest extends IntegrationBaseTest {

	@Autowired
	private ExampleRepository exampleRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadDataFind() {
		ExampleVO vo = exampleRepository.findPossibleHolidayInfo(LocalDate.of(2018,1,1));
		Assert.assertNotNull(vo);
		Assert.assertEquals(LocalDate.of(2018,1,1), vo.getHolidayDay());
		Assert.assertEquals(LocalDate.of(2018,1,2), vo.getNextBusinessDay());
	}

}
