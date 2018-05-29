package club.ensoul.autodict.jdbc;

import club.ensoul.autodict.dialect.Dialect;
import club.ensoul.autodict.mapper.DictRowMapper;
import club.ensoul.autodict.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Component
public class FetchData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Map<String, List<Dict>> query(String dialect, String db) {
        String sql = Dialect.sql(dialect, db);
        Map<String, List<Dict>> listMap = jdbcTemplate.query(sql, new DictRowMapper()).stream().collect(groupingBy(Dict::getTableName));
        return listMap;
    }
    
}
