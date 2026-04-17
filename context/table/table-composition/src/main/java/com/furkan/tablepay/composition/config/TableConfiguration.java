package com.furkan.tablepay.composition.config;

import com.furkan.tablepay.application.port.in.CreateTableUseCase;
import com.furkan.tablepay.application.port.out.TableCommandPort;
import com.furkan.tablepay.application.service.CreateTableService;
import com.furkan.tablepay.composition.decorator.TransactionalCreateTableUseCase;
import com.furkan.tablepay.composition.runner.TableTransactionRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableConfiguration {

    @Bean
    public CreateTableUseCase createTableUseCase(
            TableCommandPort commandPort,
            TableTransactionRunner runner
    ) {
        CreateTableUseCase service = new CreateTableService(commandPort);
        return new TransactionalCreateTableUseCase(service,runner);
    }

    @Bean
    public TableTransactionRunner tableTransactionRunner() {
        return new TableTransactionRunner();
    }
}
