package club.ensoul.autodict.dialect;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

/**
 * @author CHEN
 **/
public class Dialect {
    
    private final static String DRIVER_CLASS_NAME_MYSQL = "com.mysql.jdbc.Driver";
    private final static String DRIVER_CLASS_NAME_POSTGRESQL = "org.postgresql.Driver";
    private final static String DRIVER_CLASS_NAME_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String DRIVER_CLASS_NAME_DB2 = "com.ibm.db2.jdbc.app.DB2Driver";
    private final static String DRIVER_CLASS_NAME_SYBASE = "com.sybase.jdbc.SybDriver";
    private final static String DRIVER_CLASS_NAME_ORACLE_THIN = "oracle.jdbc.driver.OracleDriver";
    
    private final static String URL_CLASS_NAME_MYSQL = "jdbc:mysql://localhost/information_schema?useUnicode=true&characterEncoding=utf-8";
    private final static String URL_CLASS_NAME_POSTGRESQL = "jdbc:postgresql://localhost/{0}";
    private final static String URL_CLASS_NAME_MSSQL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName={0}";
    private final static String URL_CLASS_NAME_DB2 = "jdbc:db2://localhost:5000/{0}";
    private final static String URL_CLASS_NAME_SYBASE = "jdbc:sybase:Tds:localhost:5007/{0}";
    private final static String URL_CLASS_NAME_ORACLE_THIN = "jdbc:oracle:thin:@localhost:1521:{0}";
    
    public static String driverClass(String dialect) {
        String _dialect = dialect.toLowerCase();
        switch(_dialect) {
            case "mssql":
                return DRIVER_CLASS_NAME_MSSQL;
            case "oracle":
                return DRIVER_CLASS_NAME_ORACLE_THIN;
            case "postgresql":
                return DRIVER_CLASS_NAME_POSTGRESQL;
            case "sybase":
                return DRIVER_CLASS_NAME_SYBASE;
            case "db2":
                return DRIVER_CLASS_NAME_DB2;
            default:
                return DRIVER_CLASS_NAME_MYSQL;
        }
    }
    
    public static String url(String dialect, String db) {
        return String.format(url(dialect), db);
    }
    
    public static String sql(String dialect, String db) {
        String _dialect = dialect.toLowerCase();
        try {
            return String.format(sqlRead(_dialect), db);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    private static String url(String dialect) {
        String _dialect = dialect.toLowerCase();
        switch(_dialect) {
            case "mssql":
                return URL_CLASS_NAME_MSSQL;
            case "oracle":
                return URL_CLASS_NAME_ORACLE_THIN;
            case "postgresql":
                return URL_CLASS_NAME_POSTGRESQL;
            case "sybase":
                return URL_CLASS_NAME_SYBASE;
            case "db2":
                return URL_CLASS_NAME_DB2;
            default:
                return URL_CLASS_NAME_MYSQL;
        }
    }
    
    private static String sqlRead(String dialect) throws Exception {
        String _dialect = dialect.toLowerCase();
        InputStream inputStream;
        try {
            File file = ResourceUtils.getFile("classpath:sql/" + _dialect);
            inputStream = new FileInputStream(file);
        } catch(Exception e) {
            inputStream = new ClassPathResource("/sql/" + _dialect).getInputStream();
        }
        byte[] s = new byte[1024];
        inputStream.read(s);
        return new String(s).trim().replace("\\n|\\r", " ");
    }
    
}
