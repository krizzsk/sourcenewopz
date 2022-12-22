package com.didi.sdk.fastframe.view;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public class InstanceStateFragment extends Fragment {
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        restore(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        restore(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        restore(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C12205a.m25435a(bundle, (Object) this);
    }

    public void restore(Bundle bundle) {
        if (bundle != null) {
            C12205a.m25439b(bundle, this);
        }
    }
}
