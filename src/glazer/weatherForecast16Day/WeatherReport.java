package glazer.weatherForecast16Day;

public class WeatherReport {
	private City city;
	private List[] list;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List[] getList() {
		return list;
	}

	public void setList(List[] list) {
		this.list = list;
	}
}
