package empservice.request.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long empNo;
    private String status;

    // No args constructor for JPA
    public Request() {
    }

    // Constructor to create a Request with empNo
    public Request(long empno) {
        this.empNo = empno;
        this.status = "PENDING";
    }

    // Getters and Setters
    public long getId(){
        return id;
    }

    public long getEmpno(){
        return empNo;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setEmpNo(long empNo){
        this.empNo = empNo;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
