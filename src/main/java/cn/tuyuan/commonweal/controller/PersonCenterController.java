package cn.tuyuan.commonweal.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.tuyuan.commonweal.pojo.Message;
import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Partner;
import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.service.MessageService;
import cn.tuyuan.commonweal.service.NoticeService;
import cn.tuyuan.commonweal.service.PersonService;
import cn.tuyuan.commonweal.service.RegionService;
import cn.tuyuan.commonweal.util.sendphone.sendsms;
/**
 * @Describe (个人中心)
 * @author 陈嘉伟
 *
 */
@RestController("personCenterController")
@RequestMapping("/personCenter")
public class PersonCenterController {

	@Resource
	private PersonService personService;

	@Resource
	private NoticeService noticeService;

	@Resource
	private  MessageService messageService;
	
	@Resource
	private  RegionService regionService;
	
	/*1.进入个人中心页面*/
	@GetMapping("/")
	public ModelAndView enterPersonCenter(HttpSession session){
		String id=(String) session.getAttribute("personSession");
		ModelAndView model=new ModelAndView("personcenter");
		model.addObject("personId", id);
		return model;
	}
	//2.获取基本个人信息(使用 ajax异步)
	@PostMapping("/getPersonById")
	public Person getPersonById(String personId){
		return personService.getpersonbyId(Integer.parseInt(personId));
	}
	//3.获取启事通过id (使用 ajax异步)
	@PostMapping("/getAllNoticeById")
	public List<Notice> getAllNoticeByPersonId(String personId){
		return noticeService.getAllNoticeByPersonId(Integer.parseInt(personId));
	}
	
	/*4.获取消息通过id (使用 ajax异步)  */
	@PostMapping("/getAllMessageById")
	public List<Message> getAllMessageByPersonId(String personId){
		return messageService.getAllMessageByPersonId(Integer.parseInt(personId));
	}

	//5.获取验证码的方法 (使用 ajax同步)
	@GetMapping("/getiphone/{iphone}")
	public int getiphone(@PathVariable String iphone){
		int yanzhengma= sendsms.getiphone(iphone);
		return yanzhengma;
	}
	//6.修改密码(使用 ajax同步 )
	@PostMapping("/updatePassword")
	public boolean updatePassword(@RequestParam("newPassword") String newPassword
	,@RequestParam("personId") String personId){
		return personService.updatePersonPassword(Integer.parseInt(personId), newPassword);		
	}
	
	//7.修改头像(使用 formData ajax同步)文件上传
	@PostMapping("/updateHeadImg")
	public String updateHeadImg(String personId){
		String headImgPath=null;
		return headImgPath;
	}
	
	//8.修改其他个人信息
	@PostMapping("/updatePersonInfo")
	public boolean updatePersonInfo(String personId,
	@RequestParam(value="name",required=false)String name,
	@RequestParam(value="sex",required=false)String sex,
	@RequestParam(value="iphone",required=false)String iphone,
	@RequestParam(value="addressID",required=false)String addressId){
		Person p=new Person();
		p.setPersonid(Integer.parseInt(personId));
		if(iphone!=null && !iphone.equals("") ){
			p.setIphone(iphone);
		}
		if(name!=null && !name.equals("") ){
			p.setName(name);

		}
		if(addressId!=null && !addressId.equals("") ){
			p.getRegion().setRegionId(Integer.parseInt(addressId));
		}	
		if(sex!=null && !sex.equals("")){
			p.setSex(Integer.parseInt(sex));
		}	
		return personService.updatePerson(p);
	}
	
	//9.加载地址
	/*@GetMapping("/getRegionById/{regionid}")
	public List<Region> getRegionById(@PathVariable String regionid ){
		return regionService.getAllRegion(regionid);
	}*/
	
	//10.删除消息
	@GetMapping("/deleteMessage")
	public  boolean  deleteMessage(String personId,String messageId){
		return messageService.deleteMessageByPersonId(Integer.parseInt(messageId),Integer.parseInt(messageId));
	}
	//11.删除启事
	@GetMapping("/deleteNotice")
	public  boolean  deleteNotice(String personId,String noticeId){
		return noticeService.deleteNoticeByPersonIdAndNoticeId(Integer.parseInt(personId),Integer.parseInt(noticeId));
	}
	//12.发送短消息聊天
	@GetMapping("/sendMessage")
	public boolean sendMessage(@RequestParam("personId") String sendId,String receicePhone,
			String message){
		//1.根据手机号查询这个人是否存在
		Person p=personService.fastLogin(receicePhone);
		//2.如果存在就发送
		if(p.getPersonid()!=null){
			messageService.insertMessage(Integer.parseInt(sendId),p.getPersonid(),message);
			return true;
		}
		return false;
		
	}
	
	/**
	 * 查询所有用户
	 */
	@GetMapping("/getPerson")
	public List<Person> getPerson(){
		try{
			return personService.getPerson();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	
	/**
	 * 根据手机号查询用户信息
	 */
	@RequestMapping(value = "/getPersonByiphone", method = RequestMethod.GET)
	public List<Person> getPersonByiphone(
			@RequestParam(value = "iphone", required = false) String iphone) {	
		// 判断name是否为空
		if (iphone == null || iphone=="") {
			// iphone为空 查询全部信息
			System.out.println("阿zxc德");
			List<Person> list= personService.getPerson();
			return list;
		} else {
			// iphone不为空 根据iphone查询信息	
			System.out.println("阿asd德"+iphone);	
			List<Person> p = personService.getPersonByiphone(iphone);
			return p;
		}

	}
	
	//根据用户id获取电话
	@RequestMapping(value="/getTelById",method = RequestMethod.GET)
	public String getTelById(Integer personId){
		return personService.getPerson(personId);
	}
	
	//根据用户id获取姓名
	@RequestMapping(value="/getPersionName",method = RequestMethod.GET)
	public String getPersonName(Integer personId){
		return personService.getpersonbyId(personId).getName();
	}
	
	/**
	 * 根据用户id查看用户信息
	 * @param id
	 * @return 用户对象
	 */
	@GetMapping("/getPersonBypersonid")
	public List<Person> getPersonBypersonid(@RequestParam(value = "id", required = false) String id){
		try{
			System.out.println("让他一人头");
			List<Person> p = personService.getPersonBypersonid(Integer.parseInt(id));
			System.out.println("不错吧"+p.get(0).getIphone());
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	/**
	 * 修改用户状态
	 * @param id
	 * @return 用户对象
	 */
	@GetMapping("/updatePersonBystate")
	public void updatePersonBystate(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "stateId", required = false) String stateId){
		try{
			int personId=0;
			int sId=0;
			if(id!=null&&!id.equals("")){
				personId=Integer.parseInt(id);
			}
			if(stateId!=null&&!stateId.equals("")){
				sId=Integer.parseInt(stateId);
			}
	        personService.updatePersonBystate(personId,sId);
		
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
