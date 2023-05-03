package com.microservices.Service;

import java.util.List;

import com.microservices.Payload.CustomerDto;

public interface CustomerService {

	CustomerDto createNewCustomer(CustomerDto customerDto);

	List<CustomerDto> getAllCustomer();

	void deleteById(long id);

	CustomerDto updateById(CustomerDto customerDto, long id);


}
