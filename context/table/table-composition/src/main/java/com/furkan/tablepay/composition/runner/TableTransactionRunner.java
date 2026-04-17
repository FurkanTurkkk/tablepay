package com.furkan.tablepay.composition.runner;

import com.furkan.tablepay.application.dto.command.CreateTableCommand;
import com.furkan.tablepay.application.dto.result.CreateTableResult;
import com.furkan.tablepay.application.port.in.CreateTableUseCase;
import org.springframework.transaction.annotation.Transactional;

public class TableTransactionRunner {

    @Transactional
    public CreateTableResult delegate(CreateTableUseCase useCase, CreateTableCommand cmd) {
        return useCase.execute(cmd);
    }
}
