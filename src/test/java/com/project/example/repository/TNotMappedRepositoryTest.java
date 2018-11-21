package com.project.example.repository;

import com.project.example.base.IntegrationBaseTest;
import com.project.example.vo.TNotMappedVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TNotMappedRepositoryTest extends IntegrationBaseTest {

	@Autowired
	private TNotMappedRepository TNotMappedRepository;

	@Test
	public void testLoadDataFind() {
		TNotMappedVO vo = TNotMappedRepository.findNextBusinessDayOfHolidayDate(LocalDate.of(2018,1,1));
		Assert.assertNotNull(vo);
		Assert.assertEquals(LocalDate.of(2018,1,1), vo.getHolidayDay());
		Assert.assertEquals(LocalDate.of(2018,1,2), vo.getNextBusinessDay());
	}

	@Test
	public void testLoadDataNotFound() {
		TNotMappedVO vo = TNotMappedRepository.findNextBusinessDayOfHolidayDate(LocalDate.of(2018,1,3));
		Assert.assertNull(vo);
	}

}
