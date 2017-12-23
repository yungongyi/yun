package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.ProvinceDao;
import cn.tuyuan.commonweal.pojo.Province;
import cn.tuyuan.commonweal.service.ProvinceService;

@Service("ProvinceService")
public class ProvinceServiceImpl implements ProvinceService{
	
	//注入ProvinceDao接口
	@Autowired
	private ProvinceDao provinceDao;

	/**
	 * 查看所有省份
	 */
	@Override
	public List<Province> getProvince() {
	    return provinceDao.getProvince();
	}

	/**
	 * 添加省份
	 */
	@Override
	public int addProvince(Province province) {
		return provinceDao.addProvince(province);
	}

}
