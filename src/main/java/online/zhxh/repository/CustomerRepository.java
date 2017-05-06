package online.zhxh.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import online.zhxh.vo.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
