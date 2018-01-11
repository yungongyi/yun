package cn.tuyuan.commonweal.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.MessageDao;
import cn.tuyuan.commonweal.pojo.Message;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.service.MessageService;

/**
 * 
 * @author 景子铭
 * @version 1.0
 */

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> getAllMessage() {
		return messageDao.getAllMessage();
	}

	@Override
	public Message getMessage(Integer personId) {
		return messageDao.getMessage(personId);
	}

	@Override
	public String delMessage(Integer messageId) {
		return messageDao.delMessage(messageId);
	}
	
	//根据用户id查询消息列表
		public List<Message> getAllMessageByPersonId(Integer personId) {
			return messageDao.getAllMessageByPersonId(personId);
		}

		//根据用户id和消息id删除消息信息
		public boolean deleteMessageByPersonId(Integer messageId, Integer personId) { 
			try {
				int result = messageDao.deleteMessagebyPersonId(personId, messageId);
				if(result>0){
					return true;
				}else{
					return false;
				} 
			} catch (Exception e) {
				return false;
			}
		}

		//插入一条消息信息
		public int insertMessage(Integer sendId, Integer personid, String message) {
			Message m = new Message ();
			m.setReceiveId(sendId);
			m.setPersonId(personid);
			m.setMessageContent(message);
			State s = new State();
			s.setStateId(6);
			m.setState(s);
			m.setSendDate(new Date());
			int insertMessage = messageDao.insertMessage(m);
			return insertMessage;
		}

}
