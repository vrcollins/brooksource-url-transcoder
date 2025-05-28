package com.brooksource.urltranscoder.domain.repository;

import java.util.Optional;

/**
 * <pre>
 * Copyright (c) 2025 Collins Solutions, LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Collins Solutions, LLC.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Collins Solutions, LLC.
 *
 * 23-May-2025:		Initial Development
 *
 * </pre>
 *
 * @author rcollins
 * @since Java Version 21
 * @version <b>0.1.0</b>
 */
public interface IURLRepository {

    /**
     * This method adds the URL
     * @param key - key of the URL to add to datastore
     * @param url - url to add to datastore
     * @return boolean - true if successfully added otherwise, false
     */
    boolean addURL(final String key, final String url);

    /**
     * This method finds a url from the datasource that matches
     * the key passed in
     * @param key - Key of the URL
     * @return Optional - String: URL that has been added to data store
     */
    Optional<String> findURLByKey(final String key);

    /**
     * This method finds the url from the datasource that matches
     * the value passed in.  It will only return one value
     * @param value - Value of the URL
     * @return Optional - String: URL that has been added to data store
     */
    Optional<String> findURLByValue(final String value);
}
