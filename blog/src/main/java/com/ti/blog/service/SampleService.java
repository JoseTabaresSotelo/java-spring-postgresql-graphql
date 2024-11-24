package com.ti.blog.service;

import java.util.List;

import com.ti.blog.entity.Sample;

public interface SampleService {
    Sample getSample(Long id);

    Sample saveSample(Sample sample);

    void deleteSample(Long id);

    List<Sample> getSamples();
}
