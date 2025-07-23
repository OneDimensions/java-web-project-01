import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

    private static Dotenv dotenv;

    /**
     * 初始化环境变量
     */
    @BeforeAll
    public static void init() {
        dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))  // 使用当前工作目录
                .filename(".env")
                .load();
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.获取数据库连接 链接地址, 用户名, 密码  连接后需要指定数据库
        String url = dotenv.get("DB_URL") + "/web01";
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3.获取SQL语句执行对象
        Statement statement = connection.createStatement();

        // 4.执行SQL
        int rows = statement.executeUpdate("update user set age = 19 where id = 1"); // DML语句
        System.out.println("sql执行影响的行数 = " + rows);

        // 5.关闭资源
        statement.cancel();
        connection.close();
    }
}
