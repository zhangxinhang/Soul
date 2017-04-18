package online.zhxh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import online.zhxh.vo.Greeting;

@Mapper
public interface GreetingMapper {

	@Select("SELECT id, content FROM test_content WHERE id = #{id}")
	Greeting findByState(String id);

}
