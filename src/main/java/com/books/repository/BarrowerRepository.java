package com.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.books.entity.Barrower;

@Repository
public interface BarrowerRepository extends CrudRepository<Barrower, Long>{

}
