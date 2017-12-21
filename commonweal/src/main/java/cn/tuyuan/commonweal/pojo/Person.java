package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_person", catalog = "commonweal")
public class Person implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3383150430473799926L;
	private Integer personid;
	private String iphone;
	private String name;
	private String password;
	private Timestamp personCreateDate;
	private Integer sex;
	private Integer areaId;
	private Integer personImgId;
	private Integer stateId;
	private Integer typeId;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** minimal constructor */
	public Person(Integer personid) {
		this.personid = personid;
	}

	/** full constructor */
	public Person(Integer personid, String iphone, String name,
			String password, Timestamp personCreateDate, Integer sex,
			Integer areaId, Integer personImgId, Integer stateId, Integer typeId) {
		this.personid = personid;
		this.iphone = iphone;
		this.name = name;
		this.password = password;
		this.personCreateDate = personCreateDate;
		this.sex = sex;
		this.areaId = areaId;
		this.personImgId = personImgId;
		this.stateId = stateId;
		this.typeId = typeId;
	}

	// Property accessors
	@Id
	@Column(name = "personid", unique = true, nullable = false)
	public Integer getPersonid() {
		return this.personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	@Column(name = "iphone", length = 50)
	public String getIphone() {
		return this.iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "personCreateDate", length = 19)
	public Timestamp getPersonCreateDate() {
		return this.personCreateDate;
	}

	public void setPersonCreateDate(Timestamp personCreateDate) {
		this.personCreateDate = personCreateDate;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "areaId")
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "personImgId")
	public Integer getPersonImgId() {
		return this.personImgId;
	}

	public void setPersonImgId(Integer personImgId) {
		this.personImgId = personImgId;
	}

	@Column(name = "stateId")
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "typeId")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}