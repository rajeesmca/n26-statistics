package com.n26.statistics.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.statistics.model.StatisticsResponse;
import com.n26.statistics.model.Transaction;
import com.n26.statistics.service.ITransactionService;

@RestController
public class TransactionController  {
	
	@Autowired
	private ITransactionService service;

	@PostMapping("/transaction")
	public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction) {
		if(validateTransaction(transaction)){
			service.addTransaction(transaction);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	private boolean validateTransaction(Transaction transaction) {
		Date currDate = localToGMT();
		Date date = new Date(transaction.getTimestamp().longValue());
		System.out.println("Input date time:"+ date.getTime());
		System.out.println("Current date time:"+currDate.getTime());
		if (date.getTime() < currDate.getTime()
				&& date.getTime() > (currDate.getTime() - 60000)) {
			return true;
		}
		return false;
	}

	public Date localToGMT() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gmt = new Date(sdf.format(date));
		return gmt;
	}
	
	public static void main(String[] args) {
		System.out.println(TimeUnit.MILLISECONDS.toMillis(1000));
	}

}
