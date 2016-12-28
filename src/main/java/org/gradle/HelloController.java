package org.gradle;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	Person home() {
		Person p = new Person("hello world");
		return p;
	}
}
