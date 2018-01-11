package cn.tuyuan.commonweal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Resource
	private RegionService regionService;

	@GetMapping("/")
	public ModelAndView enterRegion(){
		return new ModelAndView("region");
	}

	//1.根据parentId获取区域
	//根据区域父id获取区域列表
		@GetMapping("/getAllRegion/{parentid}")
		public List<Region> getAllRegion(@PathVariable String parentid){ 
			return regionService.getAllRegion(parentid);
		}

	//1.根据parentId获取区域
	@GetMapping("/getRegionByParentId")
	public List<Region> getRegionByParentId(String pageNo,String id){
		return regionService.getRegionByParentId(Integer.parseInt(pageNo),8,Integer.parseInt(id));
	}
	//2.根据regionId获取区域
	@GetMapping("/getRegionByRegionId/{regionId}")
	public Region getRegionByRegionId(@PathVariable String regionId){
		System.out.println(regionId);
		Region r= regionService.getRegionByRegionId(Integer.parseInt(regionId));
		System.out.println(r.getParentId());
		return r;
	}
	//3新增
	@PostMapping("/addRegion")
	public Region addRegion(String parentId,String regionName,String level,String simpleEN,String regionCode){
		System.out.println(parentId);
		System.out.println(regionName);
		System.out.println(level);
		System.out.println(simpleEN);
		System.out.println(regionCode);
		Region r=new Region();
		try {

			r.setRegionCode(regionCode);
			r.setRegionName(regionName);
			r.setParentId(Integer.parseInt(parentId));
			r.setRegionLevel(Integer.parseInt(level));
			r.setRegionShortnameEn(simpleEN);
			System.out.println("nih");
		} catch (Exception e) {
			e.printStackTrace();
		}
		r=regionService.saveRegion(r);
		return r;
	}
	@GetMapping("/delRegionById")
	public boolean delRegionById(String id){
		return regionService.delRegionById(Integer.parseInt(id));
	}
}
