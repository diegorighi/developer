package br.com.developer.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.developer.dto.ErrorDTO;

@RestControllerAdvice
public class InterceptErrorHandler {

	@Autowired
	private MessageSource message; 
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDTO> handler(MethodArgumentNotValidException exception){
		List<ErrorDTO> dto = new ArrayList<ErrorDTO>();
		List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
		
		fieldError.stream().forEach( e -> {
			String msg = message.getMessage(e, LocaleContextHolder.getLocale());
			ErrorDTO error = new ErrorDTO(e.getField(), msg);
			dto.add(error);
		});
		
		return dto;
	}
}
