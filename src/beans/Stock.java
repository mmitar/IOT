package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * IEX Stock Model to consume JSON from API. 11 properties.
 * @author Matthew & Joey
 *
 */
@ManagedBean
@ViewScoped
public class Stock {
	
	String symbol;
	String date;
	float open;
	float high;
	float low;
	float close;
	float volume;
	float unadjustedVolume;
	float change;
	float changePercent;
	float vwap;
	
	public Stock(String symbol, String date, float open, float high, float low, float close, float volume, float unadjustedVolume,
			float change, float changePercent, float vwap) {
		super();
		this.symbol = symbol;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.unadjustedVolume = unadjustedVolume;
		this.change = change;
		this.changePercent = changePercent;
		this.vwap = vwap;
	}
	
	public Stock() {
		symbol = "";
		date = "";
		open = 0;
		high = 0;
		low = 0;
		close = 0;
		volume = 0;
		unadjustedVolume = 0;
		change = 0;
		changePercent = 0;
		vwap = 0;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public float getUnadjustedVolume() {
		return unadjustedVolume;
	}
	public void setUnadjustedVolume(float unadjustedVolume) {
		this.unadjustedVolume = unadjustedVolume;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
	public float getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(float changePercent) {
		this.changePercent = changePercent;
	}
	public float getVwap() {
		return vwap;
	}
	public void setVwap(float vwap) {
		this.vwap = vwap;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", date=" + date + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", volume=" + volume + ", unadjustedVolume=" + unadjustedVolume + ", change="
				+ change + ", changePercent=" + changePercent + ", vwap=" + vwap + "]";
	}
	
}
