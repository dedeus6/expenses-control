package io.github.dedeus6.expense.control.constants;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Errors {
    public static final String REQUIRED_TITLE = "title field is required";
    public static final String REQUIRED_DATE_TO_PAY = "dateToPay field is required";
    public static final String REQUIRED_VALUE = "value field is required";
    public static final String INVALID_VALUE_FORMAT = "value field must have 10 integer numbers and 2 decimal places";
    public static final String MAX_LIMIT_DESCRIPTION_SIZE = "description field must have a maximum of 200 characters";
}
