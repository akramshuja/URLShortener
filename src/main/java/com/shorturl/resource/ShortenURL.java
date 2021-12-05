package com.shorturl.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.shorturl.service.URLShortenerService;

@Path("/hello")
public class ShortenURL {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response init(@QueryParam("url") String url)
	{
		String shorturl = URLShortenerService.getShortURL(url);
	    return Response
	    	      .status(Response.Status.OK)
	    	      .entity(shorturl)
	    	      .type(MediaType.TEXT_PLAIN)
	    	      .build();
	}
}
