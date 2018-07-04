package cn.sp.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-04 14:15
 */
//@Data  lombok虽然好用但隐藏了好多坑啊,@RequestBody注解获取不到pId的值
@Document(collection = "personInfo")
public class Person implements Serializable{
    @Id
    @Field("p_id")
    private int pId;
    private String name;
    private int  age;
    private Date  birthday;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
