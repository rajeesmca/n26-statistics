package com.n26.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.n26.statistics.model.StatisticsResponse;
import com.n26.statistics.service.IStatisticsService;
import com.n26.statistics.storage.TransactionStorageUtil;

@Component("statisticsService")
public class StatisticsServiceImpl implements IStatisticsService{

	@Autowired
	private TransactionStorageUtil storageUtil;
	
	public StatisticsResponse getStatisticsResponse() {
		return storageUtil.getLast60Seconds();
	}

}
