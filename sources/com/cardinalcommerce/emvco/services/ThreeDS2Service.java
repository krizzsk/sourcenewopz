package com.cardinalcommerce.emvco.services;

import android.content.Context;
import com.cardinalcommerce.emvco.parameters.ConfigParameters;
import com.cardinalcommerce.p060a.setMinEms;
import com.cardinalcommerce.shared.models.Warning;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.cardinalcommerce.shared.models.exceptions.SDKNotInitializedException;
import com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import java.util.List;

public interface ThreeDS2Service {
    void cleanup(Context context) throws SDKNotInitializedException;

    Transaction createTransaction(String str) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException;

    Transaction createTransaction(String str, String str2) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException;

    String getSDKVersion() throws SDKNotInitializedException, SDKRuntimeException;

    List<Warning> getWarnings();

    void initialize(Context context, ConfigParameters configParameters) throws InvalidInputException, setMinEms, SDKRuntimeException;

    void initialize(Context context, ConfigParameters configParameters, String str, UiCustomization uiCustomization) throws InvalidInputException, setMinEms, SDKRuntimeException;
}
