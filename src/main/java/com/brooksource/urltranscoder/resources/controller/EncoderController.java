package com.brooksource.urltranscoder.resources.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brooksource.urltranscoder.business.exception.URLAlreadyExistsException;
import com.brooksource.urltranscoder.business.service.ITranscoder;
import com.brooksource.urltranscoder.model.request.URLRequest;
import com.brooksource.urltranscoder.model.response.URLResponse;

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
@RestController
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class EncoderController {

    @Autowired
    @Qualifier("transcoderManager")
    private ITranscoder manager;

    @PostMapping("/encoding")
    public ResponseEntity<Object> addURL (@RequestBody final URLRequest request) {

        try {
            Optional<String> theUrl = this.manager.encode(request.getUrl());
            URLResponse url = new URLResponse();
            url.setUrl(theUrl.get());
            return new ResponseEntity<>(url, HttpStatus.CREATED);
        }
        catch (URLAlreadyExistsException ex) {
            ex.getUrl();
            URLResponse response = new URLResponse();
            return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
        }

    }
}
