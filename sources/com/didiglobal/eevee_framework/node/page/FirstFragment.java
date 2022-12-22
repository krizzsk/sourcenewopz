package com.didiglobal.eevee_framework.node.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.component.never.base.ForwardOptions;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.node.NodeLaunchMode;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.common.common.never.PageFragmentImpl;
import com.didiglobal.common.common.util.NodeStartUtil;
import com.didiglobal.common.common.xengine.XERequestRecord;
import com.taxis99.R;
import java.util.Map;

@ServiceProvider(alias = "bus", value = {Fragment.class})
public class FirstFragment extends PageFragmentImpl {
    /* access modifiers changed from: protected */
    public Map<String, Object> getComponentExtraParams() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.fragment_page;
    }

    public static PageFragment newInstance() {
        return new FirstFragment();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        forward();
    }

    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getContainerView() != null) {
            return getContainerView();
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(NodeStartUtil.EEVEE_NODE_ID)) {
            arguments.remove(NodeStartUtil.EEVEE_NODE_ID);
        }
        XERequestRecord.getInstance().clean();
    }

    /* access modifiers changed from: protected */
    public ForwardOptions getForwardOptions() {
        return new ForwardOptions("eevee", NodeLaunchMode.PUSH, getArguments());
    }
}
