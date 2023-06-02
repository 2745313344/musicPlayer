package com.example.qqmusic.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qqmusic.entity.MusicBean.Music;
import org.springframework.stereotype.Component;

@Component
public interface MusicService extends BaseMapper<Music> {
}
