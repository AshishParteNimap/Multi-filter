package com.MultipleFilter.Exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		ExceptionDto entity = new ExceptionDto();
		entity.setMessage("something went wrong");
		entity.setRequestUrl(((ServletWebRequest) request).getRequest().getRequestURL().toString());
		entity.setRequestMethod(((ServletWebRequest) request).getRequest().getMethod());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(entity);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseDto handleValidatioinException(final MethodArgumentNotValidException exception) {

		List<String> details = new ArrayList<>();

		for (ObjectError error : exception.getBindingResult().getAllErrors()) {

			details.add(error.getDefaultMessage());

		}

		ResponseDto error = new ResponseDto();
		error.setMessage(details.get(0).split("\\*", 2)[0]);
		error.setMsgKey(details.get(0).split("\\*", 2)[1]);
		return error;

	}
}
