/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Job;

/**
 *
 * @author Admin
 */
public class JobDaoImpl implements JobDao {
    @Override
    public List<Job> findAll() {
        List<Job> list = new ArrayList<>();
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try {
            String sql = "SELECT * FROM JOB";
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql);
            res = stm.executeQuery();
            while (res.next()) {
                Integer id = res.getInt("id");
                String job_id = res.getString("job_id");
                String name = res.getString("name");
                String kind = res.getString("kind");
                String worker_id = res.getString("worker_id");
                String status = res.getString("status");
                Integer execution_time = res.getInt("execution_time");

                String start_time = null;
                java.sql.Timestamp start_time_1 = res.getTimestamp("start_time");
                if (start_time_1 != null) {
                    start_time = res.getTimestamp("start_time").toString();
                } else {
                    start_time = null;
                }
                String end_time = null;
                java.sql.Timestamp end_time_1 = res.getTimestamp("end_time");
                if (end_time_1 != null) {
                    end_time = res.getTimestamp("end_time").toString();
                } else {
                    end_time = null;
                }
                String job_output = res.getString("job_output");
                Job j = new Job(id, job_id, name, kind, status, worker_id, execution_time, start_time, end_time, job_output);
                list.add(j);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (res != null) {
                    res.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
    
    @Override
    public List<Job> search_worker_id(String value) {
        List<Job> list = new ArrayList<>();
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try {
            StringBuilder sql_like = new StringBuilder("SELECT * FROM JOB");
            sql_like.append(" WHERE worker_id LIKE ?");
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql_like.toString());
            stm.setString(1, value);
            res = stm.executeQuery();
            while (res.next()) {
                Integer id = res.getInt("id");
                String job_id = res.getString("job_id");
                String name = res.getString("name");
                String kind = res.getString("kind");
                String worker_id = res.getString("worker_id");
                String status = res.getString("status");
                Integer execution_time = res.getInt("execution_time");

                String start_time = null;
                java.sql.Timestamp start_time_1 = res.getTimestamp("start_time");
                if (start_time_1 != null) {
                    start_time = res.getTimestamp("start_time").toString();
                } else {
                    start_time = null;
                }
                String end_time = null;
                java.sql.Timestamp end_time_1 = res.getTimestamp("end_time");
                if (end_time_1 != null) {
                    end_time = res.getTimestamp("end_time").toString();
                } else {
                    end_time = null;
                }

                String job_output = res.getString("job_output");
                Job job = new Job(id, job_id, name, kind, status, worker_id, execution_time, start_time, end_time, job_output);
                list.add(job);
            }
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "CAN NOT SEARCH DATA!");
            return null;

        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (res != null) {
                    res.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public List<Job> search_job_id(String value) {
        List<Job> list = new ArrayList<>();
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try {
            StringBuilder sql_like = new StringBuilder("SELECT * FROM JOB");
            sql_like.append(" WHERE job_id LIKE ?");
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql_like.toString());
            stm.setString(1, value);
            res = stm.executeQuery();
            while (res.next()) {
                Integer id = res.getInt("id");
                String job_id = res.getString("job_id");
                String name = res.getString("name");
                String kind = res.getString("kind");
                String worker_id = res.getString("worker_id");
                String status = res.getString("status");
                Integer execution_time = res.getInt("execution_time");

                String start_time = null;
                java.sql.Timestamp start_time_1 = res.getTimestamp("start_time");
                if (start_time_1 != null) {
                    start_time = res.getTimestamp("start_time").toString();
                } else {
                    start_time = null;
                }
                String end_time = null;
                java.sql.Timestamp end_time_1 = res.getTimestamp("end_time");
                if (end_time_1 != null) {
                    end_time = res.getTimestamp("end_time").toString();
                } else {
                    end_time = null;
                }

                String job_output = res.getString("job_output");
                Job job = new Job(id, job_id, name, kind, status, worker_id, execution_time, start_time, end_time, job_output);
                list.add(job);
            }
            return list;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "CAN NOT SEARCH DATA!");
            return null;

        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (res != null) {
                    res.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }    
    
}
