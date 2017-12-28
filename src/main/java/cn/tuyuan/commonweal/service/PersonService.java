package cn.tuyuan.commonweal.service;



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
}
