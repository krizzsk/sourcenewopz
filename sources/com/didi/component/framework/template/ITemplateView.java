package com.didi.component.framework.template;

import android.os.Bundle;
import com.didi.component.core.IGroupView;

public interface ITemplateView extends IGroupView {
    boolean hideComponentView();

    void hideSugPageContainer();

    void showComponentView(Bundle bundle);

    void showSugPageContainer();
}
