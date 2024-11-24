package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.ti.blog.entity.Sample;

public interface SampleRepository extends CrudRepository<Sample, Long> {

}
