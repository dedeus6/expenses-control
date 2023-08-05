package io.github.dedeus6.expense.control.dto;

import io.github.dedeus6.expense.control.enums.ExpenseStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class ExpenseDTO {
    private String id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateToPay;
    private LocalDateTime paymentDate;
    private BigDecimal value;
    private ExpenseStatusEnum status;
}
