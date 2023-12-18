package com.ekino.intro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class IntroController {

  @GetMapping("/reflect")
  public String reflectMethod() {
    try {
      Method method = this.getClass().getDeclaredMethod("privateMethod");
      method.setAccessible(true);
      return (String) method.invoke(this);
    } catch (Exception e) {
      return "Reflection Error: " + e.getMessage();
    }
  }

  @GetMapping("/resource")
  public String resource() {
    try (var input = this.getClass().getClassLoader().getResourceAsStream("my-resource.txt")) {
      return new String(input.readAllBytes());
    } catch (Exception e) {
      return "Resource Error: " + e.getMessage();
    }
  }

  private String privateMethod() {
    return "Reflected Method Invoked";
  }
}
