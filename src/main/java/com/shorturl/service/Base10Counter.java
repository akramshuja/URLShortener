package com.shorturl.service;

public class Base10Counter {

	static long counter = 1;

	public static long getCounter()
	{
		return counter;
	}

	public static void increaseCounter()
	{
		counter = counter + 1;
	}

}