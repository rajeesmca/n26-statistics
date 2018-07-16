package com.n26.statistics.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Request Object
 * 
 * @author rperiasamy
 *
 */
public class Transaction {
	private Double amount;
	private Long timestamp;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public boolean isValid() {
		Long currentTime=localToGMT().getTime();
		System.out.println("Current Time: "+ currentTime);
		System.out.println("Current time 1 min less: "+(currentTime - 60000));
		System.out.println("Object timestamp: "+this.timestamp);
        return ((currentTime - 60000) < this.timestamp && this.timestamp < currentTime);
    }
	
	public Date localToGMT() {
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
	    Date gmt = new Date(sdf.format(date));
	    return gmt;
	}
	

}
