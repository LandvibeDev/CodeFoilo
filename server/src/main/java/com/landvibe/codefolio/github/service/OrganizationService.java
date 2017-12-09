package com.landvibe.codefolio.github.service;

import com.landvibe.codefolio.common.rest.CodeFolioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Service
@Slf4j
public class OrganizationService {

    private CodeFolioClient client;

    public OrganizationService(CodeFolioClient client) {
        this.client = client;
    }

    public String getOrganizations(String token) {
        try {
            String path = "/user/orgs";
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get organizations", e);
            throw e;
        }
    }

    public String getOrganization(String organization, String token) {
        try {
            String path = "/orgs/" + organization;
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get organization", e);
            throw e;
        }
    }
}
