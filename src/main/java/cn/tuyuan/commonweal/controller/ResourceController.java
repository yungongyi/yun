package cn.tuyuan.commonweal.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	/**
	 * 资源查询
	 */
	@GetMapping("/getResource")
	@ResponseBody
	public Map<String,Object> getResource(){		
		List<cn.tuyuan.commonweal.pojo.Resource> list =  resourceService.getResourceBytypeId(".txt");
		FileReader fr=null;
		FileReader fr1=null;
		FileReader fr2=null;
		BufferedReader br=null;
		BufferedReader br1=null;
		BufferedReader br2=null;
		try{
			//创 建二个FileReader对象
			fr = new FileReader(list.get(0).getResourcePath());
			fr1 = new FileReader(list.get(1).getResourcePath());
			fr2 = new FileReader(list.get(2).getResourcePath());
			//创建二个BufferedReader对象
			br = new BufferedReader(fr);
			br1 = new BufferedReader(fr1);
			br2 = new BufferedReader(fr2);
			//读取一行数据
			String line1 =br.readLine();
			String txt="";
			String line2=br1.readLine();
			String txt1="";
			String line3=br2.readLine();
			String txt2="";
			//读取所有内容			
			while(line1!=null){		
				txt+=line1;
				line1=br.readLine();	
				
			}
			while(line2!=null){		
				txt1+=line2;
				line2=br1.readLine();			
			}
			while(line3!=null){		
				txt2+=line3;
				line3=br2.readLine();			
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("diushi",txt);
			map.put("zhapian",txt1);
			map.put("shiyaosu",txt2);		
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
				if(fr!=null)
					fr.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(br1!=null)
					br1.close();
				if(fr1!=null)
					fr1.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(br2!=null)
					br2.close();
				if(fr2!=null)
					fr2.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;			
	}
}
