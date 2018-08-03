package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.*;
import com.example.service.StockPriceService;
import com.example.utility.Utils;

import reactor.core.publisher.Flux;

@RestController
public class SSEController {

	private List<StockPrice> stockPriceList = new ArrayList<>();
	@Autowired
	private Utils utils;
	@Autowired
	private StockPriceService stockPriceService;

	@PostConstruct
	public void initializeStockObject() {
		StockPrice stock1 = new StockPrice("Raifaisen", utils.getRandomDoubleBetweenRange(1000, 5000),
				utils.getRandomDoubleBetweenRange(5, 15), utils.getRandomDoubleBetweenRange(1000, 5000),
				utils.getStatus());

		StockPrice stock2 = new StockPrice("Credins", utils.getRandomDoubleBetweenRange(1000, 5000),
				utils.getRandomDoubleBetweenRange(5, 15), utils.getRandomDoubleBetweenRange(1000, 5000),
				utils.getStatus());

		StockPrice stock3 = new StockPrice("Societte", utils.getRandomDoubleBetweenRange(1000, 5000),
				utils.getRandomDoubleBetweenRange(5, 15), utils.getRandomDoubleBetweenRange(1000, 5000),
				utils.getStatus());
	
	stockPriceList.add(stock1);
	stockPriceList.add(stock2);
	stockPriceList.add(stock3);
	
	}
	
	@RequestMapping(value="/stockprice", method=RequestMethod.GET, produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<List<StockPrice>>getStockPrice(){
		return stockPriceService.getStockPriceData(stockPriceList);
	}
}
