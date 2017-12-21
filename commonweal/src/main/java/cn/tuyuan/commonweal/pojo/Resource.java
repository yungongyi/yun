package cn.tuyuan.commonweal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_resource", catalog = "commonweal")
public class Resource implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8641492168590511647L;
	private Integer resourceId;
	private String resourcePath;
	private Integer typeId;
	private String resourceSource;
	private Integer typeState;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** minimal constructor */
	public Resource(Integer resourceId) {
		this.resourceId = resourceId;
	}

	/** full constructor */
	public Resource(Integer resourceId, String resourcePath, Integer typeId,
			String resourceSource, Integer typeState) {
		this.resourceId = resourceId;
		this.resourcePath = resourcePath;
		this.typeId = typeId;
		this.resourceSource = resourceSource;
		this.typeState = typeState;
	}

	// Property accessors
	@Id
	@Column(name = "resourceId", unique = true, nullable = false)
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "resourcePath", length = 100)
	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	@Column(name = "typeId")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "resourceSource", length = 50)
	public String getResourceSource() {
		return this.resourceSource;
	}

	public void setResourceSource(String resourceSource) {
		this.resourceSource = resourceSource;
	}

	@Column(name = "typeState")
	public Integer getTypeState() {
		return this.typeState;
	}

	public void setTypeState(Integer typeState) {
		this.typeState = typeState;
	}

}