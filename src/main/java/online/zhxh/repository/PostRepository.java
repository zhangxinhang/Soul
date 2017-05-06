package online.zhxh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.zhxh.vo.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	//@EntityGraph(attributePaths = { "user" })
	Post getOne(Integer id); 
}
