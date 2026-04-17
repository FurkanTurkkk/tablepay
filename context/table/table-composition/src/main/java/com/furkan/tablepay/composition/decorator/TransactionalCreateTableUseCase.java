package com.furkan.tablepay.composition.decorator;

import com.furkan.tablepay.application.dto.command.CreateTableCommand;
import com.furkan.tablepay.application.dto.result.CreateTableResult;
import com.furkan.tablepay.application.port.in.CreateTableUseCase;
import com.furkan.tablepay.composition.runner.TableTransactionRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

public class TransactionalCreateTableUseCase implements CreateTableUseCase {

    private static final Logger log = LoggerFactory.getLogger(TransactionalCreateTableUseCase.class);
    private final CreateTableUseCase createTableUseCase;
    private final TableTransactionRunner runner;

    public TransactionalCreateTableUseCase(CreateTableUseCase createTableUseCase, TableTransactionRunner runner) {
        this.createTableUseCase = createTableUseCase;
        this.runner = runner;
    }

    @Override
    public CreateTableResult execute(CreateTableCommand cmd) {
        log.info("Table creation process started with table number = {}", cmd.number());
        try{
            CreateTableResult result = runner.delegate(createTableUseCase, cmd);
            log.info("Table created successfully. Table id = {}", result.tableId());
            return result;
        }catch (DataIntegrityViolationException e) {
            log.error("Table couldn't create");
            throw new RuntimeException("Add new exception type");
        }
    }
}
