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
}
