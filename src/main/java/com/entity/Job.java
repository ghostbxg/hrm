package com.entity;

import java.io.Serializable;

/**
 * (Job)实体类
 *
 * @author makejava
 * @since 2020-05-25 16:19:35
 */
public class Job implements Serializable {
    private static final long serialVersionUID = -97492439167966963L;
    
    private Integer jid;
    
    private String jname;
    
    private String jcontent;


    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJcontent() {
        return jcontent;
    }

    public void setJcontent(String jcontent) {
        this.jcontent = jcontent;
    }

}