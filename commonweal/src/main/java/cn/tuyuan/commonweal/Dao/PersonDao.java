package cn.tuyuan.commonweal.Dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Person;

/**
 * 
 * @author 陈嘉伟
 * @version 1.0
 */
public interface PersonDao {

	
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
