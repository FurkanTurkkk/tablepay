package com.furkan.tablepay.application.dto.command;

public record CreateTableCommand(String number, int capacity) {
    public static CreateTableCommand from(String number, int capacity) {
        return new CreateTableCommand(
                number,
                capacity
        );
    }
}
