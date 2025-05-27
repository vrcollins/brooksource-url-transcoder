package com.brooksource.urltranscoder.business.service;

import java.util.Optional;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.brooksource.urltranscoder.business.exception.URLAlreadyExistsException;
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
@Service(value = "transcoderManager")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TranscoderManager implements ITranscoder{

    @Autowired
    @Qualifier("URLRepository")
    private IURLRepository repository;

    private final static String BASE_URL = "http://short.ext/";

    /**
     * @see com.brooksource.urltranscoder.business.service.ITranscoder#encode(String)
     */
    @SuppressWarnings("deprecation")
    @Override
    public Optional<String> encode(final String url) throws URLAlreadyExistsException {

        final Optional<String> value = this.repository.findURLByValue(url);

        if (value.isEmpty()) {

            final char [][] pairs = {{'a','z'},{'0','9'},{'A','Z'} };
            final RandomStringGenerator generator = new RandomStringGenerator.Builder()
                    .withinRange(pairs).build();

            final String randomLetters = generator.generate(10);
            final boolean added = this.repository.addURL(randomLetters, url);

            if (added) {

                this.repository.addURL(randomLetters, url);
                return Optional.ofNullable(BASE_URL + randomLetters);
            }
            else {
                return Optional.empty();
            }
        }
        else {
            throw new URLAlreadyExistsException("The key is: ", BASE_URL + value.get());
        }
    }

    @Override
    public Optional<String> decode(final String url) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

}
