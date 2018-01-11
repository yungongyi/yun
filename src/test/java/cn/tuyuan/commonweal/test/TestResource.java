package cn.tuyuan.commonweal.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tuyuan.commonweal.dao.NoticeDao;
import cn.tuyuan.commonweal.dao.ResourceDao;
import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.service.ResourceService;

public class TestResource {

	private ApplicationContext app;
	
	@Test
	public void test() {
	try {
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		NoticeDao noticeDao=(NoticeDao) app.getBean("noticeDao");
	
		
		//2.新增
	/*	Resource rrr=new Resource();
		rrr.setResourcePath("a");
		rrr.setType(new Type(1,1,"预判"));
		resourceDao.addResource(rrr);	*/
		//1.查询
		List<Notice> re=noticeDao.getNoticeList(0, null);
		for(Notice r:re){
			System.out.println(r.getResource().getResourcePath()+"id_"+r.getType().getTypeName());
		}
		//2.修改
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
