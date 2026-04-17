package com.furkan.tablepay.application.port.out;

import com.furkan.tablepay.domain.model.Table;
import com.furkan.tablepay.domain.valueobject.TableId;

public interface TableCommandPort {
    TableId save(Table table);
    TableId update(Table table);
}
