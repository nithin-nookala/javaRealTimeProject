package com.notificationApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificationApi.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
