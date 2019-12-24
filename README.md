# ks-session-2


https://www.tutorialspoint.com/spring_boot/spring_boot_eureka_server.htm

https://howtodoinjava.com/spring-cloud/spring-cloud-service-discovery-netflix-eureka/


https://www.javainuse.com/spring/spring_eurekaregister3


https://thepracticaldeveloper.com/2018/03/18/spring-boot-service-discovery-eureka/

https://sivalabs.in/2018/03/microservices-springcloud-eureka/


https://www.devglan.com/spring-cloud/spring-cloud-netflix-eureka


https://dev-682268.okta.com/login/login.htm?fromURI=%2Fapp%2Fadmin%2Fsso%2Fsaml%3FfromURI%3D%252Fdev%252Fconsole




    @HystrixCommand(fallbackMethod = "getFallbackUserRating",commandProperties = {    
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),		
    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="5"),	
    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="50"),	
    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="5000")
     })
