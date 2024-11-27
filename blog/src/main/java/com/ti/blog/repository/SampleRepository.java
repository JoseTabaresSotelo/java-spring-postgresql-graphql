package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ti.blog.entity.Sample;

@Repository
public interface SampleRepository extends CrudRepository<Sample, Long> {

}
