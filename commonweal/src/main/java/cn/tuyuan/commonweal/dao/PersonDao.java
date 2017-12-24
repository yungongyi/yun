package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Person;

 

/**
 * @author 孙家伟
 * 2017年12月23日
 *
 */
public interface PersonDao {
	   
	  /**
	 * @param  手机号
	 * @return  一个用户对象
	 */
	public Person  getPerson(String iphone);
	
	/**
	 * @param 根据手机id获取用户对象
	 * @return
	 */
	public boolean  getPersonByid(String iphone);
	/**
	 * 2017年12月24日
	 * @param 添加一条用户信息
	 * @return 影响行数
	 */
	public int  savePerson(Person person);
	
}
