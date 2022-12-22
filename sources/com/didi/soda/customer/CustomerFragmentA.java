package com.didi.soda.customer;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "soda", value = {Fragment.class})
public class CustomerFragmentA extends CustomerFragment {
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
