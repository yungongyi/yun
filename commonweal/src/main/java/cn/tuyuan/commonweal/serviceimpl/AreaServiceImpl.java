package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.AreaDao;
import cn.tuyuan.commonweal.pojo.TbArea;
import cn.tuyuan.commonweal.service.AreaService;

@Service("AreaService")
public class AreaServiceImpl implements AreaService {

	//注入AreaDao接口
	@Autowired
	private AreaDao areaDao ;
	
	/**
	 * 查询所有区、县
	 */
	@Override
	public List<TbArea> getArea() {
		return areaDao.getArea();
	}

	/**
	 * 添加区、县
	 */
	@Override
	public int addArea(TbArea area) {
		return areaDao.addArea(area);
	}

}
