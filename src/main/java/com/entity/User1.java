package com.entity;

import java.io.Serializable;

/**
 * (User1)实体类
 *
 * @author makejava
 * @since 2020-05-25 16:17:57
 */
public class User1 implements Serializable {
    private static final long serialVersionUID = -88135454852163755L;
    
    private Integer uid;
    
    private String uname;
    
    private String upassword;
    
    private String utype;
    
    private Integer usend;
    
    private String utime;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public Integer getUsend() {
        return usend;
    }

    public void setUsend(Integer usend) {
        this.usend = usend;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "User1{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", utype='" + utype + '\'' +
                ", usend=" + usend +
                ", utime='" + utime + '\'' +
                '}';
    }
}