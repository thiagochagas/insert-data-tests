package com.project.example.repositories;

import com.project.example.util.MapBuilder;
import com.project.example.vo.ExampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Repository
public class ExampleRepository {

    private static final String PATTERN = "yyyy-MM-dd";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	private NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

    public ExampleVO findPossibleHolidayInfo(LocalDate possibleHolidayDayDate) {
        String sql = "SELECT TO_CHAR(DT_FERI, :PATTERN) FERIADO, \n" +
                " TO_CHAR(DT_PROX_DIA_UTIL, :PATTERN) PROX_DIA_UTIL \n" +
                " FROM TCFG_DIA_UTIL \n" +
                " WHERE TO_CHAR(DT_FERI, :PATTERN) = :DT_FERI ";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        Map<String, Object> params = new MapBuilder<String, Object>().build();
        params.put("DT_FERI", possibleHolidayDayDate.format(formatter));
        params.put("PATTERN", PATTERN);

        try {
            return getJdbcTemplate().queryForObject(sql, params, (rs, i) -> new ExampleVO(PATTERN,
					rs.getString("FERIADO"),
					rs.getString("PROX_DIA_UTIL")));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
