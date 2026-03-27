package org.example;

import org.example.pojo.User;
import org.example.pojo.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPracticeApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        System.out.println(userMapper.findAll());
    }

    @Test
    public void deleteById() {
        Integer i = userMapper.deleteById(5);
        System.out.println("撒旦:" + i);
    }

    @Test
    public void testinsert() {
        User user = new User(5,"zhangsan", "123456", "张三", 18);
        userMapper.insert(user);
    }

    @Test
    public void testupdate() {
        User user = new User(5,"zhangsan", "122343456", "张三", 255);
        userMapper.update(user);
    }

    @Test
    public void testfindByIdAndPassword() {
        User user = userMapper.findByIdAndPassword(5, "122343456");
        System.out.println(user);
    }

}
