package com.example.qqmusic.entity.MusicBean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//@Component
public class Music implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value="id", type= IdType.ID_WORKER_STR)
    private String id;
    private String parent_id;
    private String name;
    private String singername;
    private String url;
    private String lrcname;
    private String singer;
    private String lrc;
    private String vip;
    private int count;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer is_deleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmt_create;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmt_modified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLrcname() {
        return lrcname;
    }

    public void setLrcname(String lrcname) {
        this.lrcname = lrcname;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getLrc() {
        return lrc;
    }

    public void setLrc(String lrc) {
        this.lrc = lrc;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getIsDeleted() {
        return is_deleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.is_deleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmt_create;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmt_create = gmtCreate;
    }

    public Date getGmtModified() {
        return gmt_modified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmt_modified = gmtModified;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id='" + id + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", name='" + name + '\'' +
                ", singername='" + singername + '\'' +
                ", url='" + url + '\'' +
                ", lrcname='" + lrcname + '\'' +
                ", singer='" + singer + '\'' +
                ", lrc='" + lrc + '\'' +
                ", vip='" + vip + '\'' +
                ", count=" + count +
                ", is_deleted=" + is_deleted +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                '}';
    }
}
