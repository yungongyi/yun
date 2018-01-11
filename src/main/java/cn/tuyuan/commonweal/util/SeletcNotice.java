package cn.tuyuan.commonweal.util;

import java.util.ArrayList;
import java.util.List;

import cn.tuyuan.commonweal.pojo.Notice;

public class SeletcNotice {
	
	public static List<Notice> getNoticeByTiaoJian(List<Notice> li,int regionId,int typeId,int stateId,String word){
		

		//根据地区筛选
		List<Notice> byRegion=new ArrayList<Notice>();
		for(Notice l:li){
			if(regionId!=0){
				if(l.getRegion().getRegionId()==regionId){byRegion.add(l);}			
			}else{
				byRegion=li;
			}
		}
		System.out.println("第一次筛选结果"+byRegion.size());
		//根据类型筛选
		List<Notice> byType=new ArrayList<Notice>();
		for(Notice l:byRegion){
			if(typeId!=0){
				System.out.println(l.getType().getTypeId());
				if(l.getType().getTypeId()==typeId){byType.add(l);}			
			}else{
				byType=byRegion;
			}
		}
		System.out.println("第二次筛选结果"+byType.size());
		//根据状态筛选
		List<Notice> byState=new ArrayList<Notice>();
		for(Notice l:byType){
			if(stateId!=0){
				if(l.getState().getStateId()==stateId){byState.add(l);}			
			}else{
				byState=byType;
			}
		}
		System.out.println("第三次筛选结果"+byState.size());
		//根据关键字筛选
		List<Notice> byWord=new ArrayList<Notice>();
		for(Notice l:byState){
			if(word!=null&&!word.equalsIgnoreCase("")){		
				if(l.getRegion().getRegionName().indexOf(word)>=0 ||l.getNoticeTittle().indexOf(word)>=0 || l.getNoticeDetail().indexOf(word)>=0){
					byWord.add(l);
				}			
			}else{
				byWord=byState;
			}
		}
		System.out.println("第四次筛选结果"+byWord.size());
		return byWord;
	}
/*	public List<Notice> gg(List<Notice> ll,int id,String type){
		List<Notice> li=new ArrayList<Notice>();//from db
		for(Notice l:li){
			if(type.equals("region")){
				if(id!=0 && l.getRegion().getRegionId()==id){
					li.add(l);	
				}else{
					return li;
				}
			}
			if(type.equals("type")){
				if(id!=0 && l.getType().getTypeId()==id){
					li.add(l);	
				}else{
					return li;
				}
			}
			if(type.equals("state")){
				if(id!=0 && l.getState().getStateId()==id){
					li.add(l);
				}else{
					return li;
				}			
			}
		}
		return li;		
	}*/
}
