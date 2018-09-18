package exB2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kadai8 {
	public static void main(String[] args) {
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
		Logger logger = LoggerFactory.getLogger(Kadai8.class);

		switch (args[0]) {
		case ("trace"):
			logger.trace("トレースレベルログ");
		case ("debug"):
			logger.debug("デバックレベルログ");
		case ("info"):
			logger.info("情報レベルログ");
		case ("warn"):
			logger.warn("ワーニングレベルログ");
		case ("error"):
			logger.error("エラーレベルログ");
			break;
		}
	}
}