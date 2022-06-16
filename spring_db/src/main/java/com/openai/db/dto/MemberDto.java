package com.openai.db.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String m_id;
	private String m_name;
	private String m_pwd;
	private int m_age;
	private String m_addr;
}
