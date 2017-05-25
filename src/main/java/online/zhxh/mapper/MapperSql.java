package online.zhxh.mapper;

public class MapperSql {
	public String insertSql() { 
		return "INSERT INTO test_content (content) VALUES (#{content});";
	}
}
