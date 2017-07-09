package com.symantec.java.test.eliasbalasis.core;

import java.io.IOException;
import java.util.List;

import com.symantec.java.test.eliasbalasis.DTO.OutputDTO;

public interface GitHubService {

	String GITHUB_API_BASE_URL = "https://api.github.com";

	String GITHUB_API_PATH_SEARCH_REPOSITORIES = "/search/repositories";

	String GITHUB_API_URL_SEARCH_REPOSITORIES = GITHUB_API_BASE_URL + GITHUB_API_PATH_SEARCH_REPOSITORIES;

	List<OutputDTO> queryByLanguage(String language) throws IOException;

}
