package com.didi.dimina.starbox.module.jsbridge.bridgelog;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.messager.MessageHandler;
import com.didi.dimina.starbox.module.jsbridge.bridgelog.CheckBoxItemAdapter;
import com.didi.dimina.starbox.p107ui.base.BaseFragment;
import com.taxis99.R;

public class NativeBridgeSettingFragment extends BaseFragment {

    /* renamed from: a */
    private RecyclerView f18054a;

    /* renamed from: b */
    private CheckBoxItemAdapter f18055b;

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return R.layout.dimina_starbox_fragment_log_info_setting;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m13479a();
    }

    /* renamed from: a */
    private void m13479a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.setting_list);
        this.f18054a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f18055b = new CheckBoxItemAdapter(getContext());
        boolean booleanValue = ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_ALL_BRIDGE_LISTENER, false)).booleanValue();
        this.f18055b.append(new CheckBoxItem(R.string.dm_kit_engine_first_dom_ready_native_bridge_log_info, ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER, false)).booleanValue()));
        this.f18055b.append(new CheckBoxItem(R.string.dm_kit_engine_all_native_bridge_log_info, booleanValue));
        this.f18055b.setOnCheckBoxItemSwitchListener(new CheckBoxItemAdapter.OnCheckBoxItemSwitchListener() {
            public void onSettingItemSwitch(CheckBoxItem checkBoxItem, boolean z) {
                if (checkBoxItem.desc == R.string.dm_kit_engine_all_native_bridge_log_info) {
                    MMKVUtil.getInstance().save(MessageHandler.PARAM_ENABLE_ALL_BRIDGE_LISTENER, Boolean.valueOf(z));
                    MessageHandler.sEnableAllBridgeListener = true;
                }
                if (checkBoxItem.desc == R.string.dm_kit_engine_first_dom_ready_native_bridge_log_info) {
                    MMKVUtil.getInstance().save(MessageHandler.PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER, Boolean.valueOf(z));
                    MessageHandler.sEnableFirstDomReadyBridgeListener = true;
                }
            }
        });
        this.f18054a.setAdapter(this.f18055b);
        this.f18055b.notifyDataSetChanged();
    }
}
