package club.ensoul.autodict.mapper;

import club.ensoul.autodict.model.Dict;
import club.ensoul.autodict.model.Table;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 实现RowMapper接口
 */
public class DictRowMapper implements RowMapper<Dict> {
    
    @Override
    public Dict mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        
        // 获取结果集中的数据
        String tableName = resultSet.getString("tableName");
        String tableComment = resultSet.getString("tableComment");
        String ordinal = resultSet.getString("ordinal");
        String columnName = resultSet.getString("columnName");
        String columnType = resultSet.getString("columnType");
        String isNullable = resultSet.getString("isNullable");
        String columnKey = resultSet.getString("columnKey");
        String increment = resultSet.getString("increment");
        String columnComment = resultSet.getString("columnComment");
    
        // 把数据封装成Dict对象
        return new Dict(new Table(tableName, tableComment), ordinal, columnName, columnType, isNullable, columnKey, increment, columnComment);
    }
    
}