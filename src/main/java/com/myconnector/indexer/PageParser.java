package com.myconnector.indexer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import com.myconnector.domain.PageCache;

public interface PageParser {

    /**
     * Get a page by URL, and extract list of indexable words and number of
     * occurances of those words
     * 
     * @param url
     *            URL to load page from
     * @param cache
     *            PageCache object to populate with page
     * @return A map with words as keys and number of occurances as Integer
     * @throws IOException
     * @throws MalformedURLException
     */
    public abstract Map<String, Integer> getWordMapForUrl(String url, PageCache cache)
            throws MalformedURLException, IOException;

    public void loadPageIntoCache(String url, PageCache cache) throws MalformedURLException,
            IOException;

    /**
     * Given page data, extract list of indexable words and number of occurances
     * of those words. This is useful when a page is already cached, and we want
     * to re-index it based on a new algorithm.
     * 
     * @param data
     *            page data
     * @return A map with words as keys and number of occurances as Integer
     */
    public abstract Map<String, Integer> getWordMapForString(String data);
}