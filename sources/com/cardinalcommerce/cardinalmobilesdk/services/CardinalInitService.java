package com.cardinalcommerce.cardinalmobilesdk.services;

import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;

public interface CardinalInitService {
    void onSetupCompleted(String str);

    void onValidated(ValidateResponse validateResponse, String str);
}
