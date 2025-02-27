package com.springboot_crud.customerData.repository;

import com.springboot_crud.customerData.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
