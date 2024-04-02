package com.green.jdbcex.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;


public enum ConnectionUtil {
    INSTANCE;

    private HikariDataSource hikariDataSource;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        config.addDataSourceProperty("cachePrepStmts", "true");  // 캐싱을 활성화
        config.addDataSourceProperty("prepStmtCacheSize", "250"); // 캐시의 크기
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); // 캐시의 크기

        hikariDataSource = new HikariDataSource(config);

    }

    public Connection getConnection() throws Exception{
        return hikariDataSource.getConnection();
    }


}
