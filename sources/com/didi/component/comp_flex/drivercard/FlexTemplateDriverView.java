package com.didi.component.comp_flex.drivercard;

import android.content.Context;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.comp_flex.drivercard.DriverItemView;
import com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel;
import com.didi.component.core.event.BaseEventPublisher;
import com.didiglobal.enginecore.template.temp.IXEView;

public class FlexTemplateDriverView implements IXEView<FlexTemplateDriverModel> {

    /* renamed from: a */
    private Context f12172a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DriverItemView f12173b;

    public void initView(Context context) {
        this.f12172a = context;
        DriverItemView driverItemView = new DriverItemView(this.f12172a);
        this.f12173b = driverItemView;
        driverItemView.setListener(new DriverItemView.OnOperationDriverCardListener() {
            public void engineCommit(boolean z) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_FLEX_COMMIT, Boolean.valueOf(z));
            }

            public void removeItem(FlexTemplateDriverModel.TemplateDriverData templateDriverData) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_COMMON_LIST_REMOVE_CARD, FlexTemplateDriverView.this.f12173b);
            }
        });
    }

    public void bindData(FlexTemplateDriverModel flexTemplateDriverModel) {
        if (flexTemplateDriverModel == null || flexTemplateDriverModel.normal == null || flexTemplateDriverModel.normal.data == null) {
            this.f12173b.setVisibility(8);
            return;
        }
        this.f12173b.setVisibility(0);
        this.f12173b.setData(flexTemplateDriverModel.normal.data);
    }

    public View getView() {
        return this.f12173b;
    }
}
