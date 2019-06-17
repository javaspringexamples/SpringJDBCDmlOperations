package javaspringexamples.springJDBC.dmlOperations;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void delete(long userId);
    public User find(long userId);
}

