package com.sophos.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sophos.dev.model.CapturaDTO;
import com.sophos.dev.validator.ValidatorConverter;

@RestController
@RequestMapping("/apiv1/images")
public class ImageController {

	@Autowired
	private ValidatorConverter validatorConverter;

	public Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping
	public ResponseEntity<?> uploadInfo(@RequestParam("model") String model,
			@RequestParam(value = "file", required = false) MultipartFile file) {

		CapturaDTO capturaDTO = validatorConverter.validateModel(model, CapturaDTO.class);

		logger.info("Model {}", capturaDTO);
		logger.info("file {}", file != null ? file.toString() : "No file");

		return ResponseEntity.ok().build();
	}

}
