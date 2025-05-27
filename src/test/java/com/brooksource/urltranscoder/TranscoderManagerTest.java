package com.brooksource.urltranscoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.brooksource.urltranscoder.business.exception.URLAlreadyExistsException;
import com.brooksource.urltranscoder.business.exception.URLNotFoundException;
import com.brooksource.urltranscoder.business.service.ITranscoder;

/**
 * <pre>
 * Copyright (c) 2025 Collins Solutions, LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Collins Solutions, LLC.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Collins Solutions, LLC.
 *
 * 27-May-2025:		Initial Development
 *
 * </pre>
 *
 * @author rcollins
 * @since Java Version 21
 * @version <b>0.1.0</b>
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TranscoderManagerTest {

    @Autowired
    @Qualifier("transcoderManager")
    private ITranscoder manager;

    @Test
    @Order(1)
    void encoderSuccessTest() throws URLAlreadyExistsException {

        try {
            Optional<String> url = this.manager.encode("http://th0surl.com");
            assertTrue(url.isPresent());
            System.out.println(url.get());
        }
        catch(URLAlreadyExistsException ex) {
            assertNotNull(ex.getUrl());
            System.out.println(ex.getUrl());
        }
    }

    @Test
    @Order(2)
    void encoderThereAlreadyTest() throws URLAlreadyExistsException {

        try {
            Optional<String> url = this.manager.encode("http://th0surl.com");
            System.out.println(url.get());
            Optional<String> url2 = this.manager.encode("http://th0surl.com");
            System.out.println(url2.get());
        }
        catch(URLAlreadyExistsException ex) {
            assertNotNull(ex.getUrl());
            System.out.println(ex.getUrl());
        }
     }

    @Test
    @Order(3)
    void dencoderSuccessTest() throws URLNotFoundException, URLAlreadyExistsException {

        try {
            Optional<String> url = this.manager.encode("http://dcodesurl.com");
            System.out.println(url.get());
            String decodeUrl = url.get();

            Optional<String> url2 = this.manager.decode(decodeUrl);
            System.out.println(url2.get());
        }
        catch(URLNotFoundException ex) {
            assertNotNull(ex);
        }
     }

    @Test
    @Order(4)
    void dencoderNotFoundTest() throws URLNotFoundException {

        try {
            final String decodeURL = "http://short.ext/lf0ItUrVSg";

            Optional<String> url2 = this.manager.decode(decodeURL);
            System.out.println(url2.get());
        }
        catch(URLNotFoundException ex) {
            assertNotNull(ex);
        }
     }
}
