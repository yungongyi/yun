package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Operation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_operation", catalog = "commonweal")
public class Operation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5059676708335595361L;
	private Integer operationId;
	private Timestamp operationDate;
	private Integer tableId;
	private Integer typeId;
	private Integer operationPersonId;
	private String operationNote;

	// Constructors

	/** default constructor */
	public Operation() {
	}

	/** minimal constructor */
	public Operation(Integer operationId) {
		this.operationId = operationId;
	}

	/** full constructor */
	public Operation(Integer operationId, Timestamp operationDate,
			Integer tableId, Integer typeId, Integer operationPersonId,
			String operationNote) {
		this.operationId = operationId;
		this.operationDate = operationDate;
		this.tableId = tableId;
		this.typeId = typeId;
		this.operationPersonId = operationPersonId;
		this.operationNote = operationNote;
	}

	// Property accessors
	@Id
	@Column(name = "operationId", unique = true, nullable = false)
	public Integer getOperationId() {
		return this.operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	@Column(name = "operationDate", length = 19)
	public Timestamp getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Timestamp operationDate) {
		this.operationDate = operationDate;
	}

	@Column(name = "tableId")
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	@Column(name = "typeId")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "operationPersonId")
	public Integer getOperationPersonId() {
		return this.operationPersonId;
	}

	public void setOperationPersonId(Integer operationPersonId) {
		this.operationPersonId = operationPersonId;
	}

	@Column(name = "operationNote", length = 50)
	public String getOperationNote() {
		return this.operationNote;
	}

	public void setOperationNote(String operationNote) {
		this.operationNote = operationNote;
	}

}