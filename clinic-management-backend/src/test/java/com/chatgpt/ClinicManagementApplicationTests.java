package com.chatgpt;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chatgpt.model.User;
import com.chatgpt.service.ClinicService;

@SpringBootTest
class ClinicManagementApplicationTests {
	@Autowired
	private ClinicService serv;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAuthentication()
	{
		assertNotNull(serv.getAuthenticated("example2", "abc123"));
		//assertDoesNotThrow(Exception.class, serv.getAuthenticated(null, null).toString());
		//assertFalse(serv.getAuthenticated("example", "abc123").isEmpty());
		assertNull(serv.getAuthenticated(null, null));
	}
	
	@Test
	public void testRegister()
	{
		assertEquals("Username already exists", serv.register(new User("example2","example2","abc123")));
		assertNotNull(serv.register(null));
	}
	
	@Test
	public void testHomePageData()
	{
		assertNotNull(serv.getHomePageData());
		assertThatNoException().isThrownBy(()->serv.getHomePageData());
	}

}
