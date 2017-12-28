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
	
	@Override
	public List<Type> getTypeByTableId(int id) {
		return typeDao.getTypeByTableId(id);
	}

}
