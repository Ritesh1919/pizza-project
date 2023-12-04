package com.React.Configuration;


	import java.util.List;

import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.web.cors.CorsConfiguration;
	import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
	import org.springframework.web.filter.CorsFilter;

	

	@Configuration
	public class Configur {

	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();

	        // Allow multiple origins with credentials
	        config.setAllowedOriginPatterns(List.of("http://localhost:5173"));  // Add your other origins as needed

	        // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
	        config.addAllowedMethod("*");

	        // Allow all headers
	        config.addAllowedHeader("*");

	        // Allow credentials, if your requests include credentials (e.g., cookies)
	        config.setAllowCredentials(true);

	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	}



