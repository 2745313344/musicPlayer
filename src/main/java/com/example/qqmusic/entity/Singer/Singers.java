package com.example.qqmusic.entity.Singer;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SingerVo对象", description="歌手描述")
public class Singers implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value="id", type= IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private String intro;
    private String avatar;
    private Integer sort;
    private String sex;
    private String album;
    private String place;
    private String group_s;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGroup_s() {
        return group_s;
    }

    public void setGroup_s(String group_s) {
        this.group_s = group_s;
    }

    public Integer getIs_deleted() {
        return isDeleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.isDeleted = is_deleted;
    }

    public Date getGmt_create() {
        return gmtCreate;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmtCreate = gmt_create;
    }

    public Date getGmt_modified() {
        return gmtModified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmtModified = gmt_modified;
    }

    @Override
    public String toString() {
        return "Singers{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sort=" + sort +
                ", sex='" + sex + '\'' +
                ", album='" + album + '\'' +
                ", place='" + place + '\'' +
                ", group_s='" + group_s + '\'' +
                ", is_deleted=" + isDeleted +
                ", gmt_create=" + gmtCreate +
                ", gmt_modified=" + gmtModified +
                '}';
    }
}
