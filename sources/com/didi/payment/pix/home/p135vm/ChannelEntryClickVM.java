package com.didi.payment.pix.home.p135vm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.pix.home.PixChannelResp;

/* renamed from: com.didi.payment.pix.home.vm.ChannelEntryClickVM */
public class ChannelEntryClickVM extends AndroidViewModel {
    public MutableLiveData<PixChannelResp.ChannelEntry> pixChannel = new MutableLiveData<>();

    public ChannelEntryClickVM(Application application) {
        super(application);
    }
}
