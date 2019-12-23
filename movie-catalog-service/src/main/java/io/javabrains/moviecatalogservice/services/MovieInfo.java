package io.javabrains.moviecatalogservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;
import io.javabrains.moviecatalogservice.models.UserRating;

@Service
public class MovieInfo {
	
	 @Autowired
	    public RestTemplate restTemplate;

	    
	    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	    public CatalogItem getCatalogItem(Rating rating)
	    {
	    	  Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
	          return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	    }
	    
	
	    
	    
	    public CatalogItem getFallbackCatalogItem(Rating rating)
	    {
	    	 // Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
	          return new CatalogItem("No movie not found","",rating.getRating());
	    }
	    


}
