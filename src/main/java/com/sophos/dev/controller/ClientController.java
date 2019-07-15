package com.sophos.dev.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiv1/clients")
public class ClientController {

	@GetMapping
	public List<String> findAllClients() {
		return Arrays.asList("Dario", "Juan", "Carlos");
	}

}
