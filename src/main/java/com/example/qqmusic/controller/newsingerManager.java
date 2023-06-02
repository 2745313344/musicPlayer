package com.example.qqmusic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qqmusic.entity.Singer.NewSingers;
import com.example.qqmusic.entity.Singer.SingerQuery;
import com.example.qqmusic.entity.Singer.Singers;
import com.example.qqmusic.service.NewSingerService;
import com.example.qqmusic.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@Api(tags = "歌手管理中心")
@RequestMapping("/newsinger")
@ComponentScan("com.example")
public class newsingerManager {
    @Autowired
    private NewSingerService newSingerService;
    @Autowired
    private BaseMapper<NewSingers> baseMapper;
    @PostMapping("addSinger")
    public R addSinger(@RequestBody NewSingers singer){
        baseMapper.insert(singer);
        return R.ok();
    }
//    @PostMapping("updateSinger")
//    public R updateSinger(@RequestBody NewSingers singer){
//        newSingerService.updateById(singer.getName(),singer.getSex(),singer.getIntro(),singer.getSort(),singer.getAvatar(),singer.getPlace(),new Date(),singer.getId());
//        return R.ok();
//    }
@DeleteMapping("removeSingerById/{id}")
public R removeMusicById(@PathVariable String id){
    QueryWrapper<NewSingers> wapper =new QueryWrapper<>();
    wapper.eq("id",id);
    baseMapper.delete(wapper);
    return R.ok();
}
    @GetMapping("getSingerByName_like/{name}")
    public R getSingerByName_like(@PathVariable String name){
        QueryWrapper<NewSingers> wrapper =new QueryWrapper<>();
        wrapper.like("name",name);
        List<NewSingers> list = baseMapper.selectList(wrapper);
        return R.ok().data("list",list);
    }
    @GetMapping("getSingerById/{id}")
    public R getSingerById(@PathVariable String id){
        QueryWrapper<NewSingers> wrapper =new QueryWrapper();
        wrapper.eq("id",id);
        NewSingers singer = baseMapper.selectOne(wrapper);
        return R.ok().data("singer",singer);
    }
    @GetMapping("getSingerByName/{name}")
    public R getSingerByName(@PathVariable String name){
        QueryWrapper<NewSingers> wrapper =new QueryWrapper<>();
        wrapper.eq("name",name);
        NewSingers singer = baseMapper.selectOne(wrapper);
        return R.ok().data("singer",singer);
    }
    @GetMapping("singerList")
    public R List(){
        List<NewSingers> singers = baseMapper.selectList(null);
        ArrayList<String> list =new ArrayList<>();
        for (int i = 0; i < singers.size(); i++) {
            list.add(singers.get(i).getName());
        }
        return R.ok().data("list",list);
    }
    @GetMapping("getALLSinger")
    public R getAllSinger(){
        List<NewSingers> list = baseMapper.selectList(null);
        return R.ok().data("list",list);
    }
    @GetMapping("getIdByName/{name}")
    public R getIdByName(@PathVariable String name){
        QueryWrapper<NewSingers> wrapper =new QueryWrapper<>();
        wrapper.eq("name",name);
        NewSingers singers = baseMapper.selectOne(wrapper);
        String id = singers.getId();
        return R.ok().data("id",id);
    }
    @PostMapping("pageSinger/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) SingerQuery singerQuery){
        Page<NewSingers> page=new Page<>(current,limit);
        QueryWrapper<NewSingers> wrapper=new QueryWrapper<>();
        String name = singerQuery.getName();
        Integer sort = singerQuery.getSort();
        String place = singerQuery.getPlace();
        String sex = singerQuery.getSex();
        String begin = singerQuery.getBegin();
        String end = singerQuery.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(sort)){
            wrapper.eq("sort",sort);
        }
        if(!StringUtils.isEmpty(place)){
            wrapper.eq("place",place);
        }

        if(!StringUtils.isEmpty(sex)){
            wrapper.eq("sex",sex);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            wrapper.le("gmt_modified",end);
        }
        wrapper.orderByDesc("gmt_modified");
        baseMapper.selectPage(page,wrapper);
        long total = page.getTotal();
        List<NewSingers> records = page.getRecords();
        for(int i=0;i<records.size();i++){
            System.out.println(records.get(i));
        }
        Map map=new HashMap();
        map.put("total",total);
        map.put("rows",records);
        return R.ok().data(map);
    }
}
