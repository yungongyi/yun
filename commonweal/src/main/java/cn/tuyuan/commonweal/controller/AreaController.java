package cn.tuyuan.commonweal.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.City;
import cn.tuyuan.commonweal.pojo.Province;
import cn.tuyuan.commonweal.pojo.TbArea;
import cn.tuyuan.commonweal.service.AreaService;
import cn.tuyuan.commonweal.service.CityService;
import cn.tuyuan.commonweal.service.ProvinceService;

/**
 * 
 * @author 高俊东
 * 地域管理
 */
@Controller
@RequestMapping("/Province")
public class AreaController {
	
	//注入省份Service
	@Resource
	public ProvinceService provinceService;
	//注入城市Service
	@Resource
	public CityService cityService;
	//注入区县Service
	@Resource
	public AreaService areaService;
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	//查看所有省份、城市、区县
	@RequestMapping(value="/provincelist", method=RequestMethod.GET)
	public String getProvince(Map<String, Object> map){
		//添加省份到map
		List<Province> p= provinceService.getProvince();
		map.put("Provincelist", p);
		//添加城市到map
		List<City> c=cityService.getCity();
		map.put("Citylist", c);
		//添加区县到map
		List<TbArea> a=areaService.getArea();
		map.put("Arealist", a);
		return "index";
		
	}
	
	//添加省份、城市、区县
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String addprovince(Province province){
		province=new Province();
		province.setProvinceName("河北");
		provinceService.addProvince(province);
		return "Province/rovincelist";
	}

}
