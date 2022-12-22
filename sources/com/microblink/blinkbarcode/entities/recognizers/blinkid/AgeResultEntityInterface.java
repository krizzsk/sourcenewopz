package com.microblink.blinkbarcode.entities.recognizers.blinkid;

import com.microblink.blinkbarcode.results.date.Date;
import com.microblink.blinkbarcode.results.date.DateResult;
import com.microblink.blinkbarcode.results.date.DateUtils;

/* compiled from: line */
public class AgeResultEntityInterface {
    public static final String CLASS_NAME = "com.microblink.blinkbarcode.entities.recognizers.blinkid.AgeResultEntityInterface";

    public int getAge() {
        Date date = getDateOfBirth().getDate();
        if (date == null) {
            return -1;
        }
        return DateUtils.yearsPassedFrom(date);
    }

    public AgeLimitStatus getAgeLimitStatus(int i) {
        int age = getAge();
        if (age == -1) {
            return AgeLimitStatus.NotAvailable;
        }
        if (age >= i) {
            return AgeLimitStatus.OverAgeLimit;
        }
        return AgeLimitStatus.BelowAgeLimit;
    }

    public DateResult getDateOfBirth() {
        return null;
    }
}
