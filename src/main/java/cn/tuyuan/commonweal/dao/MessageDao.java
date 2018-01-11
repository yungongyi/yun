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
	 * @param personName 姓名
	 * @return Message
	 */
	Message getMessage(Integer personId);

	/**
	 * @describe 删除消息信息
	 * @param id
	 *            消息id
	 */
	String delMessage(Integer messageId);
	
	List<Message> getAllMessageByPersonId(Integer personId);
	
	 /*/ @param personId
	 * @param messageId
	 * @return 影响行数
	 * 删除指定的信息
	 */
	int  deleteMessagebyPersonId(Integer personId ,Integer messageId);
	
	int  insertMessage(Message message);

}
