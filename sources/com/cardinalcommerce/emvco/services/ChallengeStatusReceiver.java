package com.cardinalcommerce.emvco.services;

import com.cardinalcommerce.emvco.events.CompletionEvent;
import com.cardinalcommerce.emvco.events.ProtocolErrorEvent;
import com.cardinalcommerce.emvco.events.RuntimeErrorEvent;

public interface ChallengeStatusReceiver {
    void cancelled();

    void completed(CompletionEvent completionEvent);

    void protocolError(ProtocolErrorEvent protocolErrorEvent);

    void runtimeError(RuntimeErrorEvent runtimeErrorEvent);

    void timedout();
}
