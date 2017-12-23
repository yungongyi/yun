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
 * @author 孙家伟
 * @version 1.0
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	//登录
	public Person getPerson(String iphone, String password) {
		//根据数据好查询用户
		Person person = personDao.getPerson(iphone);
		//如果查询到该用户
		if(person!=null){
			//验证该用户的密码是否正确
			if(person.getPassword().equals(password)){
				//如果正确则返回该用户对象
				return  person;
			}
		}
		//否则返回false
		return null;
	}


	//快速登录
	public Person fastLogin(String iphone) {
		//根据数据好查询用户
		Person person = personDao.getPerson(iphone);
		return person;
	}




}
