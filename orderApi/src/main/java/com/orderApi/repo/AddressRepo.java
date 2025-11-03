package com.orderApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderApi.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
