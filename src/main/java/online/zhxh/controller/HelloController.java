package online.zhxh.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import online.zhxh.mapper.GreetingMapper;
import online.zhxh.vo.Greeting;

@Controller
@RequestMapping("/hello")
public class HelloController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingMapper greetingMapper;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Greeting sayHello(
			@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, greetingMapper.findByState("1").getContent()) + "sd");
	}

	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/testx")
	public @ResponseBody int test() {
		int temp = greetingMapper.insertData("hello testx1");
		return temp;
	}

}
