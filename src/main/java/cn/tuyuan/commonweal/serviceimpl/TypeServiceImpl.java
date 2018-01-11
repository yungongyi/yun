package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.TypeDao;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.TypeService;

@Service("typeService")
public class TypeServiceImpl  implements TypeService {

	@Resource
	TypeDao typeDao;
	
	/**
	 * 根据tableId查询所有
	 */
	@Override
	public List<Type> getTypeByTableId(int id) {
		return typeDao.getTypeByTableId(id);
	}
	/*
	 * 根据表的id 
	 *  
	 */
	@Override
	public List<Type> findTypeByTypeId(String typeId) {
		int id=-1;
		if (typeId!=null&&!typeId.equals("")) {
			id=Integer.parseInt(typeId);
		}
		return typeDao.getTypeByTypeId(id);
	}
	/*
	 * 新增类型 
	 *  
	 */
	@Override
	public int insertType(Type type) {
		 
		try {
			  typeDao.addType(type);
			   return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
			 
	}
    
}
