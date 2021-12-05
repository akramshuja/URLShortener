package com.shorturl.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shorturl.dao.URLFileResource;
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
	
	public static String getShortURLFromFile(String longURL) throws IOException
	{
		List<String> fileContent = URLFileResource.readFromFile();
		
		for(String line : fileContent)
		{
			if(line.contains(longURL))
			{
				String[] split = line.split("\\|");
				if(split[0].equalsIgnoreCase(longURL))
					return split[1];
				else
					continue;
			}
		}
		
		String shortUrl = URLShortenerUtil.convertToBase62String(Base10Counter.getCounter());
		URLFileResource.writeToFile(longURL + "|" + URLShortenerUtil.shortUrlDomain + shortUrl);
		Base10Counter.increaseCounter();

		return URLShortenerUtil.shortUrlDomain + shortUrl;
	}
}