package net.osgg.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
public class PersonController {

  @GetMapping("/registration")
  public String greetingForm(Model model) {
    model.addAttribute("person", new Person());
    return "registration";
  }

  /*
  @PostMapping("/registration")
  public String greetingSubmit(@ModelAttribute Person person) {
    return "result";
  }
  */
  
  @PostMapping("/registration")
  public String checkPersonInfo(@ModelAttribute @Valid Person person, Errors errors) {
	if (errors.hasErrors() ) {
		return "registration";
	}
	return "result";
  }
  
}