package com.microservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
