package com.cardinalcommerce.emvco.services;

import android.app.Activity;
import com.cardinalcommerce.emvco.parameters.AuthenticationRequestParameters;
import com.cardinalcommerce.emvco.parameters.ChallengeParameters;
import com.cardinalcommerce.p060a.setEms;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;

public interface Transaction {
    void close();

    void doChallenge(Activity activity, ChallengeParameters challengeParameters, ChallengeStatusReceiver challengeStatusReceiver, int i) throws InvalidInputException;

    AuthenticationRequestParameters getAuthenticationRequestParameters();

    setEms getProgressView(Activity activity) throws InvalidInputException;
}
