package org.example.controller.rest;

import org.example.entity.User;
import org.example.service.DemoService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.beans.PropertyEditorSupport;

@RestController
@RequestMapping("/demos")
public class DemoController {

  @Resource
  DemoService demoService;

  @GetMapping("/findOne")
  public User findOne(String name){
    return demoService.findOne(name);
  }
  @GetMapping("/exception")
  public User exception(String name){
    if(name.equals("DP")) throw new IllegalArgumentException("name error");
    return demoService.findOne(name);
  }

//  @InitBinder // 1
//  public void bind(WebDataBinder binder) { // 2
//    binder.registerCustomEditor(Long.class, new PropertyEditorSupport() { // 3
//      @Override
//      public void setAsText(String text) throws IllegalArgumentException {
//        setValue(Long.valueOf(text) + 666L) ;
//
//      }
//    }) ;
//  }
  @GetMapping("/index")
  public Object index(Long id) {
    return "index - " + id ;
  }
}