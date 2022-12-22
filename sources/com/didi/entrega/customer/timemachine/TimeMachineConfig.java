package com.didi.entrega.customer.timemachine;

import java.util.List;

public interface TimeMachineConfig {
    String getCurrentPage();

    List<String> traceDomainList();
}
