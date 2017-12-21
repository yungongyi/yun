package cn.tuyuan.commonweal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbCity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_city", catalog = "commonweal")
public class City implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1864579227498369182L;
	private Integer cityId;
	private String cityName;
	private Integer provinceId;

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Integer cityId) {
		this.cityId = cityId;
	}

	/** full constructor */
	public City(Integer cityId, String cityName, Integer provinceId) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
	}

	// Property accessors
	@Id
	@Column(name = "cityId", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "cityName", length = 50)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "provinceId")
	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

}