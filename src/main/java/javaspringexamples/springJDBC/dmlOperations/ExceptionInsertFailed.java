package javaspringexamples.springJDBC.dmlOperations;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class ExceptionInsertFailed extends DataAccessException {
	public ExceptionInsertFailed(String msg) {
		super(msg);
	}
}
