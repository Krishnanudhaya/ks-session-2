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
public class UserRatingService {


	@Autowired
	UserRatingService userRatingService;
	
    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(@PathVariable("userId")String userId)
    {
    	return restTemplate.getForObject("http://ratings-data-service/ratingsdata/user"+userId, UserRating.class);
    }
    
     
    private UserRating getFallbackUserRating(@PathVariable("userId")String userId)
    {
    	//return restTemplate.getForObject("http://ratings-data-service/ratingsdata/user"+userId, UserRating.class);
    	UserRating userRating = new UserRating();
    	userRating.setUserId(userId);
    	userRating.setRatings(Arrays.asList(new Rating("0",0)));
    	
    	return userRating;
    }
    
   
    

}
