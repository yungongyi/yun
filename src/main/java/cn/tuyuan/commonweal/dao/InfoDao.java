package cn.tuyuan.commonweal.dao;

import java.util.List;
import cn.tuyuan.commonweal.pojo.Info;

/**
 * 
 * @author 景子铭
 * @version 1.0
 */

public interface InfoDao {

	/**
	 * @describe 查询所有通知信息
	 * @return all info
	 */
	List<Info> getAllInfo();

	/**
	 * @describe 根据通知Id查询通知信息
	 * @param 通知Id
	 * @return info
	 */
	Info getInfo(Integer id);

	/**
	 * @describe 添加通知信息
	 * @param String
	 *            content 通知内容
	 */
	void saveInfo(String content);

	/**
	 * @describe 删除通知信息
	 * @param id
	 *            通知id
	 */
	void delInfo(Integer id);

}
