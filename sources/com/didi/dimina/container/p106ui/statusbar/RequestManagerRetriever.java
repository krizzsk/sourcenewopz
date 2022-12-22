package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.ui.statusbar.RequestManagerRetriever */
class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: c */
    private static final int f17745c = 1;

    /* renamed from: d */
    private static final int f17746d = 2;

    /* renamed from: a */
    private final String f17747a;

    /* renamed from: b */
    private final Handler f17748b;

    /* renamed from: e */
    private final Map<FragmentManager, RequestManagerFragment> f17749e;

    /* renamed from: f */
    private final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f17750f;

    /* renamed from: com.didi.dimina.container.ui.statusbar.RequestManagerRetriever$Holder */
    private static class Holder {
        /* access modifiers changed from: private */
        public static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();

        private Holder() {
        }
    }

    /* renamed from: a */
    static RequestManagerRetriever m13249a() {
        return Holder.INSTANCE;
    }

    private RequestManagerRetriever() {
        this.f17747a = ImmersionBar.class.getName();
        this.f17749e = new HashMap();
        this.f17750f = new HashMap();
        this.f17748b = new Handler(Looper.getMainLooper(), this);
    }

    /* renamed from: a */
    public ImmersionBar mo56676a(Activity activity) {
        m13252a(activity, "activity is null");
        String str = this.f17747a + System.identityHashCode(activity);
        if (activity instanceof FragmentActivity) {
            return m13250a(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity);
        }
        return m13247a(activity.getFragmentManager(), str).get(activity);
    }

    /* renamed from: a */
    public ImmersionBar mo56679a(Fragment fragment, boolean z) {
        String str;
        m13252a(fragment, "fragment is null");
        m13252a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            m13252a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.f17747a;
        if (z) {
            str = str2 + fragment.getClass().getName();
        } else {
            str = str2 + System.identityHashCode(fragment);
        }
        return m13250a(fragment.getChildFragmentManager(), str).get(fragment);
    }

    /* renamed from: a */
    public ImmersionBar mo56678a(android.app.Fragment fragment, boolean z) {
        String str;
        m13252a(fragment, "fragment is null");
        m13252a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof android.app.DialogFragment) {
            m13252a(((android.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.f17747a;
        if (z) {
            str = str2 + fragment.getClass().getName();
        } else {
            str = str2 + System.identityHashCode(fragment);
        }
        return m13247a(fragment.getChildFragmentManager(), str).get(fragment);
    }

    /* renamed from: a */
    public ImmersionBar mo56677a(Activity activity, Dialog dialog) {
        m13252a(activity, "activity is null");
        m13252a(dialog, "dialog is null");
        String str = this.f17747a + System.identityHashCode(dialog);
        if (activity instanceof FragmentActivity) {
            return m13250a(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity, dialog);
        }
        return m13247a(activity.getFragmentManager(), str).get(activity, dialog);
    }

    /* renamed from: b */
    public void mo56681b(Fragment fragment, boolean z) {
        String str;
        if (fragment != null) {
            String str2 = this.f17747a;
            if (z) {
                str = str2 + fragment.getClass().getName();
            } else {
                str = str2 + System.identityHashCode(fragment);
            }
            m13251a(fragment.getChildFragmentManager(), str, true);
        }
    }

    /* renamed from: b */
    public void mo56680b(Activity activity, Dialog dialog) {
        if (activity != null && dialog != null) {
            String str = this.f17747a + System.identityHashCode(dialog);
            if (activity instanceof FragmentActivity) {
                SupportRequestManagerFragment a = m13251a(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
                if (a != null) {
                    a.get(activity, dialog).mo56542a();
                    return;
                }
                return;
            }
            RequestManagerFragment a2 = m13248a(activity.getFragmentManager(), str, true);
            if (a2 != null) {
                a2.get(activity, dialog).mo56542a();
            }
        }
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f17749e.remove((FragmentManager) message.obj);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.f17750f.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
    }

    /* renamed from: a */
    private RequestManagerFragment m13247a(FragmentManager fragmentManager, String str) {
        return m13248a(fragmentManager, str, false);
    }

    /* renamed from: a */
    private RequestManagerFragment m13248a(FragmentManager fragmentManager, String str, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.f17749e.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            requestManagerFragment = new RequestManagerFragment();
            this.f17749e.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.f17748b.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    /* renamed from: a */
    private SupportRequestManagerFragment m13250a(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return m13251a(fragmentManager, str, false);
    }

    /* renamed from: a */
    private SupportRequestManagerFragment m13251a(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f17750f.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            this.f17750f.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment) supportRequestManagerFragment, str).commitAllowingStateLoss();
            this.f17748b.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(supportRequestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    /* renamed from: a */
    private static <T> void m13252a(T t, String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
    }
}
