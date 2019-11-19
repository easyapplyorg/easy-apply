package edu.mum.cs.easyapply.daos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class DataSourceFactory {

    private static DataSource dataSource = null;

    private DataSourceFactory() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/easy-apply");
        } catch (NamingException e) {
            System.err.println(e);
        }
    }

    static DataSource getInstance() {
        if (dataSource == null) new DataSourceFactory();
        return dataSource;
    }
}
