package com.n26.statistics.model;

/**
 * Response object
 * 
 * @author rperiasamy
 *
 */
public class StatisticsResponse {
	private Double sum = new Double(0);
	private Double avg = new Double(0);
	private Double min = new Double(0);
	private Double max = new Double(0);
	private Long count = new Long(0);

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
