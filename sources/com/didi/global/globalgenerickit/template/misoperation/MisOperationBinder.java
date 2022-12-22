package com.didi.global.globalgenerickit.template.misoperation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.globalgenerickit.CommonEventListener;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.template.yoga.CDNTemplateBinder;
import com.didi.global.globalgenerickit.template.yoga.XMLCacheEntity;
import com.taxis99.R;

public class MisOperationBinder extends CDNTemplateBinder {

    /* renamed from: a */
    private CommonEventListener f22195a;

    public void onCDNCached(XMLCacheEntity xMLCacheEntity) {
    }

    public void setEventListener(CommonEventListener commonEventListener) {
        this.f22195a = commonEventListener;
    }

    public View createView(Context context, GGKData gGKData) {
        View createView = super.createView(context, gGKData);
        if (createView != null) {
            return createView;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.oc_x_panel_operation_view, (ViewGroup) null, false);
        inflate.setTag(R.id.kit_holder, new C8592a(inflate, createEventListener(gGKData)));
        return inflate;
    }

    public void bind(View view, GGKData gGKData) {
        MisOperationData misOperationData = new MisOperationData(gGKData);
        Object tag = view.getTag(R.id.kit_holder);
        if (tag instanceof C8592a) {
            ((C8592a) tag).mo66615c(misOperationData);
        }
    }
}
