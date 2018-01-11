package cn.tuyuan.commonweal.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.service.NoticeService;
import cn.tuyuan.commonweal.dao.NoticeDao;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource
	NoticeDao noticeDao;

	// 根据用户id查询启示列表
	public List<Notice> getAllNoticeByPersonId(Integer id) {
		List<Notice> notices = noticeDao.getNoticeByPersonId(id);
		return notices;
	}

	// 根据用户id 启示id删除启示信息
	public boolean deleteNoticeByPersonIdAndNoticeId(Integer personId,
			Integer noticeId) {
		int result = noticeDao.deleteNoticeByPersonIdAndNoticeId(personId,
				noticeId);
		try {
			if (result > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	// 分页查询启事，pageSize为0时候查询所有
	@Override
	public List<Notice> getAllNotice(Integer stateId, String date) throws DataAccessException, Exception {
		return noticeDao.getNoticeList(stateId, date);
	}

	/**
	 * 根据启事标题查询启事信息
	 */
	@Override
	public List<Notice> getNoticeBynoticeTittle(String noticeTittle) {
		return noticeDao.getNoticeBynoticeTittle(noticeTittle);
	}

	/**
	 * 删除启事
	 */
	@Override
	public void delNotice(Integer id) {
		noticeDao.delNotice(id);
	}

	/**
	 * 根据启事ID查询启事信息
	 */
	@Override
	public List<Notice> getNoticeById(Integer id) {
		return noticeDao.getNoticeById(id);
	}

	//无条件查询所有启事
	@Override
	public List<Notice> getNotice() {
		return noticeDao.getNotice();
	}
	//根据条件查询所有的启示列表
	public List<Notice> getmainNotice() {
		List<Notice> notices = noticeDao.getNoticeByQ(0,null,0,0);
		return notices;
	}
	//根据输入信息查询指定条件的启示信息列表
	public List<Notice> searchAllOfNotice(String content) { 
		return noticeDao.searchAllOfNotice(content);
	}
	

}
