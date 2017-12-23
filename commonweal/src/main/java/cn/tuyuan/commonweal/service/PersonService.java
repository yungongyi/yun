package cn.tuyuan.commonweal.service;


import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.pojo.Person;

/**
 * @author 孙家伟
 * 2017年12月23日
 *
 */
@Transactional
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
	
}
