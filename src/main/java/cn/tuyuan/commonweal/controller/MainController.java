package cn.tuyuan.commonweal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.tuyuan.commonweal.service.NoticeService; 
import cn.tuyuan.commonweal.pojo.Notice;

/**
 * @author 孙家伟
 * 2018年1月3日
 * 主页面controller
 */
@RequestMapping("/main")
@RestController("mainController")
public class MainController {

	@Resource
	private NoticeService NoticeService;

	//获取主页面启示信息
	@GetMapping("/getmainnotice")
	public List<Notice> getmainnotice(HttpSession session){
		/* session.setAttribute("SESSION_USERNAME", "a");*/
		List<Notice> notices = NoticeService.getmainNotice();
		for (Notice notice : notices) {
			System.out.println(notice.getResource().getResourcePath());
		} 
		return notices;
	}

	//全局搜索
	@GetMapping("/searchallofnotice/{Content}")
	public List<Notice>  searchallofnotice(@PathVariable String Content,HttpServletRequest request){
		List<Notice> notices = NoticeService.searchAllOfNotice(Content);
		return notices;
	}
}
