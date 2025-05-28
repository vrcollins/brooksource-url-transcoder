package com.brooksource.urltranscoder.business.exception;

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
public class URLNotFoundException extends Exception {

    private static final long serialVersionUID = -3905562643150431999L;

    /**
     * This is the base/default constructor
     */
    public URLNotFoundException()
    {
        super("URL is not found.");
    }

    /**
     * This constructor takes in a string to be added to the default
     * verbiage
     * @param message - String to add to the error text.
     */
    public URLNotFoundException(final String message)
    {
        super("URL is not found: " + message);
    }
}
