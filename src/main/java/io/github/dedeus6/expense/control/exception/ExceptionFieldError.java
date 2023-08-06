package io.github.dedeus6.expense.control.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionFieldError {

    public ExceptionFieldError(String error) {
        this.error = error;
    }

    private String field;

    private String error;
}
