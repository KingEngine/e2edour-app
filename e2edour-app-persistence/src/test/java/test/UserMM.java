package test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config/application_persistence.xml")
public class UserMM extends AbstractJUnit4SpringContextTests{
	@Resource
	private MongoTemplate template;
	@Test
	public void testInsert(){
		Person p = new Person();
		p.setName("collection3");
		template.insert(p);
	}
	@Test
	public void delete(){
		template.remove(new Query(Criteria.where("age").is("男")), "person");
	}
	@Test
	public void update() {
		// 查到当前的记录
		Query query = new Query(new Criteria("age").is(13.3));
		Update update = new Update();
		update.set("age", 13.3);
		update.set("height","177cm" );
		//template.updateFirst(query, update, Person.class);
		template.updateMulti(query, update, Person.class);
	}
	@Test
	public void find() {
		// 查到当前的记录
		Query query = new Query(new Criteria("age").is(13.3));
		List<Person> ps = template.find(query, Person.class);
		for(Person p:ps){
			System.out.println("id:"+p.getId());
		}
	}
}
