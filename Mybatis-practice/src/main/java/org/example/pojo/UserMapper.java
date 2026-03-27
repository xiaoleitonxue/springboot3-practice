package org.example.pojo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //@Select("select id, username, password, name, age from user")
    public List<User> findAll();

    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);

    @Insert("insert into user(id, username, password, name, age) values(#{id}, #{username}, #{password}, #{name}, #{age})")
    public void insert(User user);

    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public void update(User user);

    @Select("select * from user where id = #{id} and password = #{password}")
    public User findByIdAndPassword(@Param("id") Integer id, @Param("password") String password);

}
