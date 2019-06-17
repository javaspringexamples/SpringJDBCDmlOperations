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
public class UserDelete extends SqlUpdate {
    public UserDelete(DataSource dataSource) {
        super(dataSource, "delete user where id = ?");
        setParameters(new SqlParameter[]{new SqlParameter(Types.BIGINT)});
        compile();
    }
}
