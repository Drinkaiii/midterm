package com.example.repository;

import com.example.model.CheckOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepositiry extends CrudRepository<CheckOrder, Integer> {

}
