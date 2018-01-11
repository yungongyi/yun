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
	String delMessage(Integer messageId);
	
	/**
	 * @describe 查询消息信息
	 * @param personId
	 *            发送人id
	 * @return Message
	 */
	List<Message> getAllMessageByPersonId(Integer personId);
    
	//根据用户id 消息id 删除消息信息
	boolean deleteMessageByPersonId(Integer messageId ,Integer personId);
	
	//插入一条用户信息
	 int insertMessage(Integer sendId, Integer personid, String message);

}
