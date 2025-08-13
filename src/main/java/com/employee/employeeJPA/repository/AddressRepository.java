package com.employee.employeeJPA.repository;

import com.employee.employeeJPA.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
