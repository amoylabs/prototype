package com.bn.global;

import com.bn.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({Exception.class, Error.class})
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        handleRequestInfoLogging(ex, request);
        ErrorResponse error = new ErrorResponse("Server Error", List.of(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        handleRequestInfoLogging(ex, request);
        ErrorResponse error = new ErrorResponse("Record Not Found", List.of(ex.getLocalizedMessage()));
        ResponseStatus status = ex.getClass().getAnnotation(ResponseStatus.class);
        return new ResponseEntity<>(error, status.value());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ErrorResponse error = new ErrorResponse("Validation Errors", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private void handleRequestInfoLogging(Exception ex, WebRequest webRequest) {
        if (webRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) webRequest;
            log.error("Global exception handling: {} - {}", ex.getMessage(), request.getRequestURL());
            // Map<String, String[]> parameters = request.getParameterMap();
            // log.error("Request Parameters：{}", JSONUtil.toJsonStr(parameters));
            log.error(ex.getMessage(), ex);
        }
    }
}
