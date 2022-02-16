package com.example.demo.service;
import com.example.demo.model.OrderDiscount;
import com.example.demo.model.OrderRequest;
import org.jvnet.hk2.annotations.Service;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;



@Service
	public class OrderDiscountService {
	 
	    @Autowired
	    private KieContainer kieContainer;
	 
	    public OrderDiscount getDiscount(OrderRequest orderRequest) {
	        OrderDiscount orderDiscount = new OrderDiscount();
	        KieSession kieSession = kieContainer.newKieSession();
	        kieSession.setGlobal("orderDiscount", orderDiscount);
	        kieSession.insert(orderRequest);
	        kieSession.fireAllRules();
	        kieSession.dispose();
	        return orderDiscount;
	    }
	}
