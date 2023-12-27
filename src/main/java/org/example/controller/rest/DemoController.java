package org.example.controller.rest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.PropertyEditorSupport;

@RestController
@RequestMapping("/demos")
public class DemoController {
  @InitBinder // 1
  public void bind(WebDataBinder binder) { // 2
    binder.registerCustomEditor(Long.class, new PropertyEditorSupport() { // 3
      @Override
      public void setAsText(String text) throws IllegalArgumentException {
        setValue(Long.valueOf(text) + 666L) ;

      }
    }) ;
  }
  @GetMapping("/index")
  public Object index(Long id) {
    return "index - " + id ;
  }
}