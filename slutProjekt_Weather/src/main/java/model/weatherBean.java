package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class weatherBean {

	private String cityStr;

	private String countryStr;

	private String weatherStr;

	private String tempStr;

	private String timeStamp;

	public weatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getWeatherStr() {
		return weatherStr;
	}

	public void setWeatherStr(String weatherStr) {
		this.weatherStr = weatherStr;
	}

	public String getTempStr() {
		return tempStr;
	}

	public void setTempStr(String tempStr) {
		this.tempStr = tempStr;
	}

	public String getTimeStamp() {

		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		this.timeStamp = formatter.format(date);

	}

}