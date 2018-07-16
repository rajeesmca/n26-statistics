package com.n26.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.statistics.model.Transaction;
import com.n26.statistics.service.ITransactionService;
import com.n26.statistics.storage.TransactionStorageUtil;

@Service("transactionService")
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	private TransactionStorageUtil storageUtil;
	
	public void addTransaction(Transaction transaction) {
		storageUtil.put(transaction);
	}

	
}
