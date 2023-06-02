package com.example.qqmusic.entity.Singer;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Singer对象", description="歌手描述")
@Component
public class Singer implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value="id", type= IdType.ID_WORKER_STR)
    private String id;
    private String name;
    private String intro;
    private String avatar;
    private Integer sort;
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

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sort=" + sort +
                ", is_deleted=" + is_deleted +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                '}';
    }
}
