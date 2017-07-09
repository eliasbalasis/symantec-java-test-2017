package com.symantec.java.test.eliasbalasis.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symantec.java.test.eliasbalasis.DTO.ConverterService;
import com.symantec.java.test.eliasbalasis.DTO.OutputDTO;
import com.symantec.java.test.eliasbalasis.core.GitHubService;

public class QueryControllerTest {

	private static final String LANGUAGE = "language";

	private QueryController queryController;
	private GitHubService service;
	private ConverterService converter;
	private List<OutputDTO> outputList;
	@Captor
	private ArgumentCaptor<List<OutputDTO>> outputListCaptor;

	@BeforeMethod
	public void setup() throws IOException {
		queryController = new QueryController();
		service = Mockito.mock(GitHubService.class);
		queryController.setService(service);
		converter = Mockito.mock(ConverterService.class);
		queryController.setConverter(converter);
		outputList = new ArrayList<>();
		Mockito.doReturn(outputList).when(service).queryByLanguage(Mockito.same(LANGUAGE));
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void queryByLanguage() throws IOException {

		queryController.queryByLanguage(LANGUAGE);

		final InOrder inOrder = Mockito.inOrder(service, converter);
		inOrder.verify(service).queryByLanguage(Mockito.same(LANGUAGE));
		inOrder.verify(converter).toJSON(outputListCaptor.capture());
		Assert.assertSame(outputListCaptor.getValue(), outputList);
	}
}
