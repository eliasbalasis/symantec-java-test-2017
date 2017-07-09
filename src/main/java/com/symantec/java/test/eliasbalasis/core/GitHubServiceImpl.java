package com.symantec.java.test.eliasbalasis.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egit.github.core.SearchRepository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.java.test.eliasbalasis.DTO.OutputDTO;

public class GitHubServiceImpl implements GitHubService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GitHubServiceImpl.class);

	@Override
	public List<OutputDTO> queryByLanguage(final String language) throws IOException {
		LOGGER.info("Executing GitHub repositories query for language {}", language);
		final RepositoryService repositoryService = new RepositoryService();
		final Map<String, String> params = new LinkedHashMap<>();
		params.put("language", language);
		final List<SearchRepository> repositoryList = repositoryService.searchRepositories(params);
		final List<OutputDTO> outputList = new ArrayList<>();
		for (SearchRepository repository : repositoryList) {
			final OutputDTO output = convertSearchRepository(repository);
			outputList.add(output);
		}
		return outputList;
	}

	private OutputDTO convertSearchRepository(final SearchRepository repository) {
		final OutputDTO dto = new OutputDTO();
		dto.setId(repository.getId());
		dto.setName(repository.getName());
		dto.setUrl(repository.getUrl());
		dto.setOwner(repository.getOwner());
		return dto;
	}
}
