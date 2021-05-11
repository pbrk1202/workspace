package com.pbrk.pbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.service.web.NoticeService;

@SpringBootTest
class NoticeServiceImpTest {
	
	@Autowired
	private NoticeService service;
	
	@Test
	void test() {
		//int[] intVal = {1,3};
		//System.out.println(service.updatePubAll(intVal,true));
				
//		System.out.println(service.getNoticeView(true));
	}

}
