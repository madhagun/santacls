package com.ibm.br.bluemix.secretsanta.secretsanta;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public MongoDbFactory documentMongoDbFactory() {
		return connectionFactory().mongoDbFactory("mongodb-handson");
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(documentMongoDbFactory());
	}

}


