/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobService;

import dbo.JobDao;
import dbo.JobDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Job;

/**
 *
 * @author Admin
 */
public class JobServiceImpl implements JobService {

    public JobDao jobDao;

    public JobServiceImpl() {
        jobDao = new JobDaoImpl();
    }

    public List<Job> findAll() {
        List<Job> list = jobDao.findAll();
        return list;
    }
    
    @Override
    public List<Job> search_worker_id(String value) {
        List<Job> list = new ArrayList<>();
        if (value.equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER SEARCH VALUE");

        } else {
            list = jobDao.search_worker_id(value);
        }
        return list;
    }
    
    @Override
    public List<Job> search_job_id(String value) {
        List<Job> list = new ArrayList<>();
        if (value.equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER SEARCH VALUE");

        } else {
            list = jobDao.search_job_id(value);
        }
        return list;
    }
}
