package com.ti.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ti.blog.entity.Sample;
import com.ti.blog.service.SampleService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    SampleService sampleService;

    @GetMapping("/{id}")
    public ResponseEntity<Sample> getSample(@PathVariable Long id) {
        return new ResponseEntity<>(sampleService.getSample(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sample> saveSample(@Valid @RequestBody Sample sample) {
        return new ResponseEntity<>(sampleService.saveSample(sample), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSample(@PathVariable Long id) {
        sampleService.deleteSample(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sample> updateSample(@Valid @RequestBody Sample sample, @PathVariable Long id) {
        return new ResponseEntity<>(sampleService.updateSample(sample, id), HttpStatus.OK);
    }
}
