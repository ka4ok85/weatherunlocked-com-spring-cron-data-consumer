package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Call;

@Service
public class AMQPHandler {

    private static final Logger log = LoggerFactory.getLogger(AMQPHandler.class);
    
    @Autowired
    private TestService testService; 

    @StreamListener("input")
    //@Transactional
    public void process(Call call) throws Exception {
      
    	//double x = Math.random();
    	System.out.println(call.toString());
    	log.debug(call.toString());
    	
    	testService.run(call);
    	
    	
    	//System.out.println(x);
    	//if (x > 0.5) {
    		//throw new Exception("test exception");
    	//}
    	
    	//LOGGER.info("Handling work unit - id: {}, definition: {}", workUnit.getId(), workUnit.getDefinition());
    }
}