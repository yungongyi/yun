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

/**
	 * 根据用户id查询单个用户
	 * 
	 * @param person
	 * @return 电话 
	 * 景子铭
	 */
	String getPerson(Integer personId);
	
	/**
	 * 根据用户id查询单个用户
	 * 
	 * @param person
	 * @return 电话 
	 * 景子铭
	 */
	Person getPersonbyId(Integer personId);
	
	  /**
     * @param person
     * @return 影响行数
     *  @author 孙家伟
     *   修改用户密码
     */
    boolean   updatePersonPassword(Integer personId,String password);
    
    /**
     * @param person
     * @author 孙家伟
     * 修改用户信息
     */
    boolean  updatePerson(Person person);
    
    /**
     * 查询所有用户
     * @author 高俊东
     */
	List<Person> getPerson();
	
	
	/**
	 * 根据手机号查询用户信息
	 */
	List<Person> getPersonByiphone(String iphone);
	
	
	
	/**
	 * 根据用户Id查询用户信息
	 */
	List<Person> getPersonBypersonid(int id);
	
	/**
	 * 修改用户状态
	 */
	void updatePersonBystate(int pid,int sid);
}
