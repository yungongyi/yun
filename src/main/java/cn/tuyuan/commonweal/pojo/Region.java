package cn.tuyuan.commonweal.pojo;

// Generated 2017-12-26 15:38:16 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Region generated by hbm2java
 */
@Entity
@Table(name = "region", catalog = "commonweal")
public class Region implements java.io.Serializable {

	private double regionId;
	private String regionCode;
	private String regionName;
	private double parentId;
	private double regionLevel;
	private double regionOrder;
	private String regionNameEn;
	private String regionShortnameEn;

	public Region() {
	}

	public Region(double regionId, String regionCode, String regionName,
			double parentId, double regionLevel, double regionOrder,
			String regionNameEn, String regionShortnameEn) {
		this.regionId = regionId;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.parentId = parentId;
		this.regionLevel = regionLevel;
		this.regionOrder = regionOrder;
		this.regionNameEn = regionNameEn;
		this.regionShortnameEn = regionShortnameEn;
	}

	@Id
	@Column(name = "REGION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public double getRegionId() {
		return this.regionId;
	}

	public void setRegionId(double regionId) {
		this.regionId = regionId;
	}

	@Column(name = "REGION_CODE", nullable = false, length = 100)
	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "REGION_NAME", nullable = false, length = 100)
	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Column(name = "PARENT_ID", nullable = false, precision = 22, scale = 0)
	public double getParentId() {
		return this.parentId;
	}

	public void setParentId(double parentId) {
		this.parentId = parentId;
	}

	@Column(name = "REGION_LEVEL", nullable = false, precision = 22, scale = 0)
	public double getRegionLevel() {
		return this.regionLevel;
	}

	public void setRegionLevel(double regionLevel) {
		this.regionLevel = regionLevel;
	}

	@Column(name = "REGION_ORDER", nullable = false, precision = 22, scale = 0)
	public double getRegionOrder() {
		return this.regionOrder;
	}

	public void setRegionOrder(double regionOrder) {
		this.regionOrder = regionOrder;
	}

	@Column(name = "REGION_NAME_EN", nullable = false, length = 100)
	public String getRegionNameEn() {
		return this.regionNameEn;
	}

	public void setRegionNameEn(String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}

	@Column(name = "REGION_SHORTNAME_EN", nullable = false, length = 10)
	public String getRegionShortnameEn() {
		return this.regionShortnameEn;
	}

	public void setRegionShortnameEn(String regionShortnameEn) {
		this.regionShortnameEn = regionShortnameEn;
	}

}
