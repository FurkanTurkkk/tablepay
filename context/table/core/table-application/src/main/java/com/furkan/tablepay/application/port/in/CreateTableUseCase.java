package com.furkan.tablepay.application.port.in;

import com.furkan.tablepay.application.dto.command.CreateTableCommand;
import com.furkan.tablepay.application.dto.result.CreateTableResult;
import com.furkan.tablepay.domain.valueobject.TableId;

public interface CreateTableUseCase {
    CreateTableResult execute(CreateTableCommand cmd);
}
