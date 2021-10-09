/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.util.List;
import model.Job;

/**
 *
 * @author Admin
 */
public interface JobDao {

    void add(Job job);

    List<Job> findAll();

    void delete(String job_id);

    void update(Job job);

    List<Job> search(String value);

    void add_worker_id(String add_worker_id);

}
