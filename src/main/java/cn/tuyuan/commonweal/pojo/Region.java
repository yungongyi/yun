package cn.tuyuan.commonweal.pojo;

// Generated 2017-12-26 15:38:16 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Region generated by hbm2java
 */
@Entity
@Table(name = "region", catalog = "commonweal")
public class Region implements java.io.Serializable {

	private Integer regionId;
	private String regionCode;
	private String regionName;
	private Integer parentId;
	private Integer regionLevel;
	private Integer regionOrder;
	private String regionNameEn;
	private String regionShortnameEn;

	public Region() {
	}

	public Region(Integer regionId, String regionCode, String regionName,
			Integer parentId, Integer regionLevel, Integer regionOrder,
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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "REGION_ID", unique = true)
	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	@Column(name = "REGION_CODE",length = 100)
	public String getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	@Column(name = "REGION_NAME", length = 100)
	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Column(name = "PARENT_ID")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "REGION_LEVEL")
	public Integer getRegionLevel() {
		return this.regionLevel;
	}

	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}

	@Column(name = "REGION_ORDER",  scale = 0)
	public Integer getRegionOrder() {
		return this.regionOrder;
	}

	public void setRegionOrder(Integer regionOrder) {
		this.regionOrder = regionOrder;
	}

	@Column(name = "REGION_NAME_EN", length = 100)
	public String getRegionNameEn() {
		return this.regionNameEn;
	}

	public void setRegionNameEn(String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}

	@Column(name = "REGION_SHORTNAME_EN",length = 10)
	public String getRegionShortnameEn() {
		return this.regionShortnameEn;
	}

	public void setRegionShortnameEn(String regionShortnameEn) {
		this.regionShortnameEn = regionShortnameEn;
	}

}