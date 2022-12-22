package com.didi.component.messagebar.model;

import java.io.Serializable;

public class MessageBarConditions implements Serializable {
    public int driverMovingException;

    public int getDriverMovingException() {
        return this.driverMovingException;
    }

    public void setDriverMovingException(int i) {
        this.driverMovingException = i;
    }
}
