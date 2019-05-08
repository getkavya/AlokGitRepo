package com.example.oauth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
   private String clientid = "tutorialspoint";
   private String clientSecret = "my-secret-key";
   private String privateKey =  
   		"CB1558B2429D6E7F1983A2714574E677\r\n" + 
   		"\r\n" + 
   		"ust9FIJhUA+NiYsfPURaejCsIFiCf697WcKEjYPEK/jhqJ5LmLBtBlnz5TvyF799\r\n" + 
   		"PVrR1UeHWZg9VREWwjJ/+0dmd0Vz5UfaD+SN1rjTsciRBiCU6msDBtXalUJm4Ts2\r\n" + 
   		"QbBPdAhV3V5x2KZ2mVO4dm/X3BTzofUP8cZHXAP6Q9iN5pLO86v6VESzQ+ZQIb5o\r\n" + 
   		"stVajXnUDfph5lTwWqTsiu1esyFsIkTVXbvqdM3NnTMUux9ar//HCPXAAVDouMca\r\n" + 
   		"St2A5wb4g4Yo9TAsyNN/m7/+FgJD4QKvTdCHCkiTteJQK+9/1LOL108v0nSxXg8p\r\n" + 
   		"pHbo5RvPS8kwwHJohWInibGP2/QbJDuKpSU3OTdyZiTiQGSSztzRFUXwmQuWc1bU\r\n" + 
   		"LO2zus/Vfqq38R8LsGGYIfFfTtRy3Z7cf8bblzEHaWl5D3b6tfzKeWbqko9q3/8+\r\n" + 
   		"Gsz8QpC6G0ao6bdf2RGAt7bbnSlTbkWmjT987DbYzNrY6mbzweBxnYxARXaw3eFw\r\n" + 
   		"ejzvZayDqjratvWOiKBQ78KGDzCI8OgpI9mWvqvgN8ePe0LcYN74r4r926lXgU08\r\n" + 
   		"c4CxcRAmF8NYpRWcCyJW5KiWEuMIRjaFBjTKCpHXxZ96Su/6XeP06mAi5qKBhZBI\r\n" + 
   		"fmR9fIF+2+FjPV0G+9b+Rj2/JK93xmdRjpuLLGDstOByCX8jhSwU7BCpwIx74eRa\r\n" + 
   		"mxsIJ9I9yMOBXUMs/DgqkJxkqAwS1HGMrn+ei9KUQ9BumHKFQGByip4YwYQ8Lp9m\r\n" + 
   		"bW94GSVsHkBOStph192HauHdXtG+w0HMeNENrmu8HV6TTDQN1HjcTsfoJXGYw7R1\r\n" + 
   		"nmB5V8Rteb7Cde/qdOO8+Jq4ddqHpNudxtQ/89L6idBjSh4m8HSqxj1xDYS3jXnl\r\n" + 
   		"HwmmfY+bvo8/aEh1wvB/uwMf86hBG2iEh0CsIQ5R2TrAWfj6kME7I/MiEOla75g+\r\n" + 
   		"K2jK4PWlVFQslN1xv8AZXb5jAqXJoNGISrgzuHTKnmL8oJBCQYg9O9rySg3thERo\r\n" + 
   		"Onq2+eepdhYGXPOtcsPTVMpcOhVKFv9R8kgFtzcsQbCuR5fOg3oUIFGdZCvAkn/J\r\n" + 
   		"dinotLehAnZat/sEd+ssQXVf9vrrKWKrGmEvm6//OHxRo6a3LCxjbeYIh0sl+Ar7\r\n" + 
   		"azo0UTToBliEzucrRA+HeoCyPs1fmyg1Iign2l5zOUhMQEABHz+bss+X8XXuOdgh\r\n" + 
   		"/thWbLH8pr3M6XG4q5xqDDE1OosthZdj/PqkyjoggoF7rDXXSlS8N8/Q73VsGKxU\r\n" + 
   		"axg6wVrH25ECCv0+Ko6OOoYMsLEWt/YxJ7XPubaeB+3p4hkEF83MOVrT1R5YXu0T\r\n" + 
   		"CUjDzlMOtYjtB1DTfy6IBBgoEF8cK6i385ofWzeekaeNTcEPkYPOvpQzP2U6pkLh\r\n" + 
   		"QSlEc3+GaMpm2TuheXWLTm47UYEtx6JbeYoKcbes+uUFdy+2a5K+qzdRMpfv36zO\r\n" + 
   		"WyjEgnaH57kZFDew3MxWqggR3mr5daRwwaXeCUw3ND4eMsourH3p8qdPp9K8u5GN\r\n" + 
   		"Ug5XWcnlx5XNc9TWVFd2t6JGsZ2152P5xVYmjtKSOxeegZN/0RLgPEKWWvGNgJAT\r\n";
   
   private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr1+oOCfSvR36eHySgFLF\r\n" + 
   		"K9JXbumckDEH7IGbcksTEhIfFlS8lGXTPx2DIM4BwMCjwizyJvsTSmVu0BquJrag\r\n" + 
   		"IwmPCfH3++dZUirX+anJeIN72kvq723qD9eMzhXAiaRVSSz9iRUqYNyo+ok3UG8D\r\n" + 
   		"zKvt5VC68mWIKGdIuiQSEg5ulQfHVGG4C/nTlqPiU0U0rQJOcM7K1aIHBWFMpD1X\r\n" + 
   		"BZQAB3PrwSMy7uRJiED+AZol8xTIjHz+UGiQQQgB1OyaoUAGmJxFZamqCFKt0lwe\r\n" + 
   		"sam1jSdAmQKeg6hzXYBr9BX5EX5gsaW+s0+EctHjHMGluX1Ugpe+ISOG+5Y1GiUA\r\n" + 
   		"zwIDAQAB";

   @Autowired
   @Qualifier("authenticationManagerBean")
   private AuthenticationManager authenticationManager;
   
   @Bean
   public JwtAccessTokenConverter tokenEnhancer() {
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      converter.setSigningKey(privateKey);
      converter.setVerifierKey(publicKey);
      return converter;
   }
   @Bean
   public JwtTokenStore tokenStore() {
      return new JwtTokenStore(tokenEnhancer());
   }
   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
      .accessTokenConverter(tokenEnhancer());
   }
   @Override
   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
      security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
   }
   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
         .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
         .refreshTokenValiditySeconds(20000);

   }
} 
