package com.as;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest extends Assert {

	private Locale locale;
	private Properties property;
	private FileInputStream fis;
	private App app;

	@Before
	public void initialize() {
		property = new Properties();
		app = new App();
	}

	@Test
	public void changeEnglishLocale() throws IOException {
		locale = Locale.ENGLISH;
		fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		assertTrue(property.getProperty("morning").equals("Good morning, World!"));
		assertTrue(property.getProperty("day").equals("Good day, World!"));
		assertTrue(property.getProperty("evening").equals("Good evening, World!"));
		assertTrue(property.getProperty("night").equals("Good night, World!"));
	}


	@Test
	public void testEnglishLocale() throws IOException {
		locale = Locale.ENGLISH;
		fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		int hourMorning = 8;
		String morning = app.showDayTimeCongrats(hourMorning, property);
		assertTrue(morning.equals("Good morning, World!"));
		int hourDay = 12;
		String day = app.showDayTimeCongrats(hourDay, property);
		assertTrue(day.equals("Good day, World!"));
		int hourEvening = 20;
		String evening = app.showDayTimeCongrats(hourEvening, property);
		assertTrue(evening.equals("Good evening, World!"));
		int hourNight = 1;
		String night = app.showDayTimeCongrats(hourNight, property);
		assertTrue(night.equals("Good night, World!"));
	}

	@Test
	public void testRussianLocale() throws IOException {

		locale = app.getUaLocale();
		fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		int hourMorning = 8;
		String morning = app.showDayTimeCongrats(hourMorning, property);
		assertTrue(morning.equals(property.get("morning")));
		int hourDay = 12;
		String day = app.showDayTimeCongrats(hourDay, property);
		assertTrue(day.equals(property.get("day")));
		int hourEvening = 20;
		String evening = app.showDayTimeCongrats(hourEvening, property);
		assertTrue(evening.equals(property.get("evening")));
		int hourNight = 1;
		String night = app.showDayTimeCongrats(hourNight, property);
		assertTrue(night.equals(property.get("night")));
	}

}
