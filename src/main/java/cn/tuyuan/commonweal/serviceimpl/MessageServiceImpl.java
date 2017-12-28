package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.MessageDao;
import cn.tuyuan.commonweal.pojo.Message;
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
	public void delMessage(Integer messageId) {
		messageDao.delMessage(messageId);
	}

}
