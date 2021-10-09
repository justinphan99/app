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

    List<Job> findAll();

    List<Job> search_worker_id(String value);

    List<Job> search_job_id(String value);

}
