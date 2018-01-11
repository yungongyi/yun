package cn.tuyuan.commonweal.dao;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Idea;

/**
 * @author 景子铭
 * @version 1.0
 */

public interface IdeaDao {

	/**
	 * @describe 查询所有意见信息
	 * @return all Idea
	 */
	List<Idea> getAllIdea();

	/**
	 * @describe 查询意见信息
	 * @param ideaId
	 *            意见信息id
	 * @return Idea
	 */
	Idea getIdea(Integer ideaId);
	
	/**
	 * @describe 修改意见信息（只能修改状态）
	 * @param ideaId stateId
	 */
	
	void updateIdea(Integer ideaId,Integer stateId);
	

	/**
	 * @describe 删除意见反馈信息
	 * @param ideaId
	 *            消息id
	 */
	String delIdea(Integer ideaId);
	
	void addIdea(Idea idea);

}
