package pl.jc.notesApp.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Class that provides access to database
 * Settings in webapp/META-INF/context.xml
 *
 * @version 1.0
 */
public class DataSourceProvider {

    private static DataSource dataSource;

    private DataSourceProvider() {
    }

    public static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env/");
            dataSource = (DataSource) envContext.lookup("jdbc/notes");
        }
        return dataSource;
    }
}
