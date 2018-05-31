package club.ensoul.autodict.jdbc;

import club.ensoul.autodict.dialect.Dialect;
import club.ensoul.autodict.mapper.DictRowMapper;
import club.ensoul.autodict.model.Dict;
import club.ensoul.autodict.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
public class FetchData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Map<Table, List<Dict>> query(String dialect, String db) {
        String sql = Dialect.sql(dialect, db);
        List<Dict> dicts = jdbcTemplate.query(sql, new DictRowMapper());
        Map<Table, List<Dict>> listMap = dicts.stream().collect(groupingBy(Dict::getTable));
        return listMap;
    }
    
}
