package com.project.example.repository;

import com.project.example.util.MapBuilder;
import com.project.example.vo.TNotMappedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Repository
public class TNotMappedRepository {

    private static final String PATTERN = "yyyy-MM-dd";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	private NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

    public TNotMappedVO findNextBusinessDayOfHolidayDate(LocalDate possibleHolidayDayDate) {
        String sql = "SELECT TO_CHAR(DT_DAY, :PATTERN) DAY, \n" +
                " TO_CHAR(DT_NEXT_BUSINESS_DAY, :PATTERN) DT_NEXT_BUSINESS_DAY \n" +
                " FROM T_NOT_MAPPED \n" +
                " WHERE TO_CHAR(DT_DAY, :PATTERN) = :DT_DAY ";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        Map<String, Object> params = new MapBuilder<String, Object>().build();
        params.put("DT_DAY", possibleHolidayDayDate.format(formatter));
        params.put("PATTERN", PATTERN);

        try {
            return getJdbcTemplate().queryForObject(sql, params, (rs, i) -> new TNotMappedVO(PATTERN,
					rs.getString("DAY"),
					rs.getString("DT_NEXT_BUSINESS_DAY")));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
