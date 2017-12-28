package cn.tuyuan.commonweal.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.pojo.Message;

/**
 * @author 景子铭
 * @version 1.0
 */

@Transactional
public interface MessageService {

	/**
	 * @describe 查询所有通知信息
	 * @return all info
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
