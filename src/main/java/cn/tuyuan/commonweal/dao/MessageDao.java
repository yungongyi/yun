package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Message;

/**
 * @author 景子铭
 * @version 1.0
 */

public interface MessageDao {

	/**
	 * @describe 查询所有消息信息
	 * @return all Message
	 */
	List<Message> getAllMessage();

	/**
	 * @describe 查询消息信息
	 * @param personId
	 *            发送人id
	 * @return Message
	 */
	Message getMessage(Integer personId);

	/**
	 * @describe 删除消息信息
	 * @param id
	 *            消息id
	 */
	void delMessage(Integer messageId);

}
