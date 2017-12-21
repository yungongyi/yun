package cn.tuyuan.commonweal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * State entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_state", catalog = "commonweal")
public class State implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1461778635307431644L;
	private Integer stateId;
	private String stateName;
	private Integer tableId;

	// Constructors

	/** default constructor */
	public State() {
	}

	/** full constructor */
	public State(Integer stateId, String stateName, Integer tableId) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.tableId = tableId;
	}

	// Property accessors
	@Id
	@Column(name = "stateId", unique = true, nullable = false)
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "stateName", nullable = false, length = 50)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "tableId", nullable = false)
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

}