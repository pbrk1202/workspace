package com.pbrk.pbook.dao.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pbrk.pbook.dao.web.NoticeDao;

@SpringBootTest
class MybatisNoticeDaoTest {

	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	void test() {
//		List<NoticeView> list = noticeDao.getNoticeView(0, 1, null, null, false);
		
//		System.out.println(list.get(0));
	}

}
