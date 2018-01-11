package cn.tuyuan.commonweal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.tuyuan.commonweal.pojo.Partner;
import cn.tuyuan.commonweal.pojo.Resource;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.ResourceService;
import cn.tuyuan.commonweal.service.TypeService;
import cn.tuyuan.commonweal.util.FileUpLoad;

/**
 * @describe 资源管理
 * @author 陈嘉伟
 *
 */
@RestController("resourceController")
@RequestMapping("/resource")
public class ResourceController {

	@javax.annotation.Resource
	private ResourceService resourceService;
	@javax.annotation.Resource
	private TypeService typeService;

	/*
	 * @GetMapping("/") public ModelAndView enter(){ return new
	 * ModelAndView("resourceManage"); }
	 */
	// 1.查询所有资源
	@GetMapping("/findResource")
	public List<Resource> findResource(
			@RequestParam(required = false, value = "id") String id) {

		// 判断id是否为空
		if (id == null || id == "") {
			// id为空 查询全部信息
			List<Resource> Resource = resourceService.findResourceList();
					return Resource;
		} else {
			// id不为空 根据id查询信息
			List<Resource> Resource = resourceService.getResourceByresourceId(Integer.parseInt(id));
			return Resource;
		}
	}

	// 2.新增资源
	@PostMapping("/addResource")
	public Resource addResource(HttpServletRequest request,
			@RequestParam("file0") MultipartFile file, String type) {
		System.out.println(type);
		// *//**
		// * FileUpLoad.fileUpLoad(file, type);
		// * type=1是图片
		// *//*
		Map<String, Object> fileMap = FileUpLoad.fileUpLoad(file, 1);
		System.out.println(fileMap.get("typeError"));
		System.out.println(fileMap.get("sizeError"));
		System.out.println(fileMap.get("copyError"));
		String name = (String) fileMap.get("newName");
		// 保存导数据库
		Resource re = new Resource();
		try {

			System.out.println(name);
			re.setResourcePath(name);
			re.getType().setTypeId(Integer.parseInt(type));
			re = resourceService.saveResource(re);
			System.out
			.println(re.getResourcePath() + re.getResourceId() + type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	// 3.获取资源类型
	@GetMapping("/getResourceType")
	public List<Type> getResourceType() {
		// 资源表ID
		return typeService.getTypeByTableId(11);
	}

	// @GetMapping("/getResourceById")
	// public Resource getResourceByID(String id){
	// List<Resource> li=resourceService.findResourceList(0,0);
	// for(Resource l:li){
	// if(l.getResourceId()==Integer.parseInt(id)){
	// return l;
	// }
	// }
	// return null;
	// }
}
