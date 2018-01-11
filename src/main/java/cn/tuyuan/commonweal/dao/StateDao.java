package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.State;

/**
 * @author 景子铭
 * @version 1.0
 */

public interface StateDao {

	/**
	 * @describe 查询所有状态
	 * @return all state
	 */
	List<State> getAllState();	
	String getStateNameByStateId(Integer stateId);
	/**
	 * 根据状态Id查询状态信息
	 * @param stateId
	 * @return
	 */
    List<State> getStateById(int stateId);
    
    /**
     * 根据表ID查询状态信息
     * @param tableId
     * @return
     */
    List<State> getStateByTableId(Integer tableId);
    
    
    void addState(State state);

}
