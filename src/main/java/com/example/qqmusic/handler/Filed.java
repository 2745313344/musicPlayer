package com.example.qqmusic.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Filed implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("is_deleted",0,metaObject);
        this.setFieldValByName("gmt_create",new Date(),metaObject);
        this.setFieldValByName("gmt_modified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmt_modified",new Date(),metaObject);
    }
}
