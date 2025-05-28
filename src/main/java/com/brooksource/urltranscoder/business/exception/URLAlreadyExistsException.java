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
public class URLAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 369207898281759958L;
    private String url;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Default bean constructor
     */
    public URLAlreadyExistsException()
    {
        super("URL already exists.");
    }

    /**
     * This constructor takes in a string to be added to the default
     * verbiage.  It also initializes the URL in question/error
     * @param message - String to add to the error text.
     * @param url -  URL that has caused the exception
     */
    public URLAlreadyExistsException(final String message, final String url)
    {
        super("URL already exists: " + message);
        this.url = url;
    }
}
