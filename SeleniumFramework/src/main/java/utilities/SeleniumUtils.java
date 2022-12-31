package utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class SeleniumUtils {

	public String randomNumber(int digit) {
		return RandomStringUtils.randomNumeric(digit);
	}

	public String randomChars(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public void randomAlphaNumeric(int length) {
		RandomStringUtils.randomAlphanumeric(length);
	}

	public int randomNumberByRange(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;

	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public LocalDate getLocalDate() {

		return LocalDate.now();
	}

	public int getHour() {

		return LocalTime.now().getHour();
	}

	public int getMinute() {
		return LocalTime.now().getMinute();
	}

	public int getSeconds() {
		return LocalTime.now().getSecond();
	}

	public int getCurrentHourMinus(int hour) {
		return LocalTime.now().minusHours(hour).getHour();

	}

	public String getDayOfWeek() {

		return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);

	}

	public String getTimeStamp() {
		String s = DateTimeFormatter.ofPattern("MM-dd-yyyyHH:mm:ss").format(LocalDate.now());
		s = s.replace("-", "").replace(":", "");
		return s;
	}

	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public long roundOffValue(double dividend, double divisor) {
		double value = dividend / divisor;
		return (Math.round(value));
	}

	public String getDateTimeString() {

		Date d = new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");
		return date;

	}
}