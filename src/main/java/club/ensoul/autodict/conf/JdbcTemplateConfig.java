package club.ensoul.autodict.conf;

import club.ensoul.autodict.dialect.Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 功能：设置数据库信息和数据源
 * <p>
 * JdbcTemplat使用
 * 1、导入jar包；2、设置数据库信息；3、设置数据源；4、调用jdbcTemplate对象中的方法实现操作
 */
@Configuration
public class JdbcTemplateConfig {

    private DriverManagerDataSource dataSource;
    
    @Value("${u}")
    private String userName;
    
    @Value("${p}")
    private String password;
    
    @Value("${db}")
    private String db;
    
    @Value("${dialect}")
    private String dialect;

    @Bean
    public DataSource dataSource() {
        this.dataSource = new DriverManagerDataSource();
        this.dataSource.setDriverClassName(Dialect.driverClass(dialect));
        this.dataSource.setUrl(Dialect.url(dialect, db));
        this.dataSource.setUsername(userName);
        this.dataSource.setPassword(password);
        // 设置数据源
        return dataSource;
    }

}