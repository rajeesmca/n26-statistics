package com.n26.statistics.storage;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.springframework.stereotype.Component;

import com.n26.statistics.model.StatisticsResponse;
import com.n26.statistics.model.Transaction;

@Component("transactionStorageUtil")
public class TransactionStorageUtil {
	private PriorityQueue<Transaction> pQueue = new PriorityQueue<Transaction>(new TransactionCompartor());

	public void put(Transaction trans) {
		pQueue.add(trans);
		System.out.println("Added successfully: " + pQueue.size());
	}

	/**
	 * This will return in O(n)
	 * @return
	 */
	public StatisticsResponse getLast60Seconds() {
		long count=0;
		StatisticsResponse response = new StatisticsResponse();
		for (Transaction transaction : pQueue) {
			if (transaction.isValid()) {
				response.setSum((response.getSum() + transaction.getAmount()));
				response.setMin(
						response.getMin() > transaction.getAmount() ? transaction.getAmount() : response.getMin());
				response.setMax(
						response.getMax() < transaction.getAmount() ? transaction.getAmount() : response.getMax());

				count++;
			} else {
				// The objects will be in timestamp order. So if one object is
				// not eligible then other objects also not eligible
				pQueue.remove();
			}
		}
		if (count > 0) {
			response.setCount(count);
			response.setAvg((response.getSum().doubleValue() / count));
			
		}
		return response;
	}

	class TransactionCompartor implements Comparator<Transaction> {

		public int compare(Transaction o1, Transaction o2) {
			if (o1.getTimestamp() < o2.getTimestamp()) {
				return 1;
			} else if (o1.getTimestamp() > o2.getTimestamp()) {
				return -1;
			}
			return 0;
		}

	}

}
