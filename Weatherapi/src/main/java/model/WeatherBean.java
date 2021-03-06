package model;

public class WeatherBean {

	private String cityStr;
	private String countryStr;

	private String cloudsStr;
	
	
	private String description;

	private String temperatureStr;
	
	private int tempC;
	
	private String precipitation;
	

	private String icon;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getTemperature() {
		return temperatureStr;
	}

	public void setTemperature(String temperatureStr) {
		this.temperatureStr = temperatureStr;
		tempConvertKtoC(temperatureStr);
	}
	
	public String getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}

	public void tempConvertKtoC(String temperatureStr) {
		double celsius = Double.parseDouble(temperatureStr) - 273.15;
		System.out.println(celsius);
		int resultTemp = (int) Math.round(celsius);
		setTempC(resultTemp);
	}
	
	public double getTempC() {
		return tempC;
	}

	public void setTempC(int tempC) {
		this.tempC = tempC;
	}
	
	

	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}
	
	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
//
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {	
		this.icon = icon;
	}

	
	public void generateIcon (String iconID) {
		//âī¸đâī¸âđ¤ī¸đĨī¸đĻī¸đ§ī¸đ¨ī¸âī¸đŠī¸âī¸
		switch(iconID) {
		case "01d": this.icon="đ";
			break;
		case "01n": this.icon="đ";
			break;
		case "02d": this.icon="â";
			break;
		case "02n": this.icon="đ";
			break;
		case "04d": 
		case "04n":
			this.icon="âī¸";
			break;
		case "09d":
		case "09n":
			this.icon="đ§ī¸";
			break;
		case "10d":
		case "10n":
			this.icon="đĻī¸";
			break;
		case "11d":
		case "11n":
			if (precipitation.equals("no")) {
				this.icon="đŠī¸";
			} else {
				this.icon="âī¸";
			}
			break;
		case "13d":
		case "13n":
			this.icon="âī¸";
			break;
		case "50d":
		case "50n":
			this.icon="đĢī¸";
			break;
		}
	}

}
