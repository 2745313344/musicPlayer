package com.example.qqmusic.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.qqmusic.entity.MusicBean.NewMusic;
import org.springframework.stereotype.Component;

@Component
public interface NewMusicService extends BaseMapper<NewMusic> {
}
