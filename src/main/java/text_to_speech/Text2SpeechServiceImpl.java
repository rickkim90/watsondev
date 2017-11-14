package text_to_speech;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

@Component("service")
public class Text2SpeechServiceImpl extends TextToSpeech implements Text2SpeechService { // 클래스가 인스턴스화

	public Text2SpeechServiceImpl() {
		setUsernameAndPassword("b0883724-4f87-456c-991b-c07bde6fc85b", "gPr35i2TgMpX");
	}

	@Override
	public List<Voice> getVoiceList() throws Exception {
		List<Voice> voices = getVoices().execute();
		return voices;
	}

}
