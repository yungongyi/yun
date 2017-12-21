package cn.tuyuan.commonweal.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.pojo.Person;

@Transactional
public interface PersonService {
	/**
	 * @describe 查询所有用户
	 * @return all person
	 */
	List<Person> getAllPerson();
	
	/**
	 * 查询单个用户
	 * @param person
	 * @return Person
	 */
	
	Person getPerson(Person person);
}
