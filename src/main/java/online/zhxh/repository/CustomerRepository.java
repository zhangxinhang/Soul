package online.zhxh.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import online.zhxh.vo.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
