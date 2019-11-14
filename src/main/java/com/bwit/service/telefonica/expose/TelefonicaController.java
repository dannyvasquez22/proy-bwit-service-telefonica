package com.bwit.service.telefonica.expose;


import com.bwit.service.telefonica.business.TelefonicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/telefonica")
public class TelefonicaController {

	private TelefonicaService service;

	@Autowired
	public TelefonicaController(TelefonicaService service) {
		this.service = service;
	}
}
