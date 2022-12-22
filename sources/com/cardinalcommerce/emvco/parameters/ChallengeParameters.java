package com.cardinalcommerce.emvco.parameters;

import com.cardinalcommerce.p060a.setMinLines;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;

public class ChallengeParameters {

    /* renamed from: a */
    private String f3259a;

    /* renamed from: b */
    private String f3260b;

    /* renamed from: c */
    private String f3261c;

    /* renamed from: d */
    private String f3262d;

    /* renamed from: e */
    private String f3263e;

    public ChallengeParameters() {
    }

    public ChallengeParameters(String str, String str2, String str3, String str4) throws InvalidInputException {
        if (!str.isEmpty()) {
            this.f3261c = str;
            if (!str2.isEmpty()) {
                this.f3259a = str2;
                if (!str3.isEmpty()) {
                    this.f3262d = str3;
                    if (!str4.isEmpty()) {
                        this.f3260b = str4;
                        return;
                    }
                    throw m2224a("threeDSServerTransactionID");
                }
                throw m2224a("acsRefNumber");
            }
            throw m2224a("acsSignedContent");
        }
        throw m2224a("acsTransactionID");
    }

    /* renamed from: a */
    private InvalidInputException m2224a(String str) {
        StringBuilder sb = new StringBuilder("Caught in ");
        sb.append(getClass().getName());
        sb.append("\n Invalid ");
        sb.append(str);
        return new InvalidInputException("InvalidInputException", new Throwable(sb.toString()));
    }

    public String getAcsSignedContent() {
        return this.f3259a;
    }

    public String get3DSServerTransactionID() {
        return this.f3260b;
    }

    public String getAcsTransactionID() {
        return this.f3261c;
    }

    public String getAcsRefNumber() {
        return this.f3262d;
    }

    public void setAcsSignedContent(String str) {
        if (!str.isEmpty()) {
            this.f3259a = str;
            return;
        }
        throw m2224a(str);
    }

    public void set3DSServerTransactionID(String str) {
        if (!str.isEmpty()) {
            this.f3260b = str;
            return;
        }
        throw m2224a("On set3DSServerTransactionID");
    }

    public void setAcsTransactionID(String str) {
        if (str.isEmpty() || this.f3262d.length() <= 0) {
            throw m2224a("On setAcsTransactionID");
        }
        this.f3261c = str;
    }

    public void setAcsRefNumber(String str) {
        if (!str.isEmpty()) {
            this.f3262d = str;
            return;
        }
        throw m2224a("On setAcsRefNumber");
    }

    public void setThreeDSRequestorAppURL(String str) {
        if (setMinLines.configure(str, 256)) {
            this.f3263e = str;
            return;
        }
        throw m2224a("On setThreeDSRequestorAppURL");
    }

    public String getThreeDSRequestorAppURL() {
        return this.f3263e;
    }
}
