package cn.tuyuan.commonweal.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Table;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.pojo.Type;
import cn.tuyuan.commonweal.service.StateService;
import cn.tuyuan.commonweal.service.TableManageService;
import cn.tuyuan.commonweal.service.TypeService;

/**
 * 
 * @author 	孙家伟
 *
 */
@RestController
@RequestMapping("/table")
public class TableManageController {

	@Resource 
	private TableManageService tableManageService;
	@Resource
	private StateService stateService;
	@Resource
	private TypeService typeService;
	/*
	 * 显示所有表的信息
	 */
	@RequestMapping("/alltable.html") 
	public List<TableManage> alltable(){ 
		List<TableManage> tableManagesList= tableManageService.getTableManage(); 
		return tableManagesList;
	}

	/*
	 * 通过id显示表
	 */
	@RequestMapping("/alltypebytable/{tableId}")
	public Object viewById(@PathVariable("tableId") String tableId,Map<String, Object> map){
		List<State>statusList= stateService.findStateByTableId(Integer.parseInt(tableId));
		List<Type> tableType= typeService.getTypeByTableId(Integer.parseInt(tableId));

		for (State state : statusList ) {
			System.out.println(state.getStateName()+"sad");
		}
		map.put("states", statusList);
		map.put("types", tableType);
		System.out.println(JSONArray.toJSONString(map));
		return JSONArray.toJSONString(map);
	}
	/*
	 * 新增表
	 */
	@RequestMapping("/addTable/{tableNameZH}/{tableNameUK}")
	public int addTable(@PathVariable("tableNameZH") String tableNameZH,@PathVariable("tableNameUK") String tableNameUK){
		TableManage table=new TableManage();
		table.setTableNameUk(tableNameUK);
		table.setTableNameZh(tableNameZH);
		int count= tableManageService.insertTable(table);
		return count;
	}
}
