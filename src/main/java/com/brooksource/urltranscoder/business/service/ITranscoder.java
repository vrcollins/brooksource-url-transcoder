package com.brooksource.urltranscoder.business.service;

import java.util.Optional;

import com.brooksource.urltranscoder.business.exception.URLAlreadyExistsException;

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
public interface ITranscoder {

    /**
     * This method encodes the url string passed in,
     * then it returns an encoded URL to the calling
     * function
     * @param url - string to be encoded
     * @return Optional - URL String that has been encoded
     */
    Optional<String> encode(final String url) throws URLAlreadyExistsException;

    /**
     * This method decodes the url string passed in,
     * then it returns an decoded URL to the calling
     * function
     * @param url - string to be decoded
     * @return Optional - URL String that has been decoded
     */
    Optional<String> decode(String url);

}
