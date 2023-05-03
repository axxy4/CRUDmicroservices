package com.microservices.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.Entity.Customer;
import com.microservices.Payload.CustomerDto;
import com.microservices.Repository.CustomerRepository;
import com.microservices.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public CustomerDto createNewCustomer(CustomerDto customerDto) {
		Customer customer = mapToEntity(customerDto);
		Customer save = customerRepo.save(customer);
		return mapToDto(save);
	}

	public Customer mapToEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setId(customerDto.getId());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobile(customerDto.getMobile());
		return customer;
	}
	
	public CustomerDto mapToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobile(customer.getMobile());
		return customerDto;
	}
	
	

	@Override
	public List<CustomerDto> getAllCustomer() {
		List<Customer> findAll = customerRepo.findAll();
		return findAll.stream().map(karan -> mapToDto(karan)).collect(Collectors.toList());
	}

	@Override
	public void deleteById(long id) {
		customerRepo.deleteById(id);
	}

	@Override
	public CustomerDto updateById(CustomerDto customerDto, long id) {
		Optional<Customer> findById = customerRepo.findById(id);
		Customer customer2 = new Customer();
		customer2.setId(customerDto.getId());			
		customer2.setFirstName(customerDto.getFirstName());
		customer2.setLastName(customerDto.getLastName());
		customer2.setEmail(customerDto.getEmail());
		customer2.setMobile(customerDto.getMobile());
		 Customer save = customerRepo.save(customer2);
		 return mapToDto(save);
	}
	
}
