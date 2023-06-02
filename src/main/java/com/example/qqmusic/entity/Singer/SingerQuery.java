package com.example.qqmusic.entity.Singer;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class SingerQuery {
    @ApiModelProperty(value = "歌手名称，模糊查询")
    private String name;
    @ApiModelProperty(value = "歌手头衔")
    private Integer sort;
    @ApiModelProperty(value = "歌手籍贯")
    private String place;
    @ApiModelProperty(value = "歌手简介")
    private String intro;

    @ApiModelProperty(value = "歌手性别")
    private String sex;

    @ApiModelProperty(value = "查询开始时间")
    private String begin;
    @ApiModelProperty(value = "查询结束时间")
    private String end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
