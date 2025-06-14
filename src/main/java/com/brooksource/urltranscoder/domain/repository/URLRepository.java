package com.brooksource.urltranscoder.domain.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Copyright (c) 2025 Collins Solutions, LLC. All rights reserved.
 *
 * This software is the confidential and proprietary information of Collins Solutions, LLC.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Collins Solutions, LLC.
 *
 * 24-May-2025:		Initial Development
 *
 * </pre>
 *
 * @author rcollins
 * @since Java Version 21
 * @version <b>0.1.0</b>
 */
@Service(value = "URLRepository")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class URLRepository implements IURLRepository{

    private Map<String, String> datastore = new ConcurrentHashMap<>(10);

    /**
     * @see com.brooksource.urltranscoder.domain.repository.IURLRepository#findURLByKey(String)
     */
    @Override
    public Optional<String> findURLByKey(final String key) {

        String value = this.datastore.get(key);
        return Optional.ofNullable(value);
    }

    /**
     * @see com.brooksource.urltranscoder.domain.repository.IURLRepository#findURLByValue(String)
     */
    @Override
    public Optional<String> findURLByValue(final String value) {
        return this.findKeyByValue(value);
    }

    /**
     * @see com.brooksource.urltranscoder.domain.repository.IURLRepository#addURL(String, String)
     */
    @Override
    public boolean addURL(final String key, final String url) {

        if (this.datastore.containsKey(key))
            return false;
        else {
            this.datastore.put(key, url);
            return true;
        }
    }

    protected Optional<String> findKeyByValue(final String value) {

        Stream<String> key = this.datastore
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);

        return key.findFirst();

    }

}
