package com.symantec.java.test.eliasbalasis.servlet;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.symantec.java.test.eliasbalasis.DTO.ConverterService;
import com.symantec.java.test.eliasbalasis.DTO.OutputDTO;
import com.symantec.java.test.eliasbalasis.core.GitHubService;

@RestController
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
@RequestMapping(path = "/query", method = RequestMethod.GET)
public class QueryController {

	private GitHubService service;
	private ConverterService converter;

	@RequestMapping(path = "/language")
	public final String queryByLanguage( //
			@RequestParam(required = true, name = "name") //
			final String language //
	) throws IOException {
		final List<OutputDTO> outputList = service.queryByLanguage(language);
		return converter.toJSON(outputList);
	}

	public void setService(final GitHubService service) {
		this.service = service;
	}

	public void setConverter(final ConverterService converter) {
		this.converter = converter;
	}
}
