package cn.tuyuan.commonweal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.Idea;
import cn.tuyuan.commonweal.pojo.Message;
import cn.tuyuan.commonweal.service.IdeaService;

@RestController("ideaController")
@RequestMapping("/idea")
public class IdeaController {

	@Resource
	private IdeaService ideaService;

	@RequestMapping(value = "/getIdea", method = RequestMethod.GET)
	public List<Idea> getIdea() {
		List<Idea> list = ideaService.getAllIdea();
		return list;
	}

	@RequestMapping(value = "/getIdeaById", method = RequestMethod.GET)
	public List<Idea> getIdeaById(Integer ideaId) {
		List<Idea> ideaList = null;
		// 判断id是否为空
		if (ideaId == null) {
			// id为空 查询全部信息
			ideaList = (List<Idea>) ideaService.getAllIdea();
		} else {
			// id不为空 根据id查询信息
			ideaList = new ArrayList<Idea>();
			Idea idea = ideaService.getIdea(ideaId);
			ideaList.add(idea);
		}
		return ideaList;
	}

	@RequestMapping(value = "/updateIdeaById", method = RequestMethod.GET)
	public void updateIdea(Integer ideaId, Integer stateId) {
		ideaService.updateIdea(ideaId, stateId);
	}

	@RequestMapping(value = "/delIdea", method = RequestMethod.GET)
	public String delIdea(Integer ideaId) {
		return ideaService.delIdea(ideaId);
	}
	
	@RequestMapping(value = "/saveIdea", method = RequestMethod.GET)
	public int saveIdea(String content, String eamil, HttpSession se) {
		int count = ideaService.saveIdea(content, eamil, se);
		System.out.println("结果是:"+count);
		if (count > 0) {
			return 1;
		} else
			return 0;
	}

}
