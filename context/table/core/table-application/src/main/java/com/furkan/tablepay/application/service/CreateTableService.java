package com.furkan.tablepay.application.service;

import com.furkan.tablepay.application.dto.command.CreateTableCommand;
import com.furkan.tablepay.application.dto.result.CreateTableResult;
import com.furkan.tablepay.application.port.in.CreateTableUseCase;
import com.furkan.tablepay.application.port.out.TableCommandPort;
import com.furkan.tablepay.domain.model.Table;
import com.furkan.tablepay.domain.valueobject.TableId;

public class CreateTableService implements CreateTableUseCase {
    private final TableCommandPort commandPort;

    public CreateTableService(TableCommandPort commandPort) {
        this.commandPort = commandPort;
    }

    @Override
    public CreateTableResult execute(CreateTableCommand cmd) {
        TableId id = commandPort.save(Table.create(TableId.random(), cmd.number(), cmd.capacity()));
        return new CreateTableResult(id.asString());
    }
}
