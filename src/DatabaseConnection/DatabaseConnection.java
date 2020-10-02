package DatabaseConnection;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {


        // init database constants
        final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sosasalse";
        private static final  String USERNAME = "root";
        private static final String PASSWORD = "";
        private final String MAX_POOL = "250";

        // init connection object
        private Connection connection;

        // init properties object
        private Properties properties;

        // init the statement
        private Statement statement;

        // init the preparedstatment
        private PreparedStatement preparedStatement;

        // init the table

        private String table = null;

        // create properties
        private Properties getProperties()
        {
            if (properties == null)
            {
                properties = new Properties();
                properties.setProperty("user", USERNAME);
                properties.setProperty("password", PASSWORD);
                properties.setProperty("MaxPooledStatements", MAX_POOL);
            }
            return properties;
        }
        /**
         * Connect to the database
         *
         * @return Connection
         */


        public Connection connect(String table){
            this.table = table;
            if (connection == null)
            {
                try
                {
                    Class.forName(DATABASE_DRIVER);
                    connection = (Connection) DriverManager.getConnection(DATABASE_URL,getProperties());
                    System.out.println("connect sucssese");
                }
                catch (ClassNotFoundException | SQLException e)
                {
                    e.printStackTrace();
                }
            }
            return connection;
        }
        /**
         * Disconnect database
         */
        public void disconnect()  {
            if (connection != null)
            {
                try{
                    connection.close();
                    connection = null;
                    table = null;
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        /**
         * Return the result set when a correct SQL statement is provided
         *
         * @param //query
         * @return
         * @throws SQLException
         */
        public ResultSet select() throws SQLException
        {
                preparedStatement = connection.prepareStatement("SELECT * FROM "+table+" WHERE 1");
                ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        }
    /**
     * Return the result set when a correct SQL prepardstatement is provided
     *
     * @param //query
     * @return
     * @throws SQLException
     */
    public ResultSet select(int id) throws SQLException
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM `"+table+"` WHERE id = "+id+"");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

        /**
         * Return the status when a SQL query is provided for INSERT, UPDATE or DELETE
         * @param query
         * @return
         * @throws SQLException
         */
        public int createOrUpdate(String query) throws SQLException
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        }
    /**
     * Return the status when a SQL query is provided for DELETE
     * @param query
     * @return
     * @throws SQLException
     */
    public void Delete(int id,Boolean reoreder) throws SQLException
    {

        preparedStatement = connection.prepareStatement("DELETE  FROM `"+table+"` WHERE id = "+id+"");
        preparedStatement.executeUpdate();
                if(reoreder){
            preparedStatement= connection.prepareStatement("SET @count = 0");
            preparedStatement.executeUpdate();
            preparedStatement= connection.prepareStatement("UPDATE `catgory`  SET `id` = @count:= @count + 1");
            preparedStatement.executeUpdate();
            preparedStatement= connection.prepareStatement("ALTER TABLE `catgory` AUTO_INCREMENT = 1");
            preparedStatement.executeUpdate();
        }


    }




}









