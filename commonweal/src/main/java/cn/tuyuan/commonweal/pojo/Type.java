package cn.tuyuan.commonweal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_type", catalog = "commonweal")
public class Type implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4660099559352711261L;
	private Integer typeId;
	private String typeName;
	private Integer tableId;

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(Integer typeId, String typeName, Integer tableId) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.tableId = tableId;
	}

	// Property accessors
	@Id
	@Column(name = "typeId", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "typeName", nullable = false, length = 50)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "tableId", nullable = false)
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

}