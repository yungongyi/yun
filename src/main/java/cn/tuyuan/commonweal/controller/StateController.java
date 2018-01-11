package cn.tuyuan.commonweal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.pojo.TableManage;
import cn.tuyuan.commonweal.service.StateService;
import cn.tuyuan.commonweal.service.TableManageService;

@RestController("stateController")
@RequestMapping("/state")
public class StateController {

	@Resource
	private StateService stateService;
	
	@Resource
	private TableManageService tableService;
	
	
	@RequestMapping(value = "/getAllState", method = RequestMethod.GET)
	public List<State> getAllState() {
		return stateService.getAllState();
	}
	@RequestMapping(value = "/insertstate/{stateName}/{tableId}", method = RequestMethod.GET)
	public int insertstate(@PathVariable String stateName,@PathVariable String tableId) {
		State s = new State();
		s.setStateName(stateName);
		s.setTableId(Integer.parseInt(tableId));
		return stateService.insertState(s);
	}
	
	
	/**
	 * 根据表ID查询状态信息
	 */
	@RequestMapping(value = "/getStateByTableId", method = RequestMethod.GET)
	public List<State> getStateByTableName(@RequestParam(value = "name", required = false) String name) {
		List<TableManage> t = tableService.getTableByName(name);		
		return stateService.findStateByTableId(t.get(0).getTableId());
	}
	@GetMapping("/getStateByTableId/{tableId}")
	public List<State> getStateByTableId(@PathVariable String tableId) {
		return stateService.findStateByTableId(Integer.parseInt(tableId));
	}
}
