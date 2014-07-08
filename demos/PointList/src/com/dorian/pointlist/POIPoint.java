package com.dorian.pointlist;

public class POIPoint {
	public long lon;
	public long lat;
	public String name;
	
	POIPoint() {
		lon = 0;
		lat = 0;
		name = "";
	}
	
	POIPoint(long lon, long lat, String name) {
		this.lon = lon;
		this.lat = lat;
		this.name = name;
	}
}