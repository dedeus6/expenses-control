package io.github.dedeus6.expense.control.controllers;


import io.github.dedeus6.expense.control.controllers.model.requests.ExpenseCreateRequest;
import io.github.dedeus6.expense.control.controllers.model.responses.ExpenseCreateResponse;
import io.github.dedeus6.expense.control.mapper.ExpenseMapper;
import io.github.dedeus6.expense.control.services.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/expenses")
@RequiredArgsConstructor
@Validated
public class ExpensesController {

    private final ExpenseService expenseService;
    private final ExpenseMapper expenseMapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<ExpenseCreateResponse> createExpense(@Valid @RequestBody ExpenseCreateRequest request) {
        return Mono.just(request)
                .map(expenseMapper::createRequestToDto)
                .flatMap(expenseService::createExpense)
                .map(expenseMapper::dtoToResponse);
    }

}
