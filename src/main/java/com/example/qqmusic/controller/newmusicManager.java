package com.example.qqmusic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qqmusic.entity.MusicBean.Music;
import com.example.qqmusic.entity.MusicBean.MusicQuery;
import com.example.qqmusic.entity.MusicBean.NewMusic;
import com.example.qqmusic.service.MusicService;
import com.example.qqmusic.service.NewMusicService;
import com.example.qqmusic.utils.R;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Api(tags = "音乐管理中心")
@RequestMapping("/newmusic")
@ComponentScan("com.example")
public class newmusicManager {
    @Autowired
    private NewMusicService musicService;
    @PostMapping("addmusic")
    public R addSinger(@RequestBody NewMusic music){
        musicService.insert(music);
        return R.ok();
    }
    @GetMapping("getMusicById/{id}")
    public R getMusicById(@PathVariable String id){
        QueryWrapper<NewMusic> wrapper =new QueryWrapper<>();
        wrapper.eq("id",id);
        NewMusic music = musicService.selectOne(wrapper);
        return R.ok().data("music",music);
    }
    @GetMapping("getMusicBySingerId/{id}")
    public R getMusicBySingerId(@PathVariable String id){
        QueryWrapper<NewMusic> wrapper =new QueryWrapper();
        wrapper.eq("parent_id",id);
        List<NewMusic> music = musicService.selectList(wrapper);

        return R.ok().data("music",music);
    }
    @GetMapping("getAllMusic")
    public R getAllMusic(){
        List<NewMusic> music = musicService.selectList(null);

        return R.ok().data("music",music);
    }
    @DeleteMapping("removeMusicById/{id}")
    public R removeMusicById(@PathVariable String id){
        QueryWrapper<NewMusic> wapper =new QueryWrapper<>();
        wapper.eq("id",id);
        int delete = musicService.delete(wapper);
        return R.ok();
    }
    @GetMapping("getMusicByName_like/{name}")
    public R getMusicByName_like(@PathVariable String name){
        List<NewMusic> list = new ArrayList<>();
        QueryWrapper<NewMusic> wrapper = new QueryWrapper<>();
        if(!name.contains("f")&&!name.contains("l")&&!name.contains("a")
                &&!name.contains("c")&&!name.contains(".")&&!name.contains("m")&&!name.contains("p")&&!name.contains("3")) {
            wrapper.like("name", name);
            wrapper.notLike("singername", name);

            list = musicService.selectList(wrapper);
        }
        return R.ok().data("list",list);
    }
    @PostMapping("pageMusic/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) MusicQuery musicQuery){
        Page<NewMusic> page=new Page<>(current,limit);
        QueryWrapper<NewMusic> wrapper=new QueryWrapper<>();
        String name = musicQuery.getName();
        String singername = musicQuery.getSingername();
        String vip = musicQuery.getVip();
        String begin = musicQuery.getBegin();
        String end = musicQuery.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(singername)){
            wrapper.like("singername",singername);
        }
        if(!StringUtils.isEmpty(vip)){
            wrapper.eq("vip",vip);
        }


        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_modified",end);
        }
        wrapper.orderByDesc("gmt_modified");
        musicService.selectPage(page,wrapper);
        long total = page.getTotal();
        List<NewMusic> records = page.getRecords();
        for(int i=0;i<records.size();i++){
            System.out.println(records.get(i));
        }
        Map map=new HashMap();
        map.put("total",total);
        map.put("rows",records);
        return R.ok().data(map);
    }
}
