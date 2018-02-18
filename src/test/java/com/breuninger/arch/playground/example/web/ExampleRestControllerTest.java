package com.breuninger.arch.playground.example.web;

import static java.util.Collections.singletonList;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.breuninger.arch.playground.common.AbstractWebIntegrationTest;
import com.breuninger.arch.playground.example.domain.Example;
import com.breuninger.arch.playground.example.service.ExampleService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExampleRestControllerTest extends AbstractWebIntegrationTest {

  @MockBean
  private ExampleService exampleService;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void expectToGetExamples() throws Exception {
    // given
    final Example example = Example.builder().text("test").build();
    final List<Example> examples = singletonList(example);
    given(exampleService.findAll()).willReturn(examples);

    // when & then
    mvc.perform(get(URI.create("/examples"))
      .accept(APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().json(objectMapper.writeValueAsString(examples)));
  }
}
