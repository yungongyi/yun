package cn.tuyuan.commonweal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.Operation;
import cn.tuyuan.commonweal.service.OperationService;

/**
 * @author 孙家伟
 * 2017年12月31日
 *操作记录controller
 */
@RestController
@RequestMapping("/operation")
public class OperationController {
 
	@Resource
	private OperationService OperationService;
	
	
	@RequestMapping("/getoperations")
	public List<Operation> getOperation(){
		//获取全部操作记录信息
		List<Operation> operations = OperationService.getOperation();
		return operations;
	}
	@RequestMapping("/getoperationsByPersonName/{personname}")
	public List<Operation> getOperationbypersonName(@PathVariable String personname){
		//获取全部操作记录信息
		List<Operation> operations = OperationService.getOperationByPersonName(personname);
	 
		return operations;
	}
}
 