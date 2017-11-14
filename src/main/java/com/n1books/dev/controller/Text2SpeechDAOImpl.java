package com.n1books.dev.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("springJDBC")
public class Text2SpeechDAOImpl implements Text2SpeechDAO {
	private static Logger logger = LoggerFactory.getLogger(Text2SpeechDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insertText2Speech(Text2SpeechVO vo) throws Exception {
		Object[] args = new Object[] { vo.getStatement(), vo.getLang() };

		jdbcTemplate.update("insert into tbl_text2speech(statement,lang)values(?,?)", args);
	}

	@Override
	public List<Text2SpeechVO> getText2SpeechList() throws Exception {
		RowMapper<Text2SpeechVO> rowMapper = new RowMapper<Text2SpeechVO>() {

			@Override
			public Text2SpeechVO mapRow(ResultSet rs, int rownum) throws SQLException {
				Text2SpeechVO vo = new Text2SpeechVO();
				vo.setNo(rs.getInt("no"));
				vo.setStatement(rs.getString("statement"));
				vo.setLang(rs.getString("lang"));
				System.out.println(rownum);
				return vo;
			} // query수행하면서 rowMapper걸리면 하나하나씩 rowMap으로 호출
		};

		return jdbcTemplate.query("select no, statement, lang from tbl_text2speech order by no desc", rowMapper);
	}

	@Override
	public int deleteText2Speech(int no) throws Exception {
		return 0;
	}

}
