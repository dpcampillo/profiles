package com.sophos.dev.validator;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.dev.exception.CustomValidationException;

public class ValidatorConverter {

	private ValidatorFactory validatorFactory;
	private Validator validator;

	public ValidatorConverter() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.usingContext().getValidator();
	}

	public <T> T validateModel(String model, Class<T> classModel) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			T value = objectMapper.readValue(model, classModel);
			Set<ConstraintViolation<T>> constrains = validator.validate(value);
			if (!constrains.isEmpty()) {
				throw new CustomValidationException(constrains.stream()
						.map(constrain -> "[" + constrain.getPropertyPath() + "][" + constrain.getMessage() + "]")
						.collect(Collectors.toList()).toString());
			}
			return value;
		} catch (Exception e) {
			throw new CustomValidationException(e.getMessage());
		}
	}

}
