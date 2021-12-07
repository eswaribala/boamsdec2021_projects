package com.boa.customerdataapi.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Configuration
@Slf4j
@EnableConfigurationProperties(VaultConfiguration.class)

public class DBConfiguration {
	
	@Value("${db_url}")
	private String dbUrl;
	@Value("${db_driver}")
	private String driver;
	
	private DataSourceBuilder dataSourceBuilder;
    private final VaultConfiguration vaultConfiguration;
    
    public DBConfiguration(VaultConfiguration vaultConfig)
    {
    	this.vaultConfiguration=vaultConfig;
    }
    
    
    @Bean   
    public DataSource getDataSource()
    {
    	log.info("Entering Given Env.....");
        log.info("User Name..."+vaultConfiguration.getUsername());
    	log.info("Password..."+vaultConfiguration.getPassword());
    	dataSourceBuilder=DataSourceBuilder.create();
    	dataSourceBuilder.url(dbUrl);
    	dataSourceBuilder.username(vaultConfiguration.getUsername());
    	dataSourceBuilder.password(vaultConfiguration.getPassword());
    	dataSourceBuilder.driverClassName(driver);
    	return dataSourceBuilder.build();
   	
    }



}
