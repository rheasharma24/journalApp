package com.example.demo.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {
    @JsonProperty()
    private Request request;
    @JsonProperty()
    private Location location;
    @JsonProperty()
    private Current current;

    @Getter
    @Setter
    public static class AirQuality{
        @JsonProperty()
        private String co;
        @JsonProperty()
        private String no2;
        @JsonProperty()
        private String o3;
        @JsonProperty()
        private String so2;
        @JsonProperty("pm2_5")
        private String pm25 ;
        @JsonProperty()
        private String pm10;
        @JsonProperty("us-epa-index")
        private String usEpaIndex;
        @JsonProperty("gb-defra-index")
        private String gbDefraIndex;
    }

    @Getter
    @Setter
    public static class Astro{
        @JsonProperty()
       private String sunrise;
        @JsonProperty()
       private String sunset;
        @JsonProperty()
        private String moonrise;
        @JsonProperty()
       private String moonset;
        @JsonProperty("moon_phase")
        private String moonPhase;
        @JsonProperty("moon_illumination")
        private int moonIllumination;
    }

    @Getter
    @Setter
    public  static class Current{

        @JsonProperty("observation_time")
        private String observationTime;

        @JsonProperty()
        private int temperature;

        @JsonProperty("weather_code")
        private int weatherCode;

        @JsonProperty("weather_icons")
        private List<String> weatherIcons;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

        @JsonProperty()
        private Astro astro;

        @JsonProperty("air_quality")
        private AirQuality airQuality;

        @JsonProperty("wind_speed")
        private int windSpeed;

        @JsonProperty("wind_degree")
        private  int windDegree;

        @JsonProperty("wind_dir")
        private String windDir;
        @JsonProperty()
        private int pressure;
        @JsonProperty()
        private double precip;
        @JsonProperty()
        private int humidity;
        @JsonProperty()
        private int cloudcover;
        @JsonProperty()
        private int feelslike;
        @JsonProperty("uv_index")
        private int uvIndex;
        @JsonProperty()
        private int visibility;
        @JsonProperty("is_day")
        private String isDay;
    }

    @Getter
    @Setter
    public static class Location{
        @JsonProperty()
        private String name;
        @JsonProperty()
        private String country;
        @JsonProperty()
        private String region;
        @JsonProperty()
        private String lat;
        @JsonProperty()
        private String lon;
        @JsonProperty("timezone_id")
        private String timezoneId;

        @JsonProperty()
        private String localtime;
        @JsonProperty("localtime_epoch")
        private int localtimeEpoch;

        @JsonProperty("utc_offset")
        private String utcOffset;
    }

    @Getter
    @Setter
    public static  class Request{
        @JsonProperty()
        private String type;
        @JsonProperty()
        private String query;
        @JsonProperty()
        private String language;
        @JsonProperty()
        private String unit;
    }
}




