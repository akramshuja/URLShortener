package com.shorturl.util;

public class URLShortenerUtil {

	public static final String shortUrlDomain = "akr.ly/";
	
	// Short url will be built with these 62 characters
	public static final String urlCharacterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
	
	public static String convertToBase62String(long number)
	{
		StringBuilder sb = new StringBuilder();

	    while (number != 0) 
	    {
	        int remainder = (int)(number % 62);
			sb.append(urlCharacterSet.charAt(remainder));
	        number = number/62;
	    }
	    String encoded = String.format("%-4s", sb).replace(' ', '0');

	    return new StringBuilder(encoded).reverse().toString();
	}
}