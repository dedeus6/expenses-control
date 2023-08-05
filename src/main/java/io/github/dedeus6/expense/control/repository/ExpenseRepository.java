package io.github.dedeus6.expense.control.repository;

import io.github.dedeus6.expense.control.documents.ExpenseDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends ReactiveMongoRepository<ExpenseDocument, String> {
}
