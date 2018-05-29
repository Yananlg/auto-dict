package club.ensoul.autodict.model;

import lombok.Data;

/**
 * @author CHEN
 **/
@Data
public class Dict {
    
    private String tableName;          // 表名
    private String ordinal;            // 字段编号
    private String columnName;         // 字段名
    private String columnType;         // 数据类型
    private String isNullable;         // 允许为空
    private String columnKey;          // 键类型
    private String increment;          // 自增属性
    private String columnComment;      // 字段说明
    
    public Dict() {
    }
    
    public Dict(String tableName, String ordinal, String columnName, String columnType, String isNullable, String columnKey, String increment, String columnComment) {
        this.tableName = tableName;
        this.ordinal = ordinal;
        this.columnName = columnName;
        this.columnType = columnType;
        this.isNullable = isNullable;
        this.columnKey = columnKey;
        this.increment = increment;
        this.columnComment = columnComment;
    }
    
    @Override
    public String toString() {
        return "Dict{" +
                "tableName='" + tableName + '\'' +
                ", ordinal='" + ordinal + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", columnKey='" + columnKey + '\'' +
                ", increment='" + increment + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}
