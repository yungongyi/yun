package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.dao.IdeaDao;
import cn.tuyuan.commonweal.pojo.Idea;
import cn.tuyuan.commonweal.service.IdeaService;

/**
 * 
 * @author 景子铭
 * @version 1.0
 */

@Service("ideaService")
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private IdeaDao ideaDao;

	@Override
	public List<Idea> getAllIdea() {
		return ideaDao.getAllIdea();
	}

	@Override
	public Idea getIdea(Integer ideaId) {
		return ideaDao.getIdea(ideaId);
	}

	@Override
	public void updateIdea(Integer ideaId, Integer stateId) {
		ideaDao.updateIdea(ideaId, stateId);
	}

	@Override
	public String delIdea(Integer ideaId) {
		return ideaDao.delIdea(ideaId);
	}
	
	@Override
	public int saveIdea(String content, String eamil, HttpSession se) {
		return ideaDao.saveIdea(content, eamil, se);
	}

}
