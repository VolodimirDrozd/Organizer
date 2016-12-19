package com.as;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

public class App {
	public static void main(String[] args) throws IOException {

		App app = new App();
		Locale locale = app.getUaLocale();
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		Properties property = new Properties();

		FileInputStream fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		app.showDayTimeCongrats(hour, property);

	}

	public String showDayTimeCongrats(int hour, Properties property) {
		if ((hour >= 6) & (hour <= 9)) {
			System.out.println(property.getProperty("morning"));
			return property.getProperty("morning");
		}
		if ((hour >= 9) & (hour <= 19)) {
			System.out.println(property.getProperty("day"));
			return property.getProperty("day");
		}
		if ((hour >= 19) & (hour <= 23)) {
			System.out.println(property.getProperty("evening"));
			return property.getProperty("evening");
		}
		if (((hour >= 23) && (hour <= 24)) || ((hour <= 6) && ((hour >= 0)))) {
			System.out.println(property.getProperty("night"));
			return property.getProperty("night");
		}
		return null;
	}

	public FileInputStream changePropertyCurrentLenguage(String currentLenguage) throws FileNotFoundException {
		FileInputStream fis;
		switch (currentLenguage) {
		case "en":
			fis = new FileInputStream("src/main/resources/English-massage.properties");
			break;
		case "ru":
			fis = new FileInputStream("src/main/resources/Russian-massage.properties");
			break;
		default:
			fis = new FileInputStream("src/main/resources/English-massage.properties");
		}
		return fis;
	}

	public Locale getUaLocale() {
		return new Locale.Builder().setLanguage("ru").setRegion("UA").build();
	}

}
