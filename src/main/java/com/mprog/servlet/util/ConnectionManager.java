package com.mprog.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionManager {
    private ConnectionManager() {
    }

    public static Connection get(){
        return DriverManager.getConnection(

        )
    }
}
