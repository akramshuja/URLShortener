package com.shorturl.service;

import java.util.HashMap;
import java.util.Map;

import com.shorturl.util.URLShortenerUtil;

public class URLShortenerService {

	static Map<String, String> shortUrlKeyMap = new HashMap<String, String>();
	static Map<String, String> longUrlKeyMap = new HashMap<String, String>();

	public static String getShortURL(String longURL)
	{
		if(longUrlKeyMap.containsKey(longURL))
		{
			return URLShortenerUtil.shortUrlDomain + longUrlKeyMap.get(longURL);
		}
		else
		{
			String shortUrl = URLShortenerUtil.convertToBase62String(Base10Counter.getCounter());
			shortUrlKeyMap.put(shortUrl, longURL);
			longUrlKeyMap.put(longURL, shortUrl);
			Base10Counter.increaseCounter();

			return URLShortenerUtil.shortUrlDomain + shortUrl;
		}
	}

	public static String fetchOriginalURL(String shortURL)
	{
		return shortUrlKeyMap.get(shortURL);
	}
}