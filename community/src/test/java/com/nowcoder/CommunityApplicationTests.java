package com.nowcoder;

import com.nowcoder.controller.testcontroller;
import com.nowcoder.dao.DiscussPostMapper;
import com.nowcoder.dao.UserMapper;
import com.nowcoder.dao.testDao;
import com.nowcoder.entity.DiscussPost;
import com.nowcoder.entity.User;
import org.assertj.core.internal.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ComponentScan
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
//    @Autowired
//    testcontroller t;
    @Autowired
    private UserMapper usermapper;
    @Autowired
    private DiscussPostMapper postMapper;

    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Test
    public void testSelectUser(){
        User user = usermapper.selectByName("liubei");
        System.out.println(user);
    }
    @Test
    void printTime(){
        SimpleDateFormat dateFormat = context.getBean(SimpleDateFormat.class);
        System.out.println(dateFormat.format(new Date()));
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("阿童木");
        user.setPassword("sfg24");
        int rows = usermapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user);
        System.out.println(user.getId());
    }
    @Test
    public void testUpdate(){
        usermapper.updateStatus(150,1);
        usermapper.updateHeader(150,"https://atongmu.com");
        usermapper.updatePassword(150,"xiaosiwole");

    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> discussPosts = postMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
        int rows = postMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }


}
