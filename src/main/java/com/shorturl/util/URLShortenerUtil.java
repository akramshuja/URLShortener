package com.shorturl.util;

public class URLShortenerUtil {

	public static final String shortUrlDomain = "akr.ly/";
	public static final String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private static final int avgRequestPerSecond = 1;
	private static final int daysShortUrlStored = 30;

	private static long requestsInStipulatedTime()
	{
		return avgRequestPerSecond * 60 * 60 * 24 * daysShortUrlStored;
	}

	// Minimum length of shortURL length required to cater to short url requests for the given time frame
	public static int shortURLLength()
	{
		int length = 1;
		int base = 62;
		long maxRequest = requestsInStipulatedTime();

		while(base < maxRequest)
		{
			base = base * 62;
			length = length + 1;
		}
		return length;
	}
}