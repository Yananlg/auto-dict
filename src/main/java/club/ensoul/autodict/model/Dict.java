package club.ensoul.autodict.model;

import lombok.Data;

@Data
public class Dict {
    
    private Table table;
    private String ordinal;            // 字段编号
    private String columnName;         // 字段名
    private String columnType;         // 数据类型
    private String isNullable;         // 允许为空
    private String columnKey;          // 键类型
    private String increment;          // 自增属性
    private String columnComment;      // 字段说明
    
    public Dict() {
    }
    
    public Dict(Table table, String ordinal, String columnName, String columnType, String isNullable, String columnKey, String increment, String columnComment) {
        this.table = table;
        this.ordinal = ordinal;
        this.columnName = columnName;
        this.columnType = columnType;
        this.isNullable = isNullable;
        this.columnKey = columnKey;
        this.increment = increment;
        this.columnComment = columnComment;
    }
    
}
