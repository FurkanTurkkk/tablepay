package com.furkan.tablepay.api.rest;

import com.furkan.tablepay.api.dto.request.CreateTableRequest;
import com.furkan.tablepay.api.dto.response.CreateTableResponse;
import com.furkan.tablepay.application.dto.command.CreateTableCommand;
import com.furkan.tablepay.application.dto.result.CreateTableResult;
import com.furkan.tablepay.application.port.in.CreateTableUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/table")
public class TableController {
    private final CreateTableUseCase createTableUseCase;

    public TableController(CreateTableUseCase createTableUseCase) {
        this.createTableUseCase = createTableUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateTableResponse> createTable(@RequestBody CreateTableRequest request) {
        CreateTableCommand cmd = CreateTableCommand.from(request.number(), request.capacity());
        CreateTableResult result = createTableUseCase.execute(cmd);
        return ResponseEntity.ok(new CreateTableResponse(result.tableId()));
    }

}
