package com.entity;

import java.io.Serializable;

/**
 * (Doument)实体类
 *
 * @author makejava
 * @since 2020-06-01 22:52:41
 */
public class Doument implements Serializable {
    private static final long serialVersionUID = -66187212356869918L;
    
    private Integer did;
    
    private String dtime;
    
    private String dtitle;
    
    private String dcontent;
    
    private Integer uid;
    
    private String dcontentnr;

    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public String getDtitle() {
        return dtitle;
    }

    public void setDtitle(String dtitle) {
        this.dtitle = dtitle;
    }

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDcontentnr() {
        return dcontentnr;
    }

    public void setDcontentnr(String dcontentnr) {
        this.dcontentnr = dcontentnr;
    }

}