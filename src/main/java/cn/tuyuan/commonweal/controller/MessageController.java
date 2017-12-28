package cn.tuyuan.commonweal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.tuyuan.commonweal.pojo.Info;
import cn.tuyuan.commonweal.pojo.Message;
import cn.tuyuan.commonweal.service.MessageService;

@RestController("messageController")
@RequestMapping("/message")
public class MessageController {

	@Resource
	private MessageService messageService;

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public List<Message> getMessage() {
		List<Message> list = messageService.getAllMessage();
		return list;
	}

	@RequestMapping(value = "/getMessageById", method = RequestMethod.GET)
	public List<Message> getMessage(Integer personId) {
		List<Message> messageList = null;
		// 判断id是否为空
		if (personId == null) {
			// id为空 查询全部信息
			messageList = (List<Message>) messageService.getAllMessage();
		} else {
			// id不为空 根据id查询信息
			messageList = new ArrayList<Message>();
			Message message = messageService.getMessage(personId);
			messageList.add(message);
		}
		return messageList;
	}

	@RequestMapping(value = "/delMessage", method = RequestMethod.GET)
	public void delMessage(Integer messageId) {
		messageService.delMessage(messageId);
	}
}
