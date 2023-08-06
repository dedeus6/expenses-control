package io.github.dedeus6.expense.control.controllers.model.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dedeus6.expense.control.enums.ExpenseCategoryEnum;
import io.github.dedeus6.expense.control.enums.ExpenseStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpenseCreateResponse {

    private String id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateToPay;
    private LocalDateTime paymentDate;
    private BigDecimal value;
    private ExpenseStatusEnum status;
    private String category;

}
