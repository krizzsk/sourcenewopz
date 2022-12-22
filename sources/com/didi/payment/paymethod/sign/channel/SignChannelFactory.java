package com.didi.payment.paymethod.sign.channel;

import android.content.Context;
import com.didi.payment.paymethod.sign.channel.impl.CreditCardImpl;
import com.didi.payment.paymethod.sign.channel.impl.EmptyPayImpl;
import com.didi.payment.paymethod.sign.channel.impl.NewPayPalImpl;
import com.didi.payment.paymethod.sign.channel.impl.PayPayImpl;

public class SignChannelFactory {
    private SignChannelFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static ISignChannel createSignChannel(Context context, int i) {
        if (i == 150) {
            return new CreditCardImpl(context);
        }
        if (i != 192) {
            return new EmptyPayImpl();
        }
        return new CreditCardImpl(context, 192);
    }

    public static ISimpleSignChannel createSimpleSignChannel(int i) {
        if (i == 182) {
            return new PayPayImpl();
        }
        if (i != 183) {
            return new PayPayImpl();
        }
        return new NewPayPalImpl();
    }
}
