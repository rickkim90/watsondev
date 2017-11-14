package NLC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class NLCExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		System.out.println("분류하고 싶은 문자열은 입력하세요. \n종료하면 '종료' 라고 입력하세요");
		for (;;) {
			String in = sc.nextLine();
			if (in.equals("exit"))
				break;
			list.add(in);
		}

		for (String str : list) {
			NaturalLanguageClassifier service = new NaturalLanguageClassifier();
			service.setUsernameAndPassword("ae801ec8-a2b7-4f68-926a-e9de7499b50a", "JCb3dPxfo11K");
			Classification classification = service.classify("ebd44cx231-nlc-24243", str).execute();
			System.out.println(classification);
		}
		sc.close();
	}
}
