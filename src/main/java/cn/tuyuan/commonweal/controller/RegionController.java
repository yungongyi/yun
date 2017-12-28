package cn.tuyuan.commonweal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/getAllRegion/{id}")
	public List<Region> getAllRegion(@PathVariable String id){
		System.out.println(id);
		return regionService.getAllRegion(id);
	}
}
