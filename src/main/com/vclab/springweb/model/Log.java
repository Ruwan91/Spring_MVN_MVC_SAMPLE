package com.vclab.springweb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logid;

    @Column(name = "detail")
    private String detail;

    @Column(name = "dateTime")
    private Date dateTime;

    @Column(name = "customer")
    private Integer customer;

    public Log() {
    }

    public Log(Integer logid, String detail, Date dateTime, Integer customer) {
        this.logid = logid;
        this.detail = detail;
        this.dateTime = dateTime;
        this.customer = customer;
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Log[" + logid + "-" + detail + "-" + dateTime + "-" + customer + "]";
    }


}
