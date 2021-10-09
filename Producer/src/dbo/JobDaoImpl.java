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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Job;

/**
 *
 * @author Admin
 */
public class JobDaoImpl implements JobDao {

   public void add(Job job) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try {
            StringBuilder sql = new StringBuilder("INSERT INTO JOB");
            sql.append("(job_id, name, kind, status, worker_id, execution_time, start_time, end_time, job_output) ");
            sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            cnt = DatabaseConnection.getConnection();
            stm = cnt.prepareStatement(sql.toString());
            stm.setString(1, job.getJob_id());
            stm.setString(2, job.getName());
            stm.setString(3, job.getKind());
            stm.setString(4, job.getStatus());
            stm.setString(5, job.getWorker_id());
            stm.setInt(6, job.getExecution_time());

//			stm.setString(7, (job.getStart_time()));
//			stm.setString(8, (job.getEnd_time()));
            stm.setTimestamp(7, Timestamp.valueOf(job.getStart_time()));
            stm.setTimestamp(8, Timestamp.valueOf(job.getEnd_time()));
            stm.setString(9, job.getJob_output());
            System.out.println(stm);
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATA HAS BEEN ADDED!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "CAN NOT ADD DATA!");

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

    public void delete(String job_id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        ResultSet res = null;
        try {
            String sql = "DELETE FROM JOB WHERE job_id = ?";
            cnt = DatabaseConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql);
            stm.setString(1, job_id);
            stm.executeUpdate();
            cnt.commit();
            JOptionPane.showMessageDialog(null, "RECORD HAS BEEN DELETED!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                cnt.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "CANNOT DELETE RECORD!");
            }
        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void update(Job job) {
        Connection cnt = null;
        PreparedStatement stm = null;
        try {
            StringBuilder sql = new StringBuilder("UPDATE JOB ");
            sql.append("SET job_id = ?, name = ?, kind = ?, status = ?, worker_id = ?, execution_time = ?, start_time = ?, end_time = ?, job_output = ?");
            sql.append(" WHERE id = ?");
            cnt = DatabaseConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql.toString());
            stm.setString(1, job.getJob_id());
            stm.setString(2, job.getName());
            stm.setString(3, job.getKind());
            stm.setString(4, job.getStatus());
            stm.setString(5, job.getWorker_id());
            stm.setInt(6, job.getExecution_time());
            stm.setTimestamp(7, Timestamp.valueOf(job.getStart_time()));
            stm.setTimestamp(8, Timestamp.valueOf(job.getEnd_time()));
            stm.setString(9, job.getJob_output());
            stm.setInt(10, job.getId());
            stm.executeUpdate();
            cnt.commit();
            JOptionPane.showMessageDialog(null, "DATA HAS BEEN UPDATED!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                cnt.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "CAN NOT UPDATE DATA!");

            }
        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    public List<Job> search(String value) {
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

    @Override
    public void add_worker_id(String add_worker_id) {
        Connection cnt = null;
        PreparedStatement stm = null;
        try {
            StringBuilder sql = new StringBuilder("UPDATE JOB ");
            sql.append("SET worker_id = ? , status = 'progress' ");
            sql.append("WHERE id IN (SELECT JOB.id FROM JOB where status = 'non' limit 1)");
            cnt = DatabaseConnection.getConnection();
            cnt.setAutoCommit(false);
            stm = cnt.prepareStatement(sql.toString());
            stm.setString(1, add_worker_id);
            stm.executeUpdate();
            cnt.commit();
            JOptionPane.showMessageDialog(null, "WORKER ID HAS BEEN ADDED!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                cnt.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "CAN NOT ADD WORKER ID!");

            }
        } finally {
            try {
                if (cnt != null) {
                    cnt.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
