package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Idea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_idea", catalog = "commonweal")
public class Idea implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6061239455748434485L;
	private Integer ideaId;
	private String ideaContent;
	private Integer ideaPersonId;
	private String personEmail;
	private Timestamp ideaCreateDate;
	private Integer stateId;

	// Constructors

	/** default constructor */
	public Idea() {
	}

	/** minimal constructor */
	public Idea(Integer ideaId) {
		this.ideaId = ideaId;
	}

	/** full constructor */
	public Idea(Integer ideaId, String ideaContent, Integer ideaPersonId,
			String personEmail, Timestamp ideaCreateDate, Integer stateId) {
		this.ideaId = ideaId;
		this.ideaContent = ideaContent;
		this.ideaPersonId = ideaPersonId;
		this.personEmail = personEmail;
		this.ideaCreateDate = ideaCreateDate;
		this.stateId = stateId;
	}

	// Property accessors
	@Id
	@Column(name = "ideaId", unique = true, nullable = false)
	public Integer getIdeaId() {
		return this.ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	@Column(name = "ideaContent", length = 50)
	public String getIdeaContent() {
		return this.ideaContent;
	}

	public void setIdeaContent(String ideaContent) {
		this.ideaContent = ideaContent;
	}

	@Column(name = "ideaPersonId")
	public Integer getIdeaPersonId() {
		return this.ideaPersonId;
	}

	public void setIdeaPersonId(Integer ideaPersonId) {
		this.ideaPersonId = ideaPersonId;
	}

	@Column(name = "personEmail", length = 50)
	public String getPersonEmail() {
		return this.personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	@Column(name = "ideaCreateDate", length = 19)
	public Timestamp getIdeaCreateDate() {
		return this.ideaCreateDate;
	}

	public void setIdeaCreateDate(Timestamp ideaCreateDate) {
		this.ideaCreateDate = ideaCreateDate;
	}

	@Column(name = "stateId")
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}