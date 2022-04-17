import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT\n" +
                    "course_name `name`,\n" +
                    "count(month(subscription_date)) / (timestampdiff(MONTH , \n" +
                    "min(subscription_date) , max(subscription_date)) +1 ) `avg`\n" +
                    "FROM purchaselist\n" +
                    "group by course_name;");
            while (resultSet.next()){
                String courseName = resultSet.getString("name");
                String averageMonthBuy = resultSet.getString("avg");
                System.out.println(courseName + " - " + averageMonthBuy);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
