package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class C3P0Utils {
    private static DataSource ds = null;

    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource("bookmanage");
        ds = cpds;
    }
    
    public static DataSource getDataSource() {
        return ds;
    }
}
