package cn.tuyuan.commonweal.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
/*
 * 1.文件大小不能超过size
 * 2.
 */
public class FileUpLoad {
	static HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	//1.储存返回值
	public static Map<String,Object> map;
	//2.图片类型 type=1
	public static String [] imgType={"jpg","jpeg","png","pneg"};
	//3.文档类型 type=2
	public static String [] textType={"text","word","log"};
	//4.音频类型 type=3
	public static String [] voiceType={"mp3","flv","wav"};
	//5.文件大小
	public static Integer fileSize=1024000;
	//6.项目路径
	public static String sourcePath="";
	//7.磁盘路径(以后再用)
	public static String realPath="D:\\apache-tomcat-7.0.82-windows-x64\\apache-tomcat-7.0.82\\Localsource";
	
 	String errorSize="文件大小不得超过"+fileSize;
	
	public static Map<String,Object> fileUpLoad(MultipartFile file,int type){
		
		map=new HashMap<String,Object>();
		//1.获取文件名字
		String oldFileName=file.getOriginalFilename();
		//2.获取文件后缀
		String fileSuffix=FilenameUtils.getExtension(oldFileName);
		//3.判断文件格式
		String [] types =imgType;
		if(type==1){
			types=imgType;
			sourcePath="upload/image";
		}else if(type==2){
			types=textType;
			sourcePath="upload/text";
		}else if(type==3){
			types=voiceType;
			sourcePath="upload/voice";
		}else{
			map.put("typeError", "未选择类型");
			return map;
		}
		if(checkSuffix(fileSuffix,types)==true){
			map.put("typeError",true);
		}else{
			map.put("typeError", "文件类型错误");
			return map;
		}
		//4.判断文件大小
		if(file.getSize()>fileSize){				
			map.put("sizeError", "文件太大");
			return map;
		}else{
			map.put("sizeError", true);
		}
		//5.文件重命名
		String newName=System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"."+fileSuffix;
		//6.执行文件复制操作
		String path=request.getSession().getServletContext().getRealPath("static")+File.separator+sourcePath;		
		File tempFlie=new File(path,newName);
		if(!tempFlie.exists()){
			tempFlie.mkdirs();
		}
		try {
			file.transferTo(tempFlie);
		} catch (Exception e) {
			map.put("copyError", "文件复制失败");
			e.printStackTrace();
			return 	map;		
		}
		map.put("realPath", path+File.separator+newName);
		map.put("copyError", true);
		String p= Constants.SOURCEPATH+"commonweal/"+sourcePath+"/"+newName;
		map.put("newName", newName);	
		return map;
	}
	//文件格式判断
	public static boolean checkSuffix(String fileSuffix,String[] types){
		for(String t:types){
			if(fileSuffix.equalsIgnoreCase(t)){
				return true;
			}
		}
		return false;
	}
	
	
	//根据文件路径 获取文件名
	/*public static String getFileNameByPath(String str){
		String name=str.substring(str.lastIndexOf("\\")+1, str.length());
		return name;
	}*/
	/*//删除文件
	public static boolean delFile(String oldPath){
		if(oldPath!=null){
			String fileName=getFileNameByPath(oldPath);
			String filePath=ControllerPath;
			File file=new File(filePath,fileName);
			if(file.exists()){
				file.delete();
				return true;
			}
		}		
		return false;
	}
	
	
	public static String[] getImgType() {
		return imgType;
	}

	public static void setImgType(String[] imgType) {
		FileUpLoad.imgType = imgType;
	}
*/
}
