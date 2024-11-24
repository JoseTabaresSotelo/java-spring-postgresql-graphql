package com.ti.blog.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ti.blog.entity.Sample;
import com.ti.blog.repository.SampleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SampleServiceImpl implements SampleService {

    SampleRepository sampleRepository;

    @Override
    public Sample getSample(Long id) {
        return sampleRepository.findById(id).get();
    }

    @Override
    public Sample saveSample(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public void deleteSample(Long id) {
        sampleRepository.deleteById(id);
    }

    @Override
    public List<Sample> getSamples() {
        return (List<Sample>) sampleRepository.findAll();
    }
}
