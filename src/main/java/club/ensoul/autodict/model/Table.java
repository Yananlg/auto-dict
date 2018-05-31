package club.ensoul.autodict.model;

import lombok.Data;

@Data
public class Table {
    
    private String tableName;          // 表名
    private String tableComment;       // 表说明
    
    public Table() {
    }
    
    public Table(String tableName, String tableComment) {
        this.tableName = tableName;
        this.tableComment = tableComment;
    }
    
    public String getTitle(){
        return tableComment == null || "".equals(tableComment.trim()) ? tableName : tableComment;
    }
    
}
