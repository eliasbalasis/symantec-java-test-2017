package com.symantec.java.test.eliasbalasis.DTO;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConverterServiceImpl implements ConverterService {

	@Override
	public String toJSON(final List<OutputDTO> outputList) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		final String json = gson.toJson(outputList);
		return json;
	}

}
