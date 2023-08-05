package io.github.dedeus6.expense.control.mapper;

import io.github.dedeus6.expense.control.controllers.model.requests.ExpenseCreateRequest;
import io.github.dedeus6.expense.control.controllers.model.responses.ExpenseCreateResponse;
import io.github.dedeus6.expense.control.documents.ExpenseDocument;
import io.github.dedeus6.expense.control.dto.ExpenseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Component
@Mapper(componentModel = SPRING)
public interface ExpenseMapper {

    ExpenseDTO createRequestToDto(ExpenseCreateRequest request);
    ExpenseCreateResponse dtoToResponse(ExpenseDTO dto);
    ExpenseDocument dtoToDocument(ExpenseDTO dto);

}
