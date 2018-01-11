package cn.tuyuan.commonweal.dao;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Region;
/**
 * @author 孙家伟
 * 2017年12月27日
 *  
 */
public interface NoticeDao { 

	public List<Notice> getNotice();

	/**
	 * @根据用户id获取所有启示列表
	 */
	public List<Notice> getNoticeByPersonId(Integer id);


	/**
	 * @param PersonId
	 * @param NoticeId
	 * @return 影响行数
	 * 根据用户id 启示id 删除启示信息
	 */
	int  deleteNoticeByPersonIdAndNoticeId(Integer PersonId,Integer NoticeId);


	/**
	 * 分页查询启事
	 * @param first 从那条开始
	 * @param pageSize 查询几条
	 * @return
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	List<Notice> getNoticeList(Integer stateId,String date) throws DataAccessException, Exception; 

	/**
	 * 根据启事标题查询启事信息
	 */
	List<Notice> getNoticeBynoticeTittle(String noticeTittle);

	/**
	 * 删除启事
	 * @param id
	 */
	void delNotice(Integer id);


	/**
	 * 根据启事ID查询启事信息
	 */
	List<Notice> getNoticeById(Integer id);
	//主页面全站查询
	List<Notice> searchAllOfNotice(String Content);
	//多条件查询
	public List<Notice>  getNoticeByQ(Integer regionId, String describe, Integer noticeType,Integer noticeState);
	

}
