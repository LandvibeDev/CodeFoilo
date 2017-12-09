package com.landvibe.codefolio.common.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.Map;

import static com.landvibe.codefolio.common.Constants.RequestHeader.AUTH_HEADER_PREFIX;

@Component
public class CodeFolioClient {

    @Value("${github.api-host}")
    private String apiHost;

    private final RestTemplate restTemplate;

    public CodeFolioClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getEntity(String path, String auth) {
        HttpHeaders headers = getHttpHeaderWithAuth(auth);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(apiHost + path, HttpMethod.GET, entity, String.class).getBody();
    }

    public String getEntity(String path, HttpHeaders customHeader) {
        HttpEntity<String> entity = new HttpEntity<>(null, customHeader);
        return restTemplate.exchange(apiHost + path, HttpMethod.GET, entity, String.class).getBody();
    }

    public String getEntity(String path, String auth, MultiValueMap<String, String> query) {
        HttpHeaders headers = getHttpHeaderWithAuth(auth);
        String hostUrl = UriComponentsBuilder.fromUriString(apiHost + path).queryParams(query).toUriString();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(hostUrl, HttpMethod.GET, entity, String.class).getBody();
    }

    public String getEntity(String path, HttpHeaders customHeader, MultiValueMap<String, String> query) {
        String hostUrl = UriComponentsBuilder.fromUriString(apiHost + path).queryParams(query).toUriString();
        HttpEntity<String> entity = new HttpEntity<>(null, customHeader);
        return restTemplate.exchange(hostUrl, HttpMethod.GET, entity, String.class).getBody();
    }

    public String postEntity(String path, String auth, Map<String, Object> payload) {
        HttpEntity entity = getHttpEntityForPostRequest(payload, auth);
        return restTemplate.exchange(apiHost + path, HttpMethod.POST, entity, String.class).getBody();
    }

    public String putEntity(String path, String auth, Map<String, Object> payload) {
        HttpEntity entity = getHttpEntityForPostRequest(payload, auth);
        return restTemplate.exchange(apiHost + path, HttpMethod.PUT, entity, String.class).getBody();
    }

    private HttpEntity getHttpEntityForPostRequest(Map<String, Object> payload, String auth) {
        HttpHeaders headers = getHttpHeaderWithAuth(auth);
        if (payload.size() > 0) {
            return new HttpEntity<>(payload, headers);
        } else {
            return new HttpEntity<>(null, headers);
        }
    }

    private HttpHeaders getHttpHeaderWithAuth(String auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set(HttpHeaders.AUTHORIZATION, AUTH_HEADER_PREFIX + auth);
        return headers;
    }
}
