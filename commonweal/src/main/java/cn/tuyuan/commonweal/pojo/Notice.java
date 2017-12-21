package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_notice", catalog = "commonweal")
public class Notice implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6816551928448432639L;
	private Integer noticeId;
	private Integer noticeImgId;
	private String noticeDetail;
	private String noticeTittle;
	private Integer areaId;
	private Integer noticeAging;
	private Integer typeId;
	private Timestamp noticeCreateDate;
	private Integer stateId;
	private Integer personId;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Integer noticeId, Timestamp noticeCreateDate) {
		this.noticeId = noticeId;
		this.noticeCreateDate = noticeCreateDate;
	}

	/** full constructor */
	public Notice(Integer noticeId, Integer noticeImgId, String noticeDetail,
			String noticeTittle, Integer areaId, Integer noticeAging,
			Integer typeId, Timestamp noticeCreateDate, Integer stateId,
			Integer personId) {
		this.noticeId = noticeId;
		this.noticeImgId = noticeImgId;
		this.noticeDetail = noticeDetail;
		this.noticeTittle = noticeTittle;
		this.areaId = areaId;
		this.noticeAging = noticeAging;
		this.typeId = typeId;
		this.noticeCreateDate = noticeCreateDate;
		this.stateId = stateId;
		this.personId = personId;
	}

	// Property accessors
	@Id
	@Column(name = "noticeId", unique = true, nullable = false)
	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	@Column(name = "noticeImgId")
	public Integer getNoticeImgId() {
		return this.noticeImgId;
	}

	public void setNoticeImgId(Integer noticeImgId) {
		this.noticeImgId = noticeImgId;
	}

	@Column(name = "noticeDetail")
	public String getNoticeDetail() {
		return this.noticeDetail;
	}

	public void setNoticeDetail(String noticeDetail) {
		this.noticeDetail = noticeDetail;
	}

	@Column(name = "noticeTittle", length = 50)
	public String getNoticeTittle() {
		return this.noticeTittle;
	}

	public void setNoticeTittle(String noticeTittle) {
		this.noticeTittle = noticeTittle;
	}

	@Column(name = "areaId")
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "noticeAging")
	public Integer getNoticeAging() {
		return this.noticeAging;
	}

	public void setNoticeAging(Integer noticeAging) {
		this.noticeAging = noticeAging;
	}

	@Column(name = "typeId")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "noticeCreateDate", nullable = false, length = 19)
	public Timestamp getNoticeCreateDate() {
		return this.noticeCreateDate;
	}

	public void setNoticeCreateDate(Timestamp noticeCreateDate) {
		this.noticeCreateDate = noticeCreateDate;
	}

	@Column(name = "stateId")
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "personId")
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

}