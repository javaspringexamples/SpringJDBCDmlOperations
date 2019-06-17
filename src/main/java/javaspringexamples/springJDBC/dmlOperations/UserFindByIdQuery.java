package javaspringexamples.springJDBC.dmlOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserFindByIdQuery extends MappingSqlQuery<User> {

	public UserFindByIdQuery(DataSource dataSource) {
		super(dataSource, "select id,name,user_name,locked from user where id = ?");
		declareParameter(new SqlParameter(Types.BIGINT));
		compile();

	}

	@Override
	protected User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setUserName(rs.getString("user_name"));
		user.setLocked(rs.getBoolean("locked"));
		return user;
	}
}