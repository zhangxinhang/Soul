package online.zhxh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import online.zhxh.vo.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {

}
