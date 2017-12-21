package cn.tuyuan.commonweal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TableManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_table", catalog = "commonweal")
public class TableManage implements java.io.Serializable {

	// Fields

	/**
	 * 实体类版本
	 */
	private static final long serialVersionUID = -755407358926284265L;
	private Integer tableId;
	private String tableNameZh;
	private String tableNameUk;

	// Constructors

	/** default constructor */
	public TableManage() {
	}

	/** full constructor */
	public TableManage(Integer tableId, String tableNameZh, String tableNameUk) {
		this.tableId = tableId;
		this.tableNameZh = tableNameZh;
		this.tableNameUk = tableNameUk;
	}

	// Property accessors
	@Id
	@Column(name = "tableId", unique = true, nullable = false)
	public Integer getTableId() {
		return this.tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	@Column(name = "tableNameZH", nullable = false, length = 50)
	public String getTableNameZh() {
		return this.tableNameZh;
	}

	public void setTableNameZh(String tableNameZh) {
		this.tableNameZh = tableNameZh;
	}

	@Column(name = "tableNameUK", nullable = false, length = 50)
	public String getTableNameUk() {
		return this.tableNameUk;
	}

	public void setTableNameUk(String tableNameUk) {
		this.tableNameUk = tableNameUk;
	}

}