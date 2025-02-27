package com.springboot_crud.customerData.service;


import com.springboot_crud.customerData.dto.RequestCustomerDto;
import com.springboot_crud.customerData.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    String insertCustomerDetails(RequestCustomerDto requestCustomerDto);


    List<CustomerEntity> getAllCustomerDetails();

    RequestCustomerDto findCustomerById(Integer id);

    String deleteCustomerByID(Integer id);

    RequestCustomerDto getCustomerDetails(RequestCustomerDto customerDto);
}
