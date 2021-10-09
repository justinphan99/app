/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dbo.JobDao;
import dbo.JobDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import javax.swing.JOptionPane;
import model.Job;
import java.util.Map;
import static utils.CheckNumeric.checkNumeric;
import static utils.CheckTimestamp.checkTimestamp;

/**
 *
 * @author Admin
 */
public class JobServiceImpl implements JobService {

    public JobDao jobDao;

    public JobServiceImpl() {
        jobDao = new JobDaoImpl();
    }

    @Override
    public void add(Map<String, String> map) {
        //System.out.println(map.get("id"));
        String job_id = map.get("job_id");
        String name = map.get("name");
        String kind = map.get("kind");
        String status = map.get("status");
        String worker_id = map.get("worker_id");
        String execution_time = map.get("execution_time");
        String start_time = map.get("start_time");
        String end_time = map.get("end_time");
        String job_output = map.get("job_output");

        if (job_id.equals("")) {
            JOptionPane.showMessageDialog(null, "JOB_ID IS MISSING");
        } else if (kind.equals("")) {
            JOptionPane.showMessageDialog(null, "KIND IS MISSING");
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "NAME IS MISSING");
        } else if (status.equals("")) {
            JOptionPane.showMessageDialog(null, "STATUS IS MISSING");
        } else if (!checkNumeric(execution_time)) {
            JOptionPane.showMessageDialog(null, "EXECUTION TIME IS INVALID");
        } else {
            String start_time_tmp = null;
            String end_time_tmp = null;
            if ((start_time.equals("")) && (end_time.equals(""))) {
                start_time_tmp = "1900-01-01 00:00:00";
                end_time_tmp = "1900-01-01 00:00:00";
                Integer execution_time_int = Integer.parseInt(execution_time);
                Job job = new Job(job_id, name, kind, status, worker_id, execution_time_int, start_time_tmp, end_time_tmp, job_output);
                jobDao.add(job);
            } else if (!checkTimestamp(start_time)) {
                JOptionPane.showMessageDialog(null, "START TIME TIME IS INVALID");
            } else if (!checkTimestamp(end_time)) {
                JOptionPane.showMessageDialog(null, "END TIME TIME IS INVALID");
            } else {
                Integer execution_time_int = Integer.parseInt(execution_time);
                Job job = new Job(job_id, name, kind, status, worker_id, execution_time_int, start_time, end_time, job_output);
                jobDao.add(job);
            }

        }
    }

    public List<Job> findAll() {
        List<Job> list = jobDao.findAll();
        return list;
    }

    public void delete(String job_id) {
        jobDao.delete(job_id);

    }

    @Override
    public void update(Map<String, String> map) {
        String id = map.get("id");
        String job_id = map.get("job_id");
        String name = map.get("name");
        String kind = map.get("kind");
        String status = map.get("status");
        String worker_id = map.get("worker_id");
        String execution_time = map.get("execution_time");
        String start_time = map.get("start_time");
        String end_time = map.get("end_time");
        String job_output = map.get("job_output");

        if (job_id.equals("")) {
            JOptionPane.showMessageDialog(null, "JOB_ID IS MISSING");
        } else if (kind.equals("")) {
            JOptionPane.showMessageDialog(null, "KIND IS MISSING");
        } else if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "NAME IS MISSING");
        } else if (status.equals("")) {
            JOptionPane.showMessageDialog(null, "STATUS IS MISSING");
        } else if (!checkNumeric(execution_time)) {
            JOptionPane.showMessageDialog(null, "EXECUTION TIME IS INVALID");
        } else {
            String start_time_tmp = null;
            String end_time_tmp = null;
            if ((start_time.equals("")) && (end_time.equals(""))) {
                start_time_tmp = "1900-01-01 00:00:00";
                end_time_tmp = "1900-01-01 00:00:00";
                Integer id_int = Integer.parseInt(id);
                Integer execution_time_int = Integer.parseInt(execution_time);
                Job job = new Job(id_int, job_id, name, kind, status, worker_id, execution_time_int, start_time_tmp, end_time_tmp, job_output);
                jobDao.update(job);
            } else if (!checkTimestamp(start_time)) {
                JOptionPane.showMessageDialog(null, "START TIME TIME IS INVALID");
            } else if (!checkTimestamp(end_time)) {
                JOptionPane.showMessageDialog(null, "END TIME TIME IS INVALID");
            } else {
                Integer execution_time_int = Integer.parseInt(execution_time);
                Integer id_int = Integer.parseInt(id);
                Job job = new Job(id_int, job_id, name, kind, status, worker_id, execution_time_int, start_time, end_time, job_output);
                jobDao.update(job);
            }

        }

    }

    @Override
    public List<Job> search(String value) {
        List<Job> list = new ArrayList<>();
        if (value.equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER SEARCH VALUE");

        } else {
            list = jobDao.search(value);
        }
        return list;
    }

    @Override
    public void add_worker_id(String add_worker_id) {
        if (add_worker_id.equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER SEARCH VALUE");
        } else {
            jobDao.add_worker_id(add_worker_id);
        }
    }

}
