package io.github.dedeus6.expense.control.services;

import io.github.dedeus6.expense.control.dto.ExpenseDTO;
import io.github.dedeus6.expense.control.mapper.ExpenseMapper;
import io.github.dedeus6.expense.control.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper;

    public Mono<ExpenseDTO> createExpense(ExpenseDTO expense){
        return Mono.just(expense)
                .map(expenseMapper::dtoToDocument)
                .flatMap(expenseRepository::save)
                .map(expenseMapper::documentToDto);
    }
}
