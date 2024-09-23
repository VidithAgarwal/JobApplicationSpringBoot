package com.LearnSpring.SpringBootFirstApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

  JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Job>> findAll() {
    return ResponseEntity.ok( jobService.findAll());
  }

  @PostMapping("/")
  public ResponseEntity<String> createJob(@RequestBody Job job) {
    jobService.createJob(job);
    return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    return jobService.getJobById(id) == null? new ResponseEntity<>(HttpStatus.NOT_FOUND) :
            new ResponseEntity<>(jobService.getJobById(id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJob (@PathVariable Long id) {
    boolean deleted = jobService.deleteJobById(id);
    return deleted ? new ResponseEntity<>("Job deleted successfully", HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateJob (@PathVariable Long id, @RequestBody Job job) {
    boolean updated = jobService.updateJobById(id, job);
    return updated ? new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK) :
            new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
  }
}
