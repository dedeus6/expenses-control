package io.github.dedeus6.expense.control.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static io.github.dedeus6.expense.control.constants.Constants.DATE_TIME_STRING_PATTERN;

@Builder
@Data
public class ExceptionResponse {
    private Integer status;

    @JsonFormat(pattern = DATE_TIME_STRING_PATTERN)
    private String timestamp;

    private List<ExceptionFieldError> messages;
}
