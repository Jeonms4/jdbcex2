package com.green.jdbcex.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@ToString
@Builder
public class TodoVO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
