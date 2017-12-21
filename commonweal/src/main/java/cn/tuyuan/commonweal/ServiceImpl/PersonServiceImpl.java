package cn.tuyuan.commonweal.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.Dao.PersonDao;
import cn.tuyuan.commonweal.Service.PersonService;
import cn.tuyuan.commonweal.pojo.Person;
/**
 * 
 * @author 陈嘉伟
 * @version 1.0
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonDao personDao;
	
	@Override
	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}

	@Override
	public Person getPerson(Person person) {
		return personDao.getPerson(person);
	}

}
