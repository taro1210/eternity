package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HealthCheckLogic {
	public void exe(Health health) {
		double height = health.getHeight();
		double weight = health.getWeight();
		BigDecimal bd = new BigDecimal(weight / (height / 100.0 * height / 100.0));
	      bd = bd.setScale(1, RoundingMode.HALF_UP);
	    double bmi = bd.doubleValue();
		health.setBmi(bmi);

		String bodyType;
		if (bmi < 18.5) {
			bodyType = "痩せ型";
		} else if (bmi < 25) {
			bodyType = "標準";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);

		String messege = "";
		int msg = (int) (Math.random() * 3);
		if (bmi < 18.5) {
			switch (msg) {
			case 0:
				messege = "少し痩せすぎです、ご飯を食べましょう";
				break;
			case 1:
				messege = "貧血は大丈夫でしょうか？激しい運動の後は栄養を補給しましょう";
				break;
			case 2:
				messege = "ストレスなどを抱えてはいませんか？周りに相談してみては？";
				break;
			}
		} else if (bmi < 25) {
			switch (msg) {
			case 0:
				messege = "適正体重です。このまま維持していきましょう";
				break;
			case 1:
				messege = "適度に運動などを取り入れこの体型を維持しましょう";
				break;
			case 2:
				messege = "改善の必要はなさそうです。これからもこの調子でいきましょう";
				break;
			}
		} else {
			switch (msg) {
			case 0:
				messege = "少し肥満気味です。食事などを改善しましょう";
				break;
			case 1:
				messege = "運動などはされていますか？もう少し体を動かすようにしましょう";
				break;
			case 2:
				messege = "お腹回りなど変化は見られませんか？毎日の積み重ねで改善していきましょう";
				break;
			}
		}
		health.setMessege(messege);
	}
}