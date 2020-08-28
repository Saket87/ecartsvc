package com.ecart.ecartsvc.config;


import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import com.ecart.ecartsvc.dao.OrderDao;
import com.ecart.ecartsvc.dao.ProductDao;
import com.ecart.ecartsvc.model.Product;
import com.opentable.db.postgres.embedded.EmbeddedPostgres;


public class JdbiConfig {
	
	private static final Logger LOGGER = Logger.getLogger( JdbiConfig.class.getName() );

    private static final String POSTGRES_DB_NAME = "postgres", POSTGRES_USER = "postgres";
    
    private static Jdbi jdbi;
    
    private static Jdbi jdbi1;
    
    
    static {
		try {

			LOGGER.log(Level.INFO, "*********************First Time Initialization of Postgres has started ***********************");
			
			EmbeddedPostgres embeddedPostgres = EmbeddedPostgres.start();

			DataSource defaultDataSource = embeddedPostgres.getDatabase(POSTGRES_USER, POSTGRES_DB_NAME);

			jdbi = Jdbi.create(defaultDataSource);

			jdbi.installPlugin(new SqlObjectPlugin());
			
			List<Product> products = jdbi.withExtension(ProductDao.class, dao -> {
                dao.createTable();

                dao.insertBean(new Product("Mobiles","Apple","AP1","Black","Some description about AP1",new BigDecimal("70000"),new BigDecimal("13"),11));
                dao.insertBean(new Product("Mobiles","Samsung","SP1","Grey","Some description about SP1",new BigDecimal("50000"),new BigDecimal("2"),2));
                dao.insertBean(new Product("Mobiles","MI","MP1","Black","Some description about MP1",new BigDecimal("20000"),new BigDecimal("9"),35));
                dao.insertBean(new Product("Computers","Intel","IL1","Grey","Some description about IL1",new BigDecimal("67000"),new BigDecimal("0"),106));
                dao.insertBean(new Product("Computers","Intel","IL2","Black","Some description about IL2",new BigDecimal("74000"),new BigDecimal("6"),300));
                dao.insertBean(new Product("Computers","Lenovo","LL1","Black","Some description about LL2",new BigDecimal("80000"),new BigDecimal("10"),138));
                dao.insertBean(new Product("Television","LG","LT1","Black","Some description about LT1",new BigDecimal("42500"),new BigDecimal("8"),62));
                dao.insertBean(new Product("Television","Samsung","ST1","Grey","Some description about ST1",new BigDecimal("58360"),new BigDecimal("16"),168));

                return dao.listProducts();
            });
			
			jdbi.withExtension(OrderDao.class, dao -> {
				
                dao.createTable();
                
                return null;
            });
			
			
			LOGGER.log(Level.INFO, "*********************First Time Initialization of Postgres has ended***********************");
			
			LOGGER.log(Level.INFO, "*********************Created below records in Product table***********************");
			
			System.out.println(products);
			
			
			LOGGER.log(Level.INFO, "*********************Second Time Initialization of Postgres has started ***********************");
			

			DataSource defaultDataSource1 = embeddedPostgres.getDatabase(POSTGRES_USER, POSTGRES_DB_NAME);

			jdbi1 = Jdbi.create(defaultDataSource1);

			jdbi1.installPlugin(new SqlObjectPlugin());
			
			List<Product> products1 = jdbi1.withExtension(ProductDao.class, dao -> {

                return dao.listProducts();
            });

			
			
			LOGGER.log(Level.INFO, "*********************Second Time Initialization of Postgres has ended***********************");
			
			LOGGER.log(Level.INFO, "*********************Fetched below records from Product table***********************");
			
			LOGGER.log(Level.INFO, products1.toString());
			
			
		} catch (Exception error) {
			System.out.println("Failed to start an instance of EmbeddedPostgres database" + error);
			throw new IllegalStateException(error);
		}
    }
	

	/**
	 * @return the jdbi
	 */
	public static Jdbi getJdbi() {
		return jdbi;
	}
	
	/**
	 * @return the jdbi
	 */
	public static Jdbi getJdbi1() {
		return jdbi1;
	}
	
}
