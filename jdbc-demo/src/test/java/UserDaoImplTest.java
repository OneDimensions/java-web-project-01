import com.onedimension.dao.impl.UserDaoImpl;
import com.onedimension.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDaoImplTest {

    @Test
    public void testGetUserById() throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUserById(1);
        System.out.println(user);
    }
}
