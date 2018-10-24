package com.rs.hibernate.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-23
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
	static {
		try {
			// Configuration cfg = new Configuration();
			// cfg.configure("com/rs/hibernate/cfgs/hibernate.cfg.xml");
			// sessionFactory = cfg.buildSessionFactory();
//			Configuration configuration = null;
//			StandardServiceRegistryBuilder builder = null;
//			StandardServiceRegistry registry = null;
//
//			configuration = new Configuration();
//			configuration.configure("com/rs/hibernate/cfgs/hibernate.cfg.xml");
//			configuration.addAnnotatedClass(Employee.class);
//			// Create a default builder
//			builder = new StandardServiceRegistryBuilder();
//
//			/*
//			 * Add custom service to builder, if configuration data having other plugin for
//			 * same service role interface then addService method defined plugin is
//			 * overridden by configuration data plugin
//			 */
//
//			// builder.addService(ConnectionProvider.class, new CustomConnectionProvider());
//
//			// Add Services and properties Defined in configuration file
//			registry = builder.applySettings(configuration.getProperties()).build();
//			// registry without configuration data with custom services
//			// registry=builder.build();
//			// get the SessionFactory by adding registry
//			sessionFactory = configuration.buildSessionFactory(registry);
			
			StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
			standardServiceRegistry = standardServiceRegistryBuilder.configure("com/rs/hibernate/cfgs/hibernate.cfg.xml").build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.buildSessionFactory();
		} catch (Throwable ex) {
			if(standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
			throw new ExceptionInInitializerError(ex);
		}
	}

	private HibernateUtil() {
		// No Operations
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
