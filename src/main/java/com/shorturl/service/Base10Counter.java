package com.shorturl.service;

public class Base10Counter {

	long counter = 1;

	public long getCounter()
	{
		return counter;
	}

	public void increaseCounter()
	{
		counter = counter + 1;
	}

}