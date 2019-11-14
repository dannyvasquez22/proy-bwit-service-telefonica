package com.bwit.service.telefonica.expose;

import com.bwit.service.telefonica.business.TelefonicaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TelefonicaControllerTest {

	@InjectMocks
	private TelefonicaController controller;

	@Mock
	private TelefonicaService service;

	@Test
	public void testCase(){

	}

}
