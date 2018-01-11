package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.StateDao;
import cn.tuyuan.commonweal.pojo.State;
import cn.tuyuan.commonweal.service.StateService;

/**
 * 
 * @author 景子铭
 * @version 1.0
 */

@Service("stateService")
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDao stateDao;

	@Override
	public List<State> getAllState() {
		return stateDao.getAllState();
	}
	
	// 根据状态id查询状态名
		@Override
		public String getStateNameByStateId(Integer stateId) {
			return stateDao.getStateNameByStateId(stateId);
		}
		/*
		 * 通过id查询状态 
		 *  
		 */
		@Override
		public List<State> findState(int statusId) {
			return stateDao.getStateById(statusId);
		}
		/*
		 * 通过关联的表的id查询数据 
		 *  
		 */
		@Override
		public List<State> findStateByTableId(Integer tableId) {		
			return stateDao.getStateByTableId(tableId);
		}
		/*
		 * 新增状态 
		 *  
		 */
		@Override
		public int insertState(State state) {
			 
			try {
		stateDao.addState(state);
				   return 1;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
				 

		}

}
