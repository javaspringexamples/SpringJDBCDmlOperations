package javaspringexamples.springJDBC.dmlOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserDaoJdbcImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private MappingSqlQuery<User> userByIdQuery;
	private SqlUpdate userInsert;
	private SqlUpdate userUpdate;
	private SqlUpdate userDelete;

	public void setUserInsert(SqlUpdate userInsert) {
		this.userInsert = userInsert;
	}

	public void setUserUpdate(SqlUpdate userUpdate) {
		this.userUpdate = userUpdate;
	}

	public void setUserDelete(SqlUpdate userDelete) {
		this.userDelete = userDelete;
	}

	public void setUserByIdQuery(MappingSqlQuery<User> userByIdQuery) {
		this.userByIdQuery = userByIdQuery;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	public void insert(User user) {
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		int count = userInsert.update(new Object[] { user.getName(), user.getUserName(), user.isLocked() }, keyHolder);
		if (count != 1)
			throw new ExceptionInsertFailed("Cannot insert user");
		user.setId(keyHolder.getKey().longValue());
	}

	public void update(User user) {
		int count = userUpdate.update(user.getName(), user.getUserName(), user.isLocked(), user.getId());
		if (count != 1)
			throw new ExceptionUpdateFailed("Cannot update user");
	}

	public void delete(long userId) {
		int count = userDelete.update(userId);
		if (count != 1)
			throw new ExceptionDeleteFailed("Cannot delete user");
	}

	public User find(long userId) {
		return userByIdQuery.findObject(userId);
	}
}
