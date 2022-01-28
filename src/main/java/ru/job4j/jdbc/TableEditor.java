package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private static Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver_class"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void executeUpdate(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = "CREATE TABLE if not exists " + tableName
                + " (id SERIAL PRIMARY KEY)";
        executeUpdate(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE " + tableName;
        executeUpdate(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        String sql = "ALTER TABLE " + tableName + " ADD " + columnName + " " + type;
        executeUpdate(sql);
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = "ALTER TABLE " + tableName + " DROP " + columnName;
        executeUpdate(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        String sql = "ALTER TABLE " + tableName
                + " RENAME COLUMN " + columnName + " TO " + newColumnName;
        executeUpdate(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream("app.properties")) {
            properties.load(in);
        }

        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("demo");
            System.out.println(getTableScheme(TableEditor.connection, "demo"));
            tableEditor.addColumn("demo", "name", "text");
            System.out.println(getTableScheme(TableEditor.connection, "demo"));
            tableEditor.renameColumn("demo", "name", "Address");
            System.out.println(getTableScheme(TableEditor.connection, "demo"));
            tableEditor.dropColumn("demo", "Address");
            System.out.println(getTableScheme(TableEditor.connection, "demo"));
            tableEditor.dropTable("demo");
        }
    }
}