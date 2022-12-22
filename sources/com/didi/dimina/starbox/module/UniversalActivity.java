package com.didi.dimina.starbox.module;

import android.os.Bundle;
import android.widget.Toast;
import com.didi.dimina.starbox.module.jsbridge.bridgelog.NativeBridgeSettingFragment;
import com.didi.dimina.starbox.module.jsbridge.fileexplorer.FileExplorerFragment;
import com.didi.dimina.starbox.p107ui.base.BaseActivity;
import com.didi.sdk.apm.SystemUtils;

public class UniversalActivity extends BaseActivity {

    public interface FragmentIndex {
        public static final int FRAGMENT_FILE_EXPLORER = 2;
        public static final String FRAGMENT_INDEX = "fragment_index";
        public static final int FRAGMENT_NATIVE_BRIDGE = 25;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int i = extras.getInt(FragmentIndex.FRAGMENT_INDEX);
        if (i == 0) {
            finish();
            return;
        }
        Class cls = null;
        if (i == 2) {
            cls = FileExplorerFragment.class;
        } else if (i == 25) {
            cls = NativeBridgeSettingFragment.class;
        }
        if (cls == null) {
            finish();
            SystemUtils.showToast(Toast.makeText(this, String.format("fragment index %s not found", new Object[]{Integer.valueOf(i)}), 0));
            return;
        }
        showContent(cls, extras);
    }
}
