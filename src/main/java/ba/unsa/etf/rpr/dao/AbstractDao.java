package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Exceptions.GameException;
import ba.unsa.etf.rpr.domain.Idable;

import java.sql.*;
import java.util.*;

/**
 * The type Abstract dao.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractDao<T extends Idable> implements Dao<T> {
    private static Connection connection = null;
    private String tableName;

    /**
     * Instantiates a new Abstract dao.
     *
     * @param tableName the table name
     */
    public AbstractDao(String tableName) {
        this.tableName = tableName;
        createConnection();
    }

    private static void createConnection() {
        if (AbstractDao.connection == null) {
            try {
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties").openStream());
                String url = p.getProperty("db.connection_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");
                AbstractDao.connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    @Override
                    public void run() {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        return AbstractDao.connection;
    }

    /**
     * Method for mapping ResultSet into Object
     *
     * @param rs - result set from database
     * @return a Bean object for specific table
     */
    public abstract T row2object(ResultSet rs);

    /**
     * Method for mapping Object into Map
     *
     * @param object - a bean object for specific table
     * @return key, value sorted map of object
     */
    public abstract Map<String, Object> object2row(T object);

    public T getById(int id) {
        return executeQueryUnique("SELECT * FROM " + this.tableName + " WHERE id = ?", new Object[]{id});
    }

    public List<T> getAll() {
        return executeQuery("SELECT * FROM " + tableName, null);
    }

    public void delete(int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            //trebalo bi bacati kreirani izuzetak
        }
    }

    public T add(T item) {
        Map<String, Object> row = object2row(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(tableName);
        System.out.println("Dodali Insert");
        builder.append(" (").append(columns.getKey()).append(") ");
        System.out.println("dodali pitanja");
        builder.append("VALUES (").append(columns.getValue()).append(")");
        System.out.println("Dodali vrijednosti");

        try {
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
            System.out.println("prvi try prosao");
            // bind params. IMPORTANT treeMap is used to keep columns sorted so params are bind correctly
            int counter = 1;
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                System.out.println("entrySet okej");
                System.out.println(counter);
                stmt.setObject(counter, entry.getValue());
                System.out.println("Postavilo");
                counter++;
            }
            System.out.println("izasli iz petlje");
            System.out.println(builder.toString());
            stmt.executeUpdate();
            System.out.println("Prosao update");

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back */

            return item;
        } catch (SQLException e) {
            throw new GameException(e.getMessage());
        }
    }

    public T update(T item) {
        Map<String, Object> row = object2row(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(updateColumns)
                .append(" WHERE id = ?");

        try {
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());
            int counter = 1;
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.setObject(counter, item.getId());
            stmt.executeUpdate();
            return item;
        } catch (SQLException e) {
            throw new GameException(e.getMessage());
        }
    }

    /**
     * Utility method for executing any kind of query
     *
     * @param query  - SQL query
     * @param params - params for query
     * @return List of objects from database
     */
    public List<T> executeQuery(String query, Object[] params) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            if (params != null) {
                for (int i = 1; i <= params.length; i++) {
                    stmt.setObject(i, params[i - 1]);
                }
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<T> resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(row2object(rs));
            }
            return resultList;
        } catch (SQLException e) {
            //trebalo bi bacati novokreirani izuzetak, umjesto ovog return Collections.emptyList();
            throw new GameException(e.getMessage());
        }
    }

    /**
     * Utility for query execution that always return single record
     *
     * @param query  - query that returns single record
     * @param params - list of params for sql query
     * @return Object t
     */
    public T executeQueryUnique(String query, Object[] params) {
        List<T> result = executeQuery(query, params);
        if (result != null && result.size() == 1) {
            return result.get(0);
        } else {
            throw new GameException("Execute query unique doesn't work");
        }
    }
    /**
     * Accepts KV storage of column names and return CSV of columns and question marks for insert statement
     * Example: (id, name, date) ?,?,?
     */
    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 1;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            System.out.println(counter);
            counter++;
            if (entry.getKey().equals("id")) continue; //skip insertion of id due autoincrement
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size() != counter) {
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<>(columns.toString(), questions.toString());
    }

    /**
     * Prepare columns for update statement id=?, name=?, ...
     * @param row - row to be converted intro string
     * @return String for update statement
     */
    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip update of id due where clause
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }
}
