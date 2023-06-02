package com.example.qqmusic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qqmusic.entity.Singer.Singers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
public interface SingerService extends IService<Singers> {
    @Update("update singers set name =#{name},sex=#{sex},intro=#{intro},sort=#{sort},avatar=#{avatar},place=#{place},gmt_modified=#{date} where id=#{id}")
    int updateById(@Param("name") String name,@Param("sex") String sex, @Param("intro") String intro,@Param("sort") int sort,@Param("avatar") String avatar,@Param("place") String place,@Param("date")Date date, @Param("id") String id);
}
