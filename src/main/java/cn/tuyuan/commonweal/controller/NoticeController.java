package cn.tuyuan.commonweal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.NoticeService;
import cn.tuyuan.commonweal.service.PersonService;
import cn.tuyuan.commonweal.service.ResourceService;
import cn.tuyuan.commonweal.util.FileUpLoad;
import cn.tuyuan.commonweal.util.FormateParse;

import cn.tuyuan.commonweal.util.SeletcNotice;

/**
 * @author 孙家伟 2017年12月28日
 *
 */
@RestController("noticeController")
@RequestMapping("/notice")
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	@Resource
	private ResourceService resourceService;
	@Resource
	private PersonService personService;
	//保存一条启事信息
	@PostMapping("/saveNotice")
	public int saveNotice(@RequestParam("noticeimg")MultipartFile noticeimg
			,@RequestParam("title") String title
			,@RequestParam("state") String stateId
			,@RequestParam("personId") String personId
			,@RequestParam("type") String typeId
			,@RequestParam("region") String regionId
			,@RequestParam("detail") String detail
			,@RequestParam("aging") String aging){

		Map<String, Object> fileUpLoad = new HashMap<String, Object>();
		//先上传资源，再保存资源 最后保存启事资源
		fileUpLoad = FileUpLoad.fileUpLoad(noticeimg, 1);
		if(fileUpLoad.get("error").equals("上传成功")){
			//如果上传成功就保存资源信息
			cn.tuyuan.commonweal.pojo.Resource resource = new cn.tuyuan.commonweal.pojo.Resource();
			resource.setResourcePath(fileUpLoad.get("newName").toString());
			Type t =new Type();
			t.setTypeId(12);
			resource.setType(t);
			State s = new State();
			s.setStateId(24);
			resource.setState(s);
			//保存资源
			boolean issave = resourceService.save(resource);
			//如果资源表中记录成功保存启事信息
			if(issave){
				System.out.println("文件记录成功！");
				//执行新增启事操作
				Notice n = new Notice();
				n.setPersonId(Integer.parseInt(personId));
				n.setNoticeTittle(title);
				Region region = new Region();
				region.setRegionId(Integer.parseInt(regionId));
				n.setRegion(region);
				n.setResource(resource);
				Type tt= new Type();
				tt.setTypeId(Integer.parseInt(typeId));
				n.setType(tt);
				State ss = new State();
				ss.setStateId( Integer.parseInt(stateId));
				n.setState(ss);
				n.setNoticeAging(Integer.parseInt(aging));
				System.out.println(detail);
				n.setNoticeDetail(detail);
				n.setNoticeCreateDate(new Date()); 
				int count = noticeService.saveNotice(n);
				return count;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	// 分页查询所有启事
	@GetMapping("/getAllNotice")
	public List<Notice> getAllNotice(@RequestParam(value = "stateId", required = false) String stateId,
			@RequestParam(value = "date", required = false) String date) {
		List<Notice> list = new ArrayList<Notice>();

		try {		
			list = noticeService.getAllNotice(
					FormateParse.parseInt(stateId),date);
			System.out.println("ad发 阿萨德"+list.get(0).getNoticeCreateDate());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	//1.无条件查询所有启事(请勿修改)
	@GetMapping("getNoticeBySelect")
	public List<Notice> getNoticeBySelect(String regionId,String typeId,String stateId,String word){
		int r = 0,t=0,s=0;
		if(regionId!=null&&regionId!=""){
			r=Integer.parseInt(regionId);
		}
		if(typeId!=null&&typeId!=""){
			t=Integer.parseInt(typeId);
		}
		if(stateId!=null&&stateId!=""){
			s=Integer.parseInt(stateId);
		}
		List<Notice> li=noticeService.getNotice();
		for(Notice n:li){
			System.out.println(n.getState().getStateName());
			System.err.print(n.getPersonId());
			System.err.print(n.getRegion().getRegionName());
			System.err.print(n.getResource().getResourcePath());
		}
		System.out.println("这是条件"+r+"-"+t+"-"+s+"-"+word);
		return SeletcNotice.getNoticeByTiaoJian(li,r, t, s, word);

	}



	// 根据Id删除
	@GetMapping("/delNoticeById")
	public void delNoticeById(@RequestParam(value = "id") Integer id) {
		noticeService.delNotice(id);
	}

	/**
	 * 查看启事信息
	 * @param id
	 * @return
	 */
	//根据启示id查询某条启示的详细信息
	@PostMapping(value="/allnoticebyId/{noticeid}")
	public Map<Object,Object> getNoticeById(@PathVariable("noticeid") String noticeId){
		Notice notice = noticeService.getNoticeByid(Integer.parseInt(noticeId));
		Person person = personService.getpersonbyId(notice.getPersonId());
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("notice", notice);
		map.put("person",person);
		return map;
	}

	/**
	 * 查看启事信息
	 * @param id
	 * @return
	 */
	@GetMapping("/getNoticeBypId")
	public Notice getNoticeBypId(
			@RequestParam(value = "id", required = true) String id) {
		try {
			System.out.println(id);	
			Notice n = noticeService.getNoticeByid(Integer.parseInt(id));
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}