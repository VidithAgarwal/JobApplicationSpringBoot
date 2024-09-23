package com.LearnSpring.SpringBootFirstApp.job.impl;

import com.LearnSpring.SpringBootFirstApp.job.Job;
import com.LearnSpring.SpringBootFirstApp.job.JobService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

  private final List<Job> jobs = new ArrayList<>();
  private Long nextId = 1L;
  @Override
  public List<Job> findAll() {
    return jobs;
  }

  @Override
  public void createJob(Job job) {
    job.setId(nextId++);
    jobs.add(job);
  }

  @Override
  public Job getJobById(Long id) {
    for (Job job: jobs) {
      if (job.getId() == id) {
        return job;
      }
    }

    return null;
  }

  @Override
  public boolean deleteJobById(Long id) {
    for (Job job: jobs) {
      if (job.getId() == id) {
        jobs.remove(job);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean updateJobById(Long id, Job updatedJob) {

    for (Job job : jobs) {
      if (job.getId() == id) {
        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        job.setMaxSalary(updatedJob.getMaxSalary());
        job.setMinSalary(updatedJob.getMinSalary());
        job.setLocation(updatedJob.getLocation());
        return true;
      }
    }
    return false;
  }
}
