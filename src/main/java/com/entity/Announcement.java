package com.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * (Announcement)实体类
 *
 * @author makejava
 * @since 2020-05-14 19:36:11
 */
public class Announcement implements Serializable {
    private static final long serialVersionUID = 403765384743828331L;
    
    private Integer aid;
    
    private String aname;
    
    private String atime;
    
    private Integer uid;
    
    private String acontent;

    private String uname;
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAcontent(){

        return this.acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", atime='" + atime + '\'' +
                ", uid=" + uid +
                ", acontent='" + acontent + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}