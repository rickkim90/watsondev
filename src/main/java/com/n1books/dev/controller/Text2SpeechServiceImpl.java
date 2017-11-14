package com.n1books.dev.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

@Component("service")
public class Text2SpeechServiceImpl extends TextToSpeech implements Text2SpeechService { // 클래스가 인스턴스화

	@Autowired
	//@Qualifier("ibatis")
	@Qualifier("text2SpeechDAOMybatis")
	private Text2SpeechDAO text2SpeechDAO;

	public Text2SpeechServiceImpl() {
		setUsernameAndPassword("b0883724-4f87-456c-991b-c07bde6fc85b", "gPr35i2TgMpX");
	}

	@Override
	public List<Voice> getVoiceList() throws Exception {
		List<Voice> voices = getVoices().execute();
		return voices;
	}

	@Override
	public InputStream getSpeech(String statement, String voice) throws Exception {
		return synthesize(statement, new Voice(voice, null, null), AudioFormat.OGG).execute();
	}

	@Override
	public void insertText2Speech(Text2SpeechVO vo) throws Exception { // insert 예외처리
		try {
			text2SpeechDAO.insertText2Speech(vo);
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // 예외가 발생되면 메세지 찍고 throw
		}
	}

	@Override
	public List<Text2SpeechVO> getText2SpeechList() throws Exception {
		return text2SpeechDAO.getText2SpeechList();
	}

	@Override
	public void deleteText2Speech(int no) throws Exception {
		if (text2SpeechDAO.deleteText2Speech(no) == 0) {
			throw new RuntimeException("없는 번호입니다");
		}
	}
}
