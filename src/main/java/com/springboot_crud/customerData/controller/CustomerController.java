package com.springboot_crud.customerData.controller;

import com.springboot_crud.customerData.dto.RequestCustomerDto;
import com.springboot_crud.customerData.entity.CustomerEntity;
import com.springboot_crud.customerData.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

    // insert details / customers
    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<String> insertCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        String status = customerService.insertCustomerDetails(requestCustomerDto);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/listAllCustomerDetails")
    public ResponseEntity<List<CustomerEntity>> getAllCustomerDetails() {
        List<CustomerEntity> listOfCustomerDetails = customerService.getAllCustomerDetails();
        return new ResponseEntity<>(listOfCustomerDetails, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<RequestCustomerDto> findCustomerById(@PathVariable Integer id){
        RequestCustomerDto customerDto =  customerService.findCustomerById(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomerByID(@PathVariable Integer id){
        String customerDto =  customerService.deleteCustomerByID(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<RequestCustomerDto> updateCustomerByID(@RequestBody RequestCustomerDto customerDto){
        RequestCustomerDto customerDtos =  customerService.getCustomerDetails(customerDto);
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

}
