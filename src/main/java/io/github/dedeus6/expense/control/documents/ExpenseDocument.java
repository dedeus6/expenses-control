package io.github.dedeus6.expense.control.documents;

import io.github.dedeus6.expense.control.enums.ExpenseStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@ToString
@Document(collection = "expenses")
public class ExpenseDocument {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dateToPay;
    private LocalDateTime paymentDate;
    private BigDecimal value;
    private ExpenseStatusEnum status;

}
