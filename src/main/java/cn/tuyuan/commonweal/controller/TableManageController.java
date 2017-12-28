package cn.tuyuan.commonweal.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.service.TableManageService;

/**
 * 
 * @author 	陈嘉伟
 *
 */
@RestController("tableManageController")
public class TableManageController {

	@Resource 
	private TableManageService tableManageService;
	
	
}
