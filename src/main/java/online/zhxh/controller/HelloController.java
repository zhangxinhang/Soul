package online.zhxh.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import online.zhxh.mapper.GreetingMapper;
import online.zhxh.repository.CustomerRepository;
import online.zhxh.vo.Customer;
import online.zhxh.vo.Greeting;
import online.zhxh.vo.View;

@Controller
@RequestMapping("/hello")
public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingMapper greetingMapper;
	@Autowired
	private CustomerRepository repository;

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

	@JsonView(View.OneToMany.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Customer onFindOne(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/testJPA")
	public @ResponseBody int testJpa() {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		Customer customer = repository.findOne(1L);
		log.info("Customer found with findOne(1L):");
		log.info("--------------------------------");
		log.info(customer.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		for (Customer bauer : repository.findByLastName("Bauer")) {
			log.info(bauer.toString());
		}
		return 1;
	}

}
