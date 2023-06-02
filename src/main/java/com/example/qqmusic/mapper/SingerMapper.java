package com.example.qqmusic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qqmusic.entity.Singer.Singer;
import com.example.qqmusic.entity.Singer.Singers;
import org.springframework.stereotype.Component;

@Component
public interface SingerMapper extends IService<Singers> {
}
