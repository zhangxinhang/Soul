package online.zhxh.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import online.zhxh.repository.PostRepository;
import online.zhxh.vo.Post;
import online.zhxh.vo.View;

@Controller
@RequestMapping("/post")
public class PostController extends BaseController {

	@Autowired
	private PostRepository postRepository;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Post onSave(@RequestBody(required = true) Post post) {
		post.setSubmit_time(new Date());
		return postRepository.save(post);
	}

	@JsonView(View.ManyToOne.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Post onFindOne(@PathVariable("id") Integer id) {
		return postRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Page<Post> onQuery(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size,
			@RequestParam(value = "title", required = false, defaultValue = "") String title) {
		return postRepository.findAll(new PageRequest(page, size));
	}

}
