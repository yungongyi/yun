package cn.tuyuan.commonweal.controller;

import static org.hamcrest.CoreMatchers.allOf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.annotation.Resource;

import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.ResourceService;
import cn.tuyuan.commonweal.service.TypeService;

/**
 * 
 * @author 刘亚杰
 *
 */
@RestController
@RequestMapping("/type")
public class TypeController {
	@ Resource
	private TypeService typeService;
	
	//查询所有类型(无条件)
	@GetMapping("/getType/{tableId}")
	public List<Type> getType(@PathVariable String tableId){
		List<Type> li=typeService.getTypeByTableId(Integer.parseInt(tableId));
		for(Type s:li){
			System.out.println("类型");
			System.out.println(s.getTypeId());
		}
		return typeService.getTypeByTableId(Integer.parseInt(tableId));
	}
	//后台类型显示
	@GetMapping("/viewType.html")
	public String view(Map<String,Object> map){
		List<Type> list= typeService.getTypeByTableId(-1);
		map.put("list", list);
		return JSONArray.toJSONString(list);
	}
	/*
	 * 新增类型
	 */
	@GetMapping("/addType/{typeName}/{tableId}")
	public int addType(@PathVariable("typeName") String typeName,@PathVariable("tableId") String tableId){
		Type type=new Type();
		type.setTypeName(typeName); 
		type.setTableId(Integer.parseInt(tableId));
		int count= typeService.insertType(type);
		return count;
	}
}
