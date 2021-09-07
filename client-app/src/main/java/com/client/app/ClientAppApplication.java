package com.client.app;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		//System.setProperty("javax.net.ssl.trustStore","D:\\client-app.jks");
		//System.setProperty("javax.net.ssl.trustStorePassword", "client-app");
		SpringApplication.run(ClientAppApplication.class, args);
	}
	

}
