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
public class UserInsert extends SqlUpdate {
	public UserInsert(DataSource dataSource) {
		super(dataSource, "insert into user(name,user_name,locked) values(?,?,?)");
		setParameters(new SqlParameter[] { new SqlParameter(Types.VARCHAR), new SqlParameter(Types.VARCHAR),
				new SqlParameter(Types.BOOLEAN) });
		setReturnGeneratedKeys(true);
		setGeneratedKeysColumnNames(new String[] { "id" });
		compile();
	}
}
