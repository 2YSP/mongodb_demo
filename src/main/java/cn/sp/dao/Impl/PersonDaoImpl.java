package cn.sp.dao.Impl;

import cn.sp.bean.Person;
import cn.sp.dao.PersonDao;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author ship
 * @Description
 * @Date: 2018-07-04 14:17
 */
@Service("personDao")
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(Person person) {
        mongoTemplate.insert(person);
    }

    @Override
    public void update(Person person) {
        Query query = new Query(Criteria.where("_id").is(person.getpId()));
        Update update = new Update()
                            .set("name",person.getName())
                            .set("age",person.getAge())
                            .set("birthday",person.getBirthday());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,Person.class);
    }

    @Override
    public void delete(int pId) {
        DeleteResult result = mongoTemplate.remove(new Query(Criteria.where("_id").is(pId)), Person.class);
    }

    @Override
    public Person findByPId(int pId) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(pId)), Person.class);
    }
}
