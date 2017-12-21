package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Partner entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_partner", catalog = "commonweal")
public class Partner implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1579918985090722340L;
	private Integer partnerId;
	private String partnerName;
	private Integer partnerMarkId;
	private Timestamp partnerStartDate;
	private Timestamp partnerEndDate;
	private Integer supportSourceId;
	private Integer stateId;

	// Constructors

	/** default constructor */
	public Partner() {
	}

	/** minimal constructor */
	public Partner(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/** full constructor */
	public Partner(Integer partnerId, String partnerName,
			Integer partnerMarkId, Timestamp partnerStartDate,
			Timestamp partnerEndDate, Integer supportSourceId, Integer stateId) {
		this.partnerId = partnerId;
		this.partnerName = partnerName;
		this.partnerMarkId = partnerMarkId;
		this.partnerStartDate = partnerStartDate;
		this.partnerEndDate = partnerEndDate;
		this.supportSourceId = supportSourceId;
		this.stateId = stateId;
	}

	// Property accessors
	@Id
	@Column(name = "partnerId", unique = true, nullable = false)
	public Integer getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	@Column(name = "partnerName", length = 50)
	public String getPartnerName() {
		return this.partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	@Column(name = "partnerMarkId")
	public Integer getPartnerMarkId() {
		return this.partnerMarkId;
	}

	public void setPartnerMarkId(Integer partnerMarkId) {
		this.partnerMarkId = partnerMarkId;
	}

	@Column(name = "partnerStartDate", length = 19)
	public Timestamp getPartnerStartDate() {
		return this.partnerStartDate;
	}

	public void setPartnerStartDate(Timestamp partnerStartDate) {
		this.partnerStartDate = partnerStartDate;
	}

	@Column(name = "partnerEndDate", length = 19)
	public Timestamp getPartnerEndDate() {
		return this.partnerEndDate;
	}

	public void setPartnerEndDate(Timestamp partnerEndDate) {
		this.partnerEndDate = partnerEndDate;
	}

	@Column(name = "supportSourceId")
	public Integer getSupportSourceId() {
		return this.supportSourceId;
	}

	public void setSupportSourceId(Integer supportSourceId) {
		this.supportSourceId = supportSourceId;
	}

	@Column(name = "stateId")
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}