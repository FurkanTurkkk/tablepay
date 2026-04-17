package com.furkan.tablepay.application.port.out;

import com.furkan.tablepay.domain.model.Table;
import com.furkan.tablepay.domain.valueobject.TableId;

import java.util.List;
import java.util.Optional;

public interface TableQueryPort {
    Optional<Table> findById(TableId id);
    Optional<Table> findByNumber(String number);
    List<Table> findAllTable();
}
