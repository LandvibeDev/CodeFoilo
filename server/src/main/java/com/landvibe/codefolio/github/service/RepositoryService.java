package com.landvibe.codefolio.github.service;

import com.landvibe.codefolio.common.rest.CodeFolioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Service
@Slf4j
public class RepositoryService {

    private CodeFolioClient client;

    public RepositoryService(CodeFolioClient client) {
        this.client = client;
    }

    public String getRepositories(String token) {
        try {
            String path = "/user/repos";
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get repositories", e);
            throw e;
        }
    }

    public String getOrgRepositories(String org, String token) {
        try {
            String path = "/orgs/" + org + "/repos";
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get repositories", e);
            throw e;
        }
    }

    public String getRepository(String owner, String repo, String token) {
        try {
            String path = "/user/" + owner + "/" + repo;
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get {} repository", repo, e);
            throw e;
        }
    }

    public String getLanguages(String owner, String repo, String token) {
        try {
            String path = "/repos/" + owner + "/" + repo + "/languages";
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get {} languages", repo, e);
            throw e;
        }
    }

    public String getTopics(String owner, String repo, String token) {
        try {
            String path = "/repos/" + owner + "/" + repo + "/topics";
            return client.getEntity(path, token);
        } catch (HttpServerErrorException | HttpClientErrorException e) {
            log.error("failed to get {} topics", repo, e);
            throw e;
        }
    }
}
