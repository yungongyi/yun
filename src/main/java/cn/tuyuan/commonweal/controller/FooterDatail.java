package cn.tuyuan.commonweal.controller;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.tuyuan.commonweal.pojo.Idea;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.service.IdeaService;

@Controller
@RequestMapping("/foot")
public class FooterDatail {
	@Resource
	private IdeaService ideaService;
	
	
	@RequestMapping("/idea.html")
	@ResponseBody
	public String  getFoot(@RequestParam String personEmail,
			@RequestParam String ideaContent,Map<String, Object> map){
		System.out.println(ideaContent);
		//获取当前时间
		Date date=new Date();
	Idea idea=new Idea();
	       
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ideaCreateDate=sf.format(date);
		Timestamp timestamp=Timestamp.valueOf(ideaCreateDate);
		idea.setIdeaContent(ideaContent);
		idea.setPersonEmail(personEmail);
		idea.setIdeaCreateDate(timestamp);
		 
        State state =new State();
        state.setStateId(1);
        state.setStateName("已查看");
        state.setTableId(3);
		 
		//因為是剛提交，所以此處0代表未處理
		idea.setState(state);
		boolean flag= ideaService.insertIdea(idea);
		String f=null;
		if (flag) {
		   f="true";
		}
		else{
			f="false";
		}
		map.put("flag", f);
		return JSONArray.toJSONString(map);
	}

}
