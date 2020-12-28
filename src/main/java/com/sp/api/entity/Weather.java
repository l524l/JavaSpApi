package com.sp.api.entity;

/**
 * Author Pershin Andrew
 */
public class Weather {
    private WeatherType weather;

    public Weather() {
    }

    public Weather(WeatherType weather) {
        this.weather = weather;
    }

    public WeatherType getWeather() {
        return weather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather1 = (Weather) o;

        return weather == weather1.weather;
    }

    @Override
    public int hashCode() {
        return weather.hashCode();
    }
}
