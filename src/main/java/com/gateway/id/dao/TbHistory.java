package com.gateway.id.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_history")
public class TbHistory {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditrail_id", nullable = false)
	private Long auditrailId;

	@Column(name = "auditrail_date")
	private Date auditrailDate;

	@Column(name = "username")
	private String username;

	@Column(name = "menu")
	private String menu;

	@Column(name = "action")
	private String action;

	@Column(name = "row_id")
	private Integer row_id;

	public Long getAuditrailId() {
		return auditrailId;
	}

	public void setAuditrailId(Long auditrailId) {
		this.auditrailId = auditrailId;
	}

	public Date getAuditrailDate() {
		return auditrailDate;
	}

	public void setAuditrailDate(Date auditrailDate) {
		this.auditrailDate = auditrailDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getRow_id() {
		return row_id;
	}

	public void setRow_id(Integer row_id) {
		this.row_id = row_id;
	}

	@Override
	public String toString() {
		return "TbHistory [auditrailId=" + auditrailId + ", auditrailDate=" + auditrailDate + ", username=" + username
				+ ", menu=" + menu + ", action=" + action + ", row_id=" + row_id + "]";
	}

}
