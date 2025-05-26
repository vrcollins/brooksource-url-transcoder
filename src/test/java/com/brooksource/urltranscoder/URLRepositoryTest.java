package com.brooksource.urltranscoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.brooksource.urltranscoder.domain.repository.IURLRepository;

/**
 * <pre>
 * Copyright (c) 2025 Collins Solutions, LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Collins Solutions, LLC.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Collins Solutions, LLC.
 *
 * 26-May-2025:		Initial Development
 *
 * </pre>
 *
 * @author rcollins
 * @since Java Version 21
 * @version <b>0.1.0</b>
 */
@SpringBootTest
class URLRepositoryTest {

    @Autowired
    @Qualifier("URLRepository")
    private IURLRepository repository;


    @Test
    void addURLSuccessTest() {
        boolean theTest = this.repository.addURL("1", "http://someurl");
        assertTrue(theTest);
    }

    @Test
    void addURLAlreadyExistsTest() {
        this.repository.addURL("1", "http://someurl");
        boolean theTest = this.repository.addURL("1", "http://someurl");
        assertFalse(theTest);
    }

}
