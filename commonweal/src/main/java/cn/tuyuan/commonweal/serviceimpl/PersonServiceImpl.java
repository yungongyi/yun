package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.PersonDao;
import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.service.PersonService;
/**
 * 
 * @author 陈嘉伟
 * @version 1.0
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
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
