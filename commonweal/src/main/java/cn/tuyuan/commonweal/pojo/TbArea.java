package cn.tuyuan.commonweal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_area", catalog = "commonweal")
public class TbArea implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6936414366240694485L;
	private Integer areaId;
	private String areaName;
	private Integer cityId;

	// Constructors

	/** default constructor */
	public TbArea() {
	}

	/** minimal constructor */
	public TbArea(Integer areaId) {
		this.areaId = areaId;
	}

	/** full constructor */
	public TbArea(Integer areaId, String areaName, Integer cityId) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.cityId = cityId;
	}

	// Property accessors
	@Id
	@Column(name = "areaId", unique = true, nullable = false)
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "areaName", length = 50)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "cityId")
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}