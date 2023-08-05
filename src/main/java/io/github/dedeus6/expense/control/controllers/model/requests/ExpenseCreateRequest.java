package io.github.dedeus6.expense.control.controllers.model.requests;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static io.github.dedeus6.expense.control.constants.Constants.DATE_TIME_STRING_PATTERN;
import static io.github.dedeus6.expense.control.constants.Errors.*;

@Data
@NoArgsConstructor
public class ExpenseCreateRequest {

    @NotBlank(message = REQUIRED_TITLE)
    private String title;

    @Max(value = 200, message = MAX_LIMIT_DESCRIPTION_SIZE)
    private String description;

    @NotNull(message = REQUIRED_DATE_TO_PAY)
    @DateTimeFormat(pattern = DATE_TIME_STRING_PATTERN)
    private LocalDateTime dateToPay;

    @NotNull(message = REQUIRED_VALUE)
    @Digits(integer = 10, fraction = 2, message = INVALID_VALUE_FORMAT)
    private BigDecimal value;

}
