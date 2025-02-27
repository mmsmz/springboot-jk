package com.springboot_crud.customerData.service;

import com.springboot_crud.customerData.dto.RequestCustomerDto;
import com.springboot_crud.customerData.entity.CustomerEntity;
import com.springboot_crud.customerData.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String insertCustomerDetails(RequestCustomerDto requestCustomerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(requestCustomerDto.getName());
        customerEntity.setEmail(requestCustomerDto.getEmail());
        customerEntity.setPhone(requestCustomerDto.getPhone());

        Optional<CustomerEntity> saveData = Optional.of(customerRepository.save(customerEntity));
        if (saveData.isPresent()) {
            return "Success";
        } else
            return "Failed";
    }

    @Override
    public List<CustomerEntity> getAllCustomerDetails() {
        List<CustomerEntity> all = customerRepository.findAll();
        return all;
    }

    @Override
    public RequestCustomerDto findCustomerById(Integer id) {
        RequestCustomerDto customerDto = new RequestCustomerDto();
        Optional<CustomerEntity> byId = customerRepository.findById(id);
        if (byId.isPresent()) {
            CustomerEntity customerEntity = byId.get();
            customerDto.setName(customerEntity.getName());
            customerDto.setPhone(customerEntity.getPhone());
            customerDto.setEmail(customerEntity.getEmail());
        }
        return customerDto;
    }

    @Override
    public String deleteCustomerByID(Integer id) {
        if(!customerRepository.existsById(id)){
            return "Customer with ID " + id + " not found.";
        }

        customerRepository.deleteById(id);
        return "Customer with ID " + id + " has been deleted successfully.";
    }

    @Override
    public RequestCustomerDto getCustomerDetails(RequestCustomerDto customerDto) {

        if(!customerRepository.existsById(customerDto.getId())){
            throw new RuntimeException();
        }

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.getId());
        customerEntity.setName(customerDto.getName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setPhone(customerDto.getPhone());
        CustomerEntity save = customerRepository.save(customerEntity);


        return customerDto;
    }
}
