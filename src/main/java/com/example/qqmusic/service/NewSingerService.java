package com.example.qqmusic.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.qqmusic.entity.Singer.NewSingers;
import org.springframework.stereotype.Component;

@Component
public interface NewSingerService extends BaseMapper<NewSingers> {
}
