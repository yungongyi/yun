package cn.tuyuan.commonweal.serviceimpl;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tuyuan.commonweal.dao.InfoDao;
import cn.tuyuan.commonweal.pojo.Info;
import cn.tuyuan.commonweal.service.InfoService;

/**
 * @author 景子铭
 * @version 1.0
 */

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	// 注入dao接口
	@Autowired
	private InfoDao infoDao;

	// 获取所有通知信息
	@Override
	public List<Info> getAllInfo() {
		return infoDao.getAllInfo();
	}

	// 根据通知id查询通知信息
	@Override
	public Info getInfo(Integer id) {
		return infoDao.getInfo(id);
	}

	// 添加通知信息
	@Override
	public void saveInfo(String content) {
		infoDao.saveInfo(content);
	}

	//删除通知信息
	@Override
	public void delInfo(Integer id) {
		infoDao.delInfo(id);
	}

}
