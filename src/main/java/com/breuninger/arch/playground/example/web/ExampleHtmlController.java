package com.breuninger.arch.playground.example.web;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.breuninger.arch.playground.example.service.ExampleService;

import lombok.AllArgsConstructor;

import io.micrometer.core.annotation.Timed;

@AllArgsConstructor
@Controller
@RequestMapping("/examples")
public class ExampleHtmlController {

  private final ExampleService exampleService;

  @Timed("html.examples.findAll")
  @GetMapping(produces = TEXT_HTML_VALUE)
  public ModelAndView findAll() {
    final var model = new ModelMap();
    model.put("examples", exampleService.findAll());
    return new ModelAndView("exampleOverviewPage.html", model);
  }
}
