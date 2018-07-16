package com.n26.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.statistics.model.StatisticsResponse;
import com.n26.statistics.service.IStatisticsService;

@RestController
public class StatisticsController {

	@Autowired
	private IStatisticsService statisticsService;

	@GetMapping("/statistics")
	public StatisticsResponse getStatistics() {
		return statisticsService.getStatisticsResponse();
	}

}
