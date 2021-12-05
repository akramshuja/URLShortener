package com.shorturl.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shorturl.service.URLShortenerService;

@Path("/shortenUrlAlt")
public class ShortenUrlAlt {

	@GET
	public Response init(@QueryParam("url") String url) throws IOException
	{
		String shorturl = URLShortenerService.getShortURLFromFile(url);
	    return Response
	    	      .status(Response.Status.OK)
	    	      .entity(shorturl)
	    	      .type(MediaType.TEXT_PLAIN)
	    	      .build();
	}
}
