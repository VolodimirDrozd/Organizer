package com.as;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
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
	public void changeRussianLocale() throws IOException {
		locale = Locale.getDefault();
		fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		assertTrue(property.getProperty("morning").equals("Доброе утро, Мир!"));
		assertTrue(property.getProperty("day").equals("Добрый день, Мир!"));
		assertTrue(property.getProperty("evening").equals("Добрый вечер, Мир!"));
		assertTrue(property.getProperty("night").equals("Доброй ночи, Мир!"));
	}

	@Test
	public void testEnglishLocale() throws IOException {
		locale = Locale.ENGLISH;
		fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		int hourMorning = 8;
		String morning  = app.showDayTimeCongrats(hourMorning, property);
		assertTrue(morning.equals("Good morning, World!"));
		int hourDay = 12;
		String day  = app.showDayTimeCongrats(hourDay, property);
		assertTrue(day.equals("Good day, World!"));
		int hourEvening = 20;
		String evening  = app.showDayTimeCongrats(hourEvening, property);
		assertTrue(evening.equals("Good evening, World!"));
		int hourNight = 1;
		String night  = app.showDayTimeCongrats(hourNight, property);
		assertTrue(night.equals("Good night, World!"));
	}

	@Test
	public void testRussianLocale() throws IOException {
		locale = Locale.getDefault();
		fis = app.changePropertyCurrentLenguage(locale.getLanguage());
		property.load(fis);
		int hourMorning = 8;
		String morning  = app.showDayTimeCongrats(hourMorning, property);
		assertTrue(morning.equals("Доброе утро, Мир!"));
		int hourDay = 12;
		String day  = app.showDayTimeCongrats(hourDay, property);
		assertTrue(day.equals("Добрый день, Мир!"));
		int hourEvening = 20;
		String evening  = app.showDayTimeCongrats(hourEvening, property);
		assertTrue(evening.equals("Добрый вечер, Мир!"));
		int hourNight = 1;
		String night  = app.showDayTimeCongrats(hourNight, property);
		assertTrue(night.equals("Доброй ночи, Мир!"));
	}

}
