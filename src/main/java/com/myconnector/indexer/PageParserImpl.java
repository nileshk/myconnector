package com.myconnector.indexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.myconnector.domain.PageCache;

public class PageParserImpl implements PageParser {

    static Logger logger = Logger.getLogger(PageParserImpl.class);

    private Integer timeout = new Integer(15000);

    private static final int MIN_WORD_LIST = 3;

    /**
     * How long to wait before timing out on an http connection
     * @param timeout
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    protected StringBuffer loadPage(String urlString) throws MalformedURLException, IOException {
        HttpURLConnection con = null;
        URL url = null;
        try {
            url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setConnectTimeout(timeout.intValue());
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String s = br.readLine();
            while (s != null) {
                sb.append(s + " ");
                s = br.readLine();
            }
            return sb;
        } catch (MalformedURLException mue) {
            // TODO: Add to error list
            logger.warn("Malformed URL: " + urlString);
            throw mue;
        } catch (IOException ioe) {
            // TODO: Add to error list
            logger.warn("IOException on URL: " + urlString);
            throw ioe;
        }
    }

    protected List<String> extractWordList(StringBuffer sb) {

        // Delete HTML tags
        List<Integer[]> deleteList = new ArrayList<Integer[]>();
        Pattern tagPattern = Pattern.compile("<[^<>]+>");
        Matcher tagMatcher = tagPattern.matcher(sb);
        while (tagMatcher.find()) {
            Integer[] delete = new Integer[2];
            delete[0] = Integer.valueOf(tagMatcher.start());
            delete[1] = Integer.valueOf(tagMatcher.end());
            deleteList.add(delete);
            // System.out.println("Match: " + tagMatcher.group());
        }
        for (int i = deleteList.size() - 1; i >= 0; i--) {
            Integer[] delete = deleteList.get(i);
            sb.delete(delete[0], delete[1]);
        }

        // Delete characters
        List<Integer> deleteCharList = new ArrayList<Integer>();
        for (int i = 0; i < sb.length(); i++) {
            String c = sb.substring(i, i + 1);
            // If character is a non-word character, delete it
            if (c.matches("[^\\w\\s\\.']")) {
                deleteCharList.add(Integer.valueOf(i));
            }
        }
        for (int i = deleteCharList.size() - 1; i >= 0; i--) {
            Integer delete = deleteCharList.get(i);
            sb.deleteCharAt(delete);
        }

        // Extract words
        Pattern wordPattern = Pattern.compile("[\\w]+");
        Matcher wordMatcher = wordPattern.matcher(sb);
        List<String> wordList = new ArrayList<String>();
        while (wordMatcher.find()) {
            String word = wordMatcher.group();
            if (word.length() >= MIN_WORD_LIST) {
                wordList.add(word.toLowerCase()); // Note the lowercase
            }
        }
        return wordList;
    }

    protected Map<String, Integer> extractWordMap(List<String> list) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String word : list) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, ++count);
            } else {
                map.put(word, 1);
            }
        }

        return map;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.myconnector.indexer.PageParser#getWordMapForUrl(java.lang.String)
     */
    public Map<String, Integer> getWordMapForUrl(String url, PageCache cache)
            throws MalformedURLException, IOException {
        StringBuffer sb = loadPage(url);
        cache.setPageText(sb.toString()); // .substring(0, 1023)
        List<String> list = extractWordList(sb);
        return extractWordMap(list);
    }

    public void loadPageIntoCache(String url, PageCache cache) throws MalformedURLException,
            IOException {
        StringBuffer sb = loadPage(url);
        cache.setPageText(sb.toString());
    }

    public Map<String, Integer> getWordMapForString(String data) {
        StringBuffer sb = new StringBuffer(data);
        List<String> list = extractWordList(sb);
        return extractWordMap(list);
    }

    public static void main(String[] args) {
        PageParserImpl httpPageLoader = new PageParserImpl();
        // StringBuffer sb =
        // httpPageLoader.loadPage("http://web.tampabay.rr.com/nil/");
        StringBuffer sb = null;
        try {
            sb = httpPageLoader.loadPage("http://slashdot.org");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = httpPageLoader.extractWordList(sb);
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            System.out.println(word);
        }
        Map<String, Integer> map = httpPageLoader.extractWordMap(list);
        for (Entry<String, Integer> entry : map.entrySet()) {
            // if(entry.getValue().intValue() > 1) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            // }
        }
    }

}
