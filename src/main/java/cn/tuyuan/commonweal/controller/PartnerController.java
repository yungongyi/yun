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
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.PartnerService;
import cn.tuyuan.commonweal.service.ResourceService;
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
	@javax.annotation.Resource
	private ResourceService resourceService;
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
	public int addPartner(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "file0", required = false) MultipartFile partnerimg,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "mark", required = false) String mark) {
		//先上传文件 （成功往下继续执行  失败  返回 弹出错误信息）
		//其次把该文件信息插入资源表（如果上传成功）
		//最后保存合作信息（如果插入资源表成功）
		int count =0;
		Map<String, Object> upload = FileUpLoad.fileUpLoad(partnerimg, 1);
		System.out.println(upload.get("error"));
		if(upload.get("error").equals("上传成功")){
			Resource r = new Resource();
			System.out.println(upload.get("newName"));
			r.setResourcePath(upload.get("newName").toString());
			Type t =new Type();
			t.setTypeId(12);
			r.setType(t);
			State s = new State();
			s.setStateId(23);
			r.setState(s); 
			boolean save = resourceService.save(r);
			System.out.println("是否保存资源？"+save);
			//如果资源保存成功就添加一条合作信息
			if(save){
				Partner p = new Partner();
				State s2 = new State();
				s2.setStateId(Integer.parseInt(state));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			  System.out.println(date);
				p.setPartnerMark(mark);
				p.setState(s2);
				p.setPartnerStartDate(new Date());
				p.setPartnerName(name);
				p.setResource(r);
				try { 
					Date dates = format.parse(date); 
					 p.setPartnerEndDate(dates);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				count = partnerService.addPartner(p);
			}
		}
		return count;
	}
	/**
	 * 删除合作对象
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/delPartner", method = RequestMethod.GET)
	public void delPartner(@RequestParam(value = "id") Integer id) {
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
