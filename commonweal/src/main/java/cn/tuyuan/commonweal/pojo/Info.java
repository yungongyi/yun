package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Info entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_info", catalog = "commonweal")
public class Info implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7915837574733146717L;
	private Integer infoId;
	private String infoContent;
	private Timestamp infoCreateDate;

	// Constructors

	/** default constructor */
	public Info() {
	}

	/** minimal constructor */
	public Info(Integer infoId) {
		this.infoId = infoId;
	}

	/** full constructor */
	public Info(Integer infoId, String infoContent, Timestamp infoCreateDate) {
		this.infoId = infoId;
		this.infoContent = infoContent;
		this.infoCreateDate = infoCreateDate;
	}

	// Property accessors
	@Id
	@Column(name = "infoId", unique = true, nullable = false)
	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	@Column(name = "infoContent")
	public String getInfoContent() {
		return this.infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	@Column(name = "infoCreateDate", length = 19)
	public Timestamp getInfoCreateDate() {
		return this.infoCreateDate;
	}

	public void setInfoCreateDate(Timestamp infoCreateDate) {
		this.infoCreateDate = infoCreateDate;
	}

}