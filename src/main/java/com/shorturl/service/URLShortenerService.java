package com.shorturl.service;

import java.util.HashMap;
import java.util.Map;

import com.shorturl.util.URLShortenerUtil;

public class URLShortenerService {

	static Map<String, String> shortUrlMap = new HashMap<String, String>();

	public static String getShortURL(String longURL)
	{
		if(shortUrlMap.containsKey(longURL))
		{
			return URLShortenerUtil.shortUrlDomain + shortUrlMap
													      .entrySet()
													      .stream()
													      .filter(entry -> longURL.equals(entry.getValue()))
													      .map(Map.Entry::getKey);
		}
		else
		{
			String shortUrl = URLShortenerUtil.convertToBase62String(Base10Counter.getCounter());
			shortUrlMap.put(shortUrl, longURL);
			Base10Counter.increaseCounter();

			return URLShortenerUtil.shortUrlDomain + shortUrl;
		}
	}

	public static String fetchOriginalURL(String shortURL)
	{
		return shortUrlMap.get(shortURL);
	}
}