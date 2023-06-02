package com.example.qqmusic.controller;

import com.example.qqmusic.entity.Singer.Singer;
import com.example.qqmusic.mapper.SingerMapper;
import com.example.qqmusic.service.FileService;
import com.example.qqmusic.service.impl.FileServiceImpl;
import com.example.qqmusic.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@CrossOrigin
@Api(tags = "音乐管理中心")
@RequestMapping("/music")
@ComponentScan("com.example")
public class music {
//    @Autowired
    private FileService fileService = new FileServiceImpl();
    @GetMapping("/hello")
    public R hello(){
        String result="hello";
        return R.ok().data("result",result);
    }
    @PostMapping("/uploading")
    public R uploading(MultipartFile file){
        HashMap<String,String> map = fileService.uploadingMusicFile(file);
        return R.ok().data("url",map);
    }
    @PostMapping("/reomve")
    public R remove(String url){
        System.out.println(url);

        boolean flag=fileService.removeMusicFileByUrl(url);
        System.out.println(flag);
        if(flag)
        return R.ok();
        else
            return R.error();
    }

}
