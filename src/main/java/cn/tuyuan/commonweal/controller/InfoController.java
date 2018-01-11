package cn.tuyuan.commonweal.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.tuyuan.commonweal.pojo.Info;
import cn.tuyuan.commonweal.service.InfoService;

@RestController("infoController")
@RequestMapping("/info")
public class InfoController {

	// 注入业务接口
	@Resource
	private InfoService infoService;

	// 查询所有通知信息
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public List<Info> getInfo() {
		List<Info> list = infoService.getAllInfo();
		return list;
	}

	// 根据Id查询通知信息
	@RequestMapping(value = "/getInfoById", method = RequestMethod.GET)
	public List<Info> getInfoByInfoId(
			@RequestParam(value = "id", required = false) Integer id) {
		List<Info> infoList = null;
		// 判断id是否为空
		if (id == null) {
			// id为空 查询全部信息
			infoList = (List<Info>) infoService.getAllInfo();
		} else {
			// id不为空 根据id查询信息
			infoList = new ArrayList<Info>();
			Info info = infoService.getInfo(id);
			infoList.add(info);
		}
		return infoList;
	}

	// 添加通知信息
	@RequestMapping(value = "/addInfo", method = RequestMethod.GET)
	public String addInfo(@RequestParam(value = "content") String content) {
		List<Info> list = infoService.getAllInfo();
		for(Info i : list){
			if(i.getInfoContent().equals(content)){
				//表示有数据重复
				return "error";
			}
		}
		infoService.saveInfo(content);
		return "success";
	}

	// 删除通知信息
	@RequestMapping(value = "/delInfo", method = RequestMethod.GET)
	public String delInfo(@RequestParam(value = "id") Integer id) {
		return infoService.delInfo(id);
	}

}
