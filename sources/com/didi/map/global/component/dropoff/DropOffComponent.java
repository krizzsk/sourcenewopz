package com.didi.map.global.component.dropoff;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.dropoff.core.DropOffView;

public class DropOffComponent implements IDropOffCompContract {

    /* renamed from: a */
    private DropOffView f25436a;

    /* renamed from: b */
    private DropOffCompParam f25437b;

    public void stop() {
    }

    public void create(Context context, Map map) {
        DropOffCompParam dropOffCompParam = this.f25437b;
        if (dropOffCompParam != null && dropOffCompParam.getLocationInfo() != null) {
            this.f25436a = new DropOffView(context, map, this.f25437b);
        }
    }

    public void start() {
        DropOffView dropOffView = this.f25436a;
        if (dropOffView != null) {
            dropOffView.start();
        }
    }

    public void setConfigParam(DropOffCompParam dropOffCompParam) {
        this.f25437b = dropOffCompParam;
    }

    public void adjustMapCamera(Padding padding) {
        DropOffView dropOffView = this.f25436a;
        if (dropOffView != null) {
            dropOffView.adjustMapCamera(padding);
        }
    }

    public void destroy() {
        DropOffView dropOffView = this.f25436a;
        if (dropOffView != null) {
            dropOffView.destroy();
        }
    }

    public void onMapVisible(boolean z) {
        DropOffView dropOffView = this.f25436a;
        if (dropOffView != null) {
            dropOffView.onMapVisible(z);
        }
    }
}
