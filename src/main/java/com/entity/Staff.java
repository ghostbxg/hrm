package com.entity;

import java.io.Serializable;

/**
 * (Staff)实体类
 *
 * @author makejava
 * @since 2020-05-31 20:15:35
 */
public class Staff implements Serializable {
    private static final long serialVersionUID = -39978891719347594L;
    
    private Integer sid;
    
    private String sname;
    
    private String sphonenumber;
    
    private String sidnumber;
    
    private String seduction;
    
    private String semail;
    
    private String sadress;
    
    private String ssex;
    
    private String stime;
    
    private Integer pid;
    
    private Integer jid;

    private String pname;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    private String jname;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphonenumber() {
        return sphonenumber;
    }

    public void setSphonenumber(String sphonenumber) {
        this.sphonenumber = sphonenumber;
    }

    public String getSidnumber() {
        return sidnumber;
    }

    public void setSidnumber(String sidnumber) {
        this.sidnumber = sidnumber;
    }

    public String getSeduction() {
        return seduction;
    }

    public void setSeduction(String seduction) {
        this.seduction = seduction;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

}