package com.brooksource.urltranscoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <pre>
 * Copyright (c) 2025 Collins Solutions LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Collins Solutions LLC
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Collins Solutions LLC.
 *
 * Purpose: Entrypoint to the Spring Boot Application
 *
 * 23-May-2025:     Initial Development
 *
 * </pre>
 */
@SpringBootApplication
public class UrlTranscoderApplication {


    /**
     * Main function to run the application
     * @param args - Arguments passed into the application
     */
	public static void main(final String[] args) {
		SpringApplication.run(UrlTranscoderApplication.class, args);
	}

}
