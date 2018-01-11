package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.State;

/**
 * @author 景子铭
 * @version 1.0
 */

public interface StateService {

	/**
	 * @describe 查询所有状态
	 * @return all state
	 */
	List<State> getAllState();
	
	/**
	 * @describe 根据状态Id查询状态
	 * @param 状态Id
	 * @return stateName 状态名
	 */

	String getStateNameByStateId(Integer stateId);

	List<State> findState(int statusId);
	
	/**
	 * 根据表Id查询状态信息
	 * @param tableId
	 * @return
	 */
	List<State>  findStateByTableId(Integer tableId);
    int insertState(State state);

}
