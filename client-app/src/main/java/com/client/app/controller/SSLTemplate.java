
package com.client.app.controller;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class SSLTemplate {
    @Bean
    RestTemplate restTemplate (RestTemplateBuilder builder) {
        return  builder
                .requestFactory(() -> validateSSL())
                .build();
    }

    private HttpComponentsClientHttpRequestFactory validateSSL()  {
        HttpComponentsClientHttpRequestFactory requestFactory= null;
        try {
        String location = "D:\\client-app.jks";
        String pass = "client-app";
        SSLContext sslContext =null;
        KeyStore keyStore =  KeyStore.getInstance("jks");
        ClassPathResource classPathResource = new ClassPathResource("client-app.jks");
        InputStream inputStream = classPathResource.getInputStream();
        keyStore.load(inputStream, "client-app".toCharArray());

        sslContext = SSLContextBuilder.create().loadTrustMaterial(ResourceUtils.getFile(location),pass.toCharArray())
                    .loadKeyMaterial(keyStore, "client-app".toCharArray())
                    .build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new LocalHostnameVerifier());
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        }
        catch (Exception exception) {
            System.out.println("Exception Occured while creating restTemplate "+exception);
            exception.printStackTrace();
        }
        return  requestFactory;
    }

    private class LocalHostnameVerifier implements HostnameVerifier{

        @Override
        public  boolean verify (String s, SSLSession sslSession){
            return "localhost".equalsIgnoreCase(s) || "127.0.0.1".equalsIgnoreCase(s);
        }
    }

}
