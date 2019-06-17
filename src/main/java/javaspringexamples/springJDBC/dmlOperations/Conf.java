package javaspringexamples.springJDBC.dmlOperations;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
@Configuration
public class Conf {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/javaspringexamples");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public UserDao userDao() {
        UserDaoJdbcImpl userDao = new UserDaoJdbcImpl();
        userDao.setJdbcTemplate(jdbcTemplate());
        userDao.setUserByIdQuery(userByIdQuery());
        userDao.setUserInsert(userInsert());
        userDao.setUserUpdate(userUpdate());
        userDao.setUserDelete(userDelete());
        return userDao;
    }
    
    @Bean
    public MappingSqlQuery<User> userByIdQuery() {
        UserFindByIdQuery query = new UserFindByIdQuery(dataSource());
        return query;
    }
    
    @Bean
    public SqlUpdate userInsert() {
    	UserInsert userInsert = new UserInsert(dataSource());
    	return userInsert;
    }
    
    @Bean
    public SqlUpdate userUpdate() {
    	UserUpdate userUpdate = new UserUpdate(dataSource());
    	return userUpdate;
    }
    
    @Bean
    public SqlUpdate userDelete() {
    	UserDelete userDelete = new UserDelete(dataSource());
    	return userDelete;
    }
}
