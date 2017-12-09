package com.landvibe.codefolio.github.service;

import com.landvibe.codefolio.common.rest.CodeFolioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Service
@Slf4j
public class EventService {

    private CodeFolioClient client;

    public EventService(CodeFolioClient client) {
        this.client = client;
    }

    public String getEvents(String token) {
        try {
            String path = "/events";
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get events", e);
            throw e;
        }
    }

}
