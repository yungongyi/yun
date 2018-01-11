package cn.tuyuan.commonweal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.Notice;

import cn.tuyuan.commonweal.service.NoticeService;

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
	@GetMapping("/getNoticeBypId")
	public List<Notice> getNoticeBypId(
			@RequestParam(value = "id", required = false) String id) {
		try {
			List<Notice> n = noticeService.getNoticeById(Integer.parseInt(id));
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}