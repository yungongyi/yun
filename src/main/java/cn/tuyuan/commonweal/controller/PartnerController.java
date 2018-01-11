package cn.tuyuan.commonweal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tuyuan.commonweal.pojo.Partner;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.service.PartnerService;
import cn.tuyuan.commonweal.util.FileUpLoad;

/**
 * 
 * @author 高俊东 后台
 *
 */

@RestController("partnerController")
@RequestMapping("/partner")
public class PartnerController {

	@javax.annotation.Resource
	private PartnerService partnerService;
	/**
	 * 查询所有
	 */
	@RequestMapping(value = "/getPartner", method = RequestMethod.GET)
	public List<Partner> getPartner() { 
		System.out.println("阿萨德");
		List<Partner> p = partnerService.getPartner();
		return p;

	}
	/**
	 * 查询单个
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getPartnerByName", method = RequestMethod.GET)
	public List<Partner> getPartnerByName(
			@RequestParam(value = "name", required = false) String name) {
		// 判断name是否为空
		if (name == null || name == "") {
			// name为空 查询全部信息
			System.out.println("阿zxc德");
			List<Partner> PartnerList = partnerService.getPartner();
			return PartnerList;
		} else {
			// name不为空 根据name查询信息
			System.out.println("阿asd德" + name);
			List<Partner> p = partnerService.getPartnerByName(name);
			p.get(0).getResource();
			return p;
		}
	}

	/**
	 * 添加合作对象
	 */
	@RequestMapping(value = "/addPartner", method = RequestMethod.POST)
	public void addPartner(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam("file0") MultipartFile file,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "mark", required = false) String mark) {
		try {
			Map<String, Object> fileMap = FileUpLoad.fileUpLoad(file, 1);
			String imgname = (String) fileMap.get("newName");
			Partner p = new Partner();
			p.setPartnerName(name); // 1
			p.setPartnerStartDate(new Date()); // 2
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date a = sdf.parse(date);
			System.err.println(a);
			p.setPartnerEndDate(a); // 3
			p.setPartnerMark(mark);
			Resource r = new Resource();
			r.setResourcePath(imgname);			
			p.setResource(r); // 4
			State s = new State();
			System.out.println(state);
			s.setStateId(Integer.parseInt(state)); // 6
			p.setState(s);
			partnerService.addPartner(p);	
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除合作对象
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/delPartner", method = RequestMethod.GET)
	public void delPartner(@RequestParam(value = "id") Integer id) {
		System.err.println("d大大说的啊" + id);
		partnerService.delPartner(id);
	}
	/**
	 * personCenterController
	 * 前台
	 * 
	 */
	/**
	 * 根据合作ID查询合作对象 
	 */
	@GetMapping("/getPartnerById")
	public List<Partner> getPartnerById(@RequestParam(value = "id", required = false) String id){
		try{
			List<Partner> p = partnerService.getPartnerById(Integer.parseInt(id));
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
}
