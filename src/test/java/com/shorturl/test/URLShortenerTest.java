package com.shorturl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.shorturl.service.URLShortenerService;

public class URLShortenerTest {

	@Test
    void testShortUrl() 
	{
		String shortURL1 = URLShortenerService.getShortURL("http://facebook.com");
		
		String shortURL2 = URLShortenerService.getShortURL("http://netflix.com");
		
		String shortURL3 = URLShortenerService.getShortURL("http://facebook.com");
		
		assertEquals(shortURL1, shortURL3);
		assertNotEquals(shortURL1, shortURL2);
    }
}
