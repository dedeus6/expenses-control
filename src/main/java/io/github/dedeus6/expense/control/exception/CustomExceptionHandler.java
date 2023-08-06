package io.github.dedeus6.expense.control.exception;

import jakarta.validation.ConstraintDeclarationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler({BusinessException.class})
//    public Mono<ResponseEntity<ExceptionResponse>> handleBusinessException
//            (final BusinessException ex) {
//        return this.getExceptionResponse(ex.getStatus(),  ex.getError());
//    }

    @ExceptionHandler({ConstraintDeclarationException.class})
    public Mono<ResponseEntity<ExceptionResponse>> handleBusinessException
            (final ConstraintDeclarationException ex) {
        return this.getExceptionResponse(BAD_REQUEST,  ex.getMessage());
    }

    @ExceptionHandler({ServerWebInputException.class})
    public Mono<ResponseEntity<ExceptionResponse>> handleServerWebInputException
            (final ServerWebInputException ex) {
        return this.getExceptionResponse(BAD_REQUEST,  ex.getReason());
    }

    @ExceptionHandler({WebExchangeBindException.class})
    public Mono<ResponseEntity<ExceptionResponse>> handleWebExchange
            (final WebExchangeBindException ex) {
        var errors = ex.getFieldErrors().stream()
                .map(e -> new ExceptionFieldError(e.getField(), e.getDefaultMessage()))
                .collect(Collectors.toList());
        return this.getExceptionResponse(BAD_REQUEST, errors);
    }

    private Mono<ResponseEntity<ExceptionResponse>> getExceptionResponse
            (final HttpStatus status, final String message) {
        final var response = ExceptionResponse.builder()
                .messages(of(new ExceptionFieldError(message)))
                .status(status.value())
                .timestamp(LocalDateTime.now().toString())
                .build();
        return Mono.just(ResponseEntity.status(status).body(response));
    }

    private Mono<ResponseEntity<ExceptionResponse>> getExceptionResponse
            (final HttpStatus status, final List<ExceptionFieldError> messages) {
        final var response = ExceptionResponse.builder()
                .messages(messages)
                .status(status.value())
                .timestamp(LocalDateTime.now().toString())
                .build();
        return Mono.just(ResponseEntity.status(status).body(response));
    }

}
