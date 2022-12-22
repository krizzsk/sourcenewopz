package com.didi.component.imentrance;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.imentrance.impl.IMEntranceV2FarView;
import com.didi.component.imentrance.impl.IMEntranceV2NearView;
import com.didi.component.imentrance.impl.IMEntranceV2Presenter;
import com.didiglobal.component.imentrance.view.IMEntranceV2SmallView;
import com.didiglobal.travel.util.Preconditions;

@ComponentRegister(product = "ride", type = "im_entrnace")
public class IMEntranceComponent extends BaseComponent<IIMEntranceView, AbsIMEntrancePresenter> {
    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        super.init(componentParams, viewGroup);
        IIMEntranceView iIMEntranceView = (IIMEntranceView) getView();
        AbsIMEntrancePresenter absIMEntrancePresenter = (AbsIMEntrancePresenter) getPresenter();
        if (Preconditions.nonNull(iIMEntranceView) && Preconditions.nonNull(absIMEntrancePresenter)) {
            iIMEntranceView.setOnIMEntranceClickListener(absIMEntrancePresenter);
        }
    }

    /* access modifiers changed from: protected */
    public IIMEntranceView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        String str = (String) componentParams.getExtra("source");
        if (TextUtils.isEmpty(str)) {
            str = "small";
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101143) {
            if (hashCode != 3377192) {
                if (hashCode == 109548807 && str.equals("small")) {
                    c = 2;
                }
            } else if (str.equals("near")) {
                c = 1;
            }
        } else if (str.equals("far")) {
            c = 0;
        }
        if (c == 0) {
            return new IMEntranceV2FarView(componentParams.bizCtx.getContext(), viewGroup);
        }
        if (c != 1) {
            return new IMEntranceV2SmallView(componentParams, componentParams.bizCtx.getContext(), viewGroup);
        }
        return new IMEntranceV2NearView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsIMEntrancePresenter onCreatePresenter(ComponentParams componentParams) {
        return new IMEntranceV2Presenter(componentParams);
    }
}
