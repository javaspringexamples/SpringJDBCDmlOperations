package javaspringexamples.springJDBC.dmlOperations;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserUpdate extends SqlUpdate {
	public UserUpdate(DataSource dataSource) {
		super(dataSource, "update user set (name,user_name, locked) = (?,?,?) where id=?");
		setParameters(new SqlParameter[] { new SqlParameter(Types.VARCHAR), new SqlParameter(Types.VARCHAR),
				new SqlParameter(Types.BOOLEAN), new SqlParameter(Types.BIGINT) });
		compile();
	}
}
