package javaspringexamples.springJDBC.dmlOperations;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class ExceptionDeleteFailed extends DataAccessException {
	
	public ExceptionDeleteFailed(String msg) {
		super(msg);
	}
}
