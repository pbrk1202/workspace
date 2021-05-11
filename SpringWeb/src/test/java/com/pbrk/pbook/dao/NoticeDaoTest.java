package com.pbrk.pbook.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.pbrk.pbook.dao.web.NoticeDao;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class NoticeDaoTest {

	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	void test() {
//		List<NoticeView> list = noticeDao.getNoticeView(0, 1, null, null, false);
//		List<NoticeView> list= noticeDao.getView(3);
		
//		System.out.println(list.get(0));
	}

}
