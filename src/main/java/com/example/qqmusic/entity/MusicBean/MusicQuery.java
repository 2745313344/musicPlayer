package com.example.qqmusic.entity.MusicBean;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
public class MusicQuery {
    @ApiModelProperty(value = "歌手名称，模糊查询")
    private String singername;
    @ApiModelProperty(value = "歌曲名称，模糊查询")
    private String name;
    @ApiModelProperty(value = "歌曲品质")
    private String vip;
    @ApiModelProperty(value = "查询开始时间")
    private String begin;
    @ApiModelProperty(value = "查询结束时间")
    private String end;

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
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

    @Override
    public String toString() {
        return "MusicQuery{" +
                "singername='" + singername + '\'' +
                ", name=" + name +
                ", vip='" + vip + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
