package cn.tuyuan.commonweal.service;



import java.util.List;

import cn.tuyuan.commonweal.pojo.Person;

/**
 * @author 孙家伟
 * 2017年12月23日
 *
 */
public interface PersonService {
	/**
	 * @describe 登录验证1
	 * @return all person
	 */
	 Person getPerson(String iphone ,String password );
	 
	 /**
	 * @param 快速登录
	 * @return
	 */
	Person  fastLogin(String iphone);
	
	/**   2017年12月24日
	 * @param 用户注册
	 * @return 影响番薯
	 */
	int savePerson(Person person);
	
	/**
	 * @param 根据手机id判断用户是否存在
	 * @return
	 */
	boolean getPersonById(String iphone);


/**
	 * 查询单个用户 
	 * 景子铭
	 * @param person
	 * @return String 电话
	 */

	String getPerson(Integer personId);
	
	/**
	 * 查询单个用户 
	 * 景子铭
	 * @param person
	 * @return String 电话
	 */

	Person getpersonbyId(Integer personId);
	
	//修改用户密码
	boolean updatePersonPassword(Integer personId,String password);
	//修改用户信息
	boolean updatePerson(Person person);
	//根据手机号码查询用户对象
	Person  getPersonByPhone(String iphone);
	
	/**
	 * 查询所有
	 */
	List<Person> getPerson();
	
	/**
	 * 根据手机号查询用户信息
	 */
	List<Person> getPersonByiphone(String iphone);
	
	
	/**
	 * 根据用户Id查询用户信息
	 */
	List<Person> getPersonBypersonid(Integer id);
	
	/**
	 * 修改用户状态
	 */
	void updatePersonBystate(int pid,int sid);
}
