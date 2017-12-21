package cn.tuyuan.commonweal.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_message", catalog = "commonweal")
public class Message implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 77817114182859571L;
	private Integer messageId;
	private Integer sendId;
	private String messageContent;
	private Integer receiveId;
	private Timestamp sendDate;
	private Integer stateId;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Integer messageId) {
		this.messageId = messageId;
	}

	/** full constructor */
	public Message(Integer messageId, Integer sendId, String messageContent,
			Integer receiveId, Timestamp sendDate, Integer stateId) {
		this.messageId = messageId;
		this.sendId = sendId;
		this.messageContent = messageContent;
		this.receiveId = receiveId;
		this.sendDate = sendDate;
		this.stateId = stateId;
	}

	// Property accessors
	@Id
	@Column(name = "messageId", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@Column(name = "sendId")
	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	@Column(name = "messageContent", length = 50)
	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Column(name = "receiveId")
	public Integer getReceiveId() {
		return this.receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	@Column(name = "sendDate", length = 19)
	public Timestamp getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	@Column(name = "stateId")
	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}