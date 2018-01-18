package cn.tuyuan.commonweal.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.tuyuan.commonweal.pojo.Message;
import cn.tuyuan.commonweal.pojo.Notice;
import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.pojo.Region;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.MessageService;
import cn.tuyuan.commonweal.service.NoticeService;
import cn.tuyuan.commonweal.service.PersonService;
import cn.tuyuan.commonweal.service.RegionService;
import cn.tuyuan.commonweal.service.ResourceService;
import cn.tuyuan.commonweal.service.TypeService;
import cn.tuyuan.commonweal.util.Constants;
import cn.tuyuan.commonweal.util.FileUpLoad;
import cn.tuyuan.commonweal.util.HttpSessionManager;
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

	@Resource
	private ResourceService resourceService;
	@Resource
	private TypeService typeService;

	/*1.进入个人中心页面*/
	//2.获取基本个人信息(使用 ajax异步)
	@PostMapping("/getPersonById/{personId}")
	public Person getPersonById(@PathVariable String personId){
		return personService.getpersonbyId(Integer.parseInt(personId));
	}
	//3.获取启事通过id (使用 ajax异步)
	@PostMapping("/getAllNoticeById/{personId}")
	public List<Notice> getAllNoticeByPersonId(@PathVariable("personId")String personId){
		List<Notice> notice = noticeService.getAllNoticeByPersonId(Integer.parseInt(personId));
		return notice;
	}
	/*4.获取消息通过id (使用 ajax异步)  */
	@PostMapping("/getAllMessageById/{personId}")
	public Map<Object,Object> getAllMessageByPersonId(@PathVariable("personId")String personId){
		List<Message> messages = messageService.getAllMessageByPersonId(Integer.parseInt(personId));
		List<Person> receivers = new ArrayList<Person>();
		if(messages!=null){
			for (Message message : messages) {
				//获取每条信息中的发送者
				Integer senderid = message.getPersonId();
				Person sender = personService.getpersonbyId(senderid);
				receivers.add(sender);
			}	
			Map<Object,Object> messagemap = new HashMap<Object,Object>();
			messagemap.put("messages",messages);
			messagemap.put("receivers", receivers);
			return messagemap;
		}
		return null;

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
			,@RequestParam("personId") String personId,HttpSession session){
		boolean isupdate = personService.updatePersonPassword(Integer.parseInt(personId), newPassword);
		if(isupdate){
			//如果修改成功就删除session信息 
			session.removeAttribute("userId");
		}
		return isupdate;		
	}

	//7.修改头像(使用 formData ajax同步)文件上传
	@RequestMapping(value="/updateHeadImg",method=RequestMethod.POST)
	public Map<String, Object> updateHeadImg(@RequestParam(value = "headimg")MultipartFile headimg,HttpServletRequest request){
		Map<String, Object> fileUpLoad = new HashMap<String, Object>();
		//根据用户id为1的用户对象
		Person p = personService.getpersonbyId(1);
		String ImgStateName = p.getResource().getState().getStateName();
		System.out.println("资源状态："+ImgStateName);
		System.out.println("文件名称"+headimg.getOriginalFilename());
		//执行上传操作
		fileUpLoad = FileUpLoad.fileUpLoad(headimg, 1);
		System.out.println(fileUpLoad.get("error"));
		if(fileUpLoad.get("error").equals("上传成功")){
			//如果是默认头像则添加一个资源作为用户头像、如果不是默认头像则替换该资源路径并且删除老照片
			if(ImgStateName.equals("默认")){    
				//设置为新图片
				cn.tuyuan.commonweal.pojo.Resource resource = new cn.tuyuan.commonweal.pojo.Resource();
				resource.setResourcePath(fileUpLoad.get("newName").toString());
				//状态
				State s = new State();
				s.setStateId(24);
				resource.setState(s); 
				//类型
				Type t = new Type();
				t.setTypeId(11);					
				resource.setType(t);
				//保存该资源
				boolean issave = resourceService.save(resource);
				if(issave){//如果数据库中添加成功
					//修改用户的头像id
					p.setResource(resource); 
					boolean isupdate = personService.updatePerson(p);
					if(isupdate){
					}else{
						return null;
					}
				}else{
					return null;
				}
			}else{
				//如果用户之前的头像不是默认的。就直接修改该资源
				//获取该资源id
				Integer resourceId = p.getResource().getResourceId();
				int count = resourceService.updateResource(fileUpLoad.get("newName").toString(),resourceId);
				if(count>0){
				}else{
					return null;
				}
			}
		}else{
			System.out.println("出错！");
		}
		return fileUpLoad;
	}
	/*	//删除图片
	public boolean deleteFile(String path) {
		try {
			File file = new File(path);
			if (!file.isDirectory()) {  //如果path是一个具体的文件绝对路径
				file.delete();
			} else if (file.isDirectory()) { //如果path是一个文件夹
				String[] filelist = file.list(); //查找该文件夹下的文件或文件夹数组
				for (int i = 0; i < filelist.length; i++) { //循环遍历该数组
					File filessFile = new File(path + "\\" + filelist[i]);
					if (!filessFile.isDirectory()) { 
						filessFile.delete();
					} else if (filessFile.isDirectory()) {
						deleteFile(path + "//" + filelist[i]);
					}
				}
				file.delete();
			}
			return true;
		} catch (Exception e) { 
			e.printStackTrace();
			return false;
		}
	}*/
	//8.修改其他个人信息
	@PostMapping("/updatePersonInfo")
	public boolean updatePersonInfo(
			@RequestParam(value="name",required=false)String name,
			@RequestParam(value="sex",required=false)String sex,
			@RequestParam(value="iphone",required=false)String iphone,
			@RequestParam(value="addressID",required=false)String addressId){
		Person p=new Person();
		p.setPersonid(1);
		if(iphone!=null && !iphone.equals("") ){
			p.setIphone(iphone);
		}
		if(name!=null && !name.equals("") ){
			p.setName(name);

		}
		System.out.println(addressId);
		if(addressId!=null && !addressId.equals("")){
			Region r= new Region();
			r.setRegionId(Integer.parseInt(addressId));
			p.setRegion(r);
		}	
		if(sex!=null && !sex.equals("")){
			p.setSex(Integer.parseInt(sex));
		}
		return personService.updatePerson(p);
	}
	//10.删除消息
	@GetMapping("/deleteMessage")
	public  boolean  deleteMessage(@RequestParam("personId")String personId,@RequestParam("messageId")String messageId){
		return messageService.deleteMessageByPersonId(Integer.parseInt(messageId),Integer.parseInt(personId));
	}
	//11.删除启事
	@GetMapping("/deleteNotice/{personId}/{noticeId}")
	public  boolean  deleteNotice(@PathVariable("personId")String personId,@PathVariable("noticeId")String noticeId){
		return noticeService.deleteNoticeByPersonIdAndNoticeId(Integer.parseInt(personId),Integer.parseInt(noticeId));
	}
	//12.发送短消息聊天
	@GetMapping("/sendMessage")
	public boolean sendMessage(@RequestParam("personId") String sendId,@RequestParam("receicePhone") String receicePhone,
			@RequestParam("message")String message){
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
	 * 根据启事模块id查询状态列表
	 */
	@RequestMapping(value="/gettypebytableid/{tableid}")
	@ResponseBody
	public List<Type> gettypebyid(@PathVariable String tableid){
		List<Type> types = typeService.getTypeByTableId(Integer.parseInt(tableid));
		return types;
	} 
	/**
	 * 根据parentId获取区域
	 */
	@PostMapping("/getRegionByParentId/{parentId}")
	public List<Region> getRegionByParentId(@PathVariable("parentId") String id){
		if(id!=null){
			return regionService.getAllRegion(id);
		}
		return null;

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
	@GetMapping("/getPersionName")
	public String getPersonName(String personId){
		return personService.getpersonbyId(Integer.parseInt(personId)).getName();
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
	/**
	 * 修改启示状态
	 * @param id
	 * @return 用户对象
	 */
	@GetMapping("/updateNoticeBystate")
	public int updateNoticeBystate(@RequestParam(value = "noticeid", required = false) String id,
			@RequestParam(value = "stateid", required = false) String stateId){
		Notice notice = new Notice();
		notice.setNoticeId(Integer.parseInt(id));
		State s = new State();
		System.out.println(stateId);
		s.setStateId(Integer.parseInt(stateId));
		notice.setState(s);
		return noticeService.updateStateBynoticeId(notice);
	}

	//根据用户id查看用户联系方式
	@GetMapping("/getPersonInfoById/{id}")
	public Person getPersonInfoById(@PathVariable String id){
		Person p=personService.getpersonbyId(Integer.parseInt(id));
		Person per=new Person();
		per.setIphone(p.getIphone());
		per.setName(p.getName());
		return per;

	}
}
