package com.didi.payment.paymethod.open.param;

import java.io.Serializable;

public class CancelSignParam implements Serializable {
    public int channelId;
    public int cmbParam = 0;
    public String email;
}
