package dev.dreameh.backend.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping("/")
  public String indexPage() {
    return "redirect:/swagger-ui/index.html";
  }
}
