package model;

public class Job {

    private Integer id;
    private String job_id;
    private String name;
    private String kind;
    private String status;
    private String worker_id;
    private Integer execution_time;
    private String start_time;
    private String end_time;
    private String job_output;

    public Job() {

    }

    public Job(Integer id, String job_id, String name, String kind, String status, String worker_id, Integer execution_time, String start_time, String end_time, String job_output) {
        this.id = id;
        this.job_id = job_id;
        this.name = name;
        this.kind = kind;
        this.status = status;
        this.worker_id = worker_id;
        this.execution_time = execution_time;
        this.start_time = start_time;
        this.end_time = end_time;
        this.job_output = job_output;
    }

    public Job(String job_id, String name, String kind, String status, String worker_id, Integer execution_time, String start_time, String end_time, String job_output) {
        this.job_id = job_id;
        this.name = name;
        this.kind = kind;
        this.status = status;
        this.worker_id = worker_id;
        this.execution_time = execution_time;
        this.start_time = start_time;
        this.end_time = end_time;
        this.job_output = job_output;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(String worker_id) {
        this.worker_id = worker_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(Integer execution_time) {
        this.execution_time = execution_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getJob_output() {
        return job_output;
    }

    public void setJob_output(String job_output) {
        this.job_output = job_output;
    }

    public Object[] toObject() {
        return new Object[]{id, job_id, name, kind, status, worker_id, execution_time, start_time, end_time, job_output};
    }
}
