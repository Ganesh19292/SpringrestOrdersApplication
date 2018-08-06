package com.ganesh.spring.rest.api.service;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class OrderService {
	HashMap<String, Double> price= new HashMap<>();
	
	public OrderService() {
		//Initializing the prices
		price.put("A", 1.25);
		price.put("B", 4.25);
		price.put("C", 1.00);
		price.put("D", 0.75);
	}
	
	public Double getOrderPrice(String order) {
		
		Double totalprice=null;
		
		// counting the number of orders of A
		int a = StringUtils.countOccurrencesOf(order, "A");
		
		// counting the number of orders of B
		int b = StringUtils.countOccurrencesOf(order, "B");
		
		// counting the number of orders of C
		int c = StringUtils.countOccurrencesOf(order, "C");
		
		// counting the number of orders of D
		int d = StringUtils.countOccurrencesOf(order, "D");
		
		//Calculating price of item A
		Double aPrice=getTotalItemPriceWithOffer("A", a, 3);
		
		//Calculating price of item B
		Double bPrice=getTotalItemPriceWithoutOffer("B", b);
		
		//Calculating price of item C
		Double cPrice=getTotalItemPriceWithOffer("C", c, 6);
		
		//Calculating price of item D
		Double dPrice=getTotalItemPriceWithoutOffer("D", d);
		
		//Calculating total order price
		totalprice=aPrice+bPrice+cPrice+dPrice;
		System.out.println("Total price: "+totalprice);
		return totalprice;
	}
	public Double getTotalItemPriceWithOffer(String item,int itemCount,int offer) {
		int qout=itemCount/offer;
		int rem=itemCount%offer;
		Double rate=null;
		switch (item) {
		case "A":
			//Calculating price of item A
			rate=qout*3+rem*price.get(item);
			break;
		case "C":
			//Calculating price of item C
			rate=qout*5+rem*price.get(item);
			break;
		default:
			break;
		}
		return rate;
	}
	public Double getTotalItemPriceWithoutOffer(String item,int itemcount) {
		//Calculating total price of the items without offer
		return itemcount*price.get(item);
	}


}