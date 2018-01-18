package cn.tuyuan.commonweal.service;
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
public interface NoticeService {

	//新增一条启事
	public int saveNotice(Notice notice);
	//1.无条件查询所有启事
	public List<Notice> getNotice();

	//根据用户id查询启示列表
	List<Notice> getAllNoticeByPersonId(Integer id);
	//根据用户id 启示id删除启示信息
	boolean deleteNoticeByPersonIdAndNoticeId(Integer personId ,Integer noticeId);

	//分页查询启事(pagesize=0时候查询所有)
	public List<Notice> getAllNotice(Integer stateId,String date) throws DataAccessException, Exception;


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


	//根据条件查询启示列表
	List<Notice> getmainNotice();
	//主页面全站查询
	List<Notice> searchAllOfNotice(String content);

	//修改启事状态根据启事id
	int updateStateBynoticeId(Notice notice);
	/**
	 * @param NoticeId
	 * @return
	 * 根据启示id查询启示信息
	 */
	Notice getNoticeByid(Integer NoticeId);
}



