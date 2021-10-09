/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map;

import model.Job;

/**
 *
 * @author Admin
 */
public interface JobService {

    void add(Map<String, String> map);

    List<Job> findAll();

    void delete(String job_id);

    void update(Map<String, String> map);

    List<Job> search(String value);

    void add_worker_id(String add_worker_id);

}
