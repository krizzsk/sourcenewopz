package com.android.didi.safetoolkit.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObservable;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;
import com.android.didi.safetoolkit.observer.lifecycle.LifecycleObserverCompat;
import java.util.Map;
import java.util.TreeMap;

public abstract class BaseDialogFragment extends DialogFragment implements ILifecycleObservable {
    private boolean mIsStart;
    private LifecycleObserverCompat mLifeObserverCompat = new LifecycleObserverCompat();
    private DialogInterface.OnDismissListener mOnDismissListener;
    private Map<String, Runnable> mPaddingRunnable = new TreeMap();
    private View root;

    /* access modifiers changed from: protected */
    public abstract void findViews();

    /* access modifiers changed from: protected */
    public abstract int getLayoutRes();

    /* access modifiers changed from: protected */
    public abstract void initData();

    /* access modifiers changed from: protected */
    public abstract void initObjects();

    /* access modifiers changed from: protected */
    public boolean isAutoCall() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void parseBundle(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void setListener();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutRes(), viewGroup, false);
        this.root = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mIsStart = false;
        this.mPaddingRunnable.clear();
        if (isAutoCall()) {
            parseBundle(getArguments());
            findViews();
            initObjects();
            initData();
            setListener();
        }
        this.mLifeObserverCompat.onCreate();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (Build.VERSION.SDK_INT < 21) {
            try {
                onCreateDialog.findViewById(context.getResources().getIdentifier("android:id/titleDivider", (String) null, (String) null)).setBackgroundColor(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return onCreateDialog;
    }

    public final void addLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        this.mLifeObserverCompat.addLifecycleObserver(iLifecycleObserver);
    }

    public final boolean removeLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        return this.mLifeObserverCompat.removeLifecycleObserver(iLifecycleObserver);
    }

    public final <T extends View> T findViewById(int i) {
        return this.root.findViewById(i);
    }

    public String getTitle() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public boolean setDialogSizePercent(final float f) {
        if (!this.mIsStart) {
            this.mPaddingRunnable.remove("setDialogSizePercent");
            this.mPaddingRunnable.put("setDialogSizePercent", new Runnable() {
                public void run() {
                    BaseDialogFragment.this.setDialogSizePercent(f);
                }
            });
            return true;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return setDialogSizeExactly((int) (((float) displayMetrics.widthPixels) * f), -2);
    }

    /* access modifiers changed from: protected */
    public boolean setDialogSizeExactly(final int i, final int i2) {
        if (!this.mIsStart) {
            this.mPaddingRunnable.remove("setDialogSizeExactly");
            this.mPaddingRunnable.put("setDialogSizeExactly", new Runnable() {
                public void run() {
                    BaseDialogFragment.this.setDialogSizeExactly(i, i2);
                }
            });
            return true;
        }
        Dialog dialog = getDialog();
        if (dialog == null) {
            return false;
        }
        dialog.getWindow().setLayout(i, i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setDialogGravity(final int i) {
        if (!this.mIsStart) {
            this.mPaddingRunnable.remove("setDialogGravity");
            this.mPaddingRunnable.put("setDialogGravity", new Runnable() {
                public void run() {
                    BaseDialogFragment.this.setDialogGravity(i);
                }
            });
            return true;
        }
        Dialog dialog = getDialog();
        if (dialog == null) {
            return false;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = i;
        window.setAttributes(attributes);
        return true;
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(z);
        }
    }

    public void onStart() {
        super.onStart();
        this.mIsStart = true;
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            if (!this.mPaddingRunnable.isEmpty()) {
                TreeMap treeMap = new TreeMap();
                treeMap.putAll(this.mPaddingRunnable);
                for (String str : treeMap.keySet()) {
                    ((Runnable) treeMap.get(str)).run();
                }
                this.mPaddingRunnable.clear();
            }
        }
        this.mLifeObserverCompat.onStart();
    }

    public void onResume() {
        super.onResume();
        this.mLifeObserverCompat.onResume();
    }

    public void onPause() {
        super.onPause();
        this.mLifeObserverCompat.onPause();
    }

    public void onStop() {
        super.onStop();
        this.mLifeObserverCompat.onStop();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        destroy();
    }

    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    public boolean isShowing() {
        if (getDialog() != null) {
            return getDialog().isShowing();
        }
        return false;
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.executePendingTransactions();
            if (!isAdded()) {
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add((Fragment) this, str);
                beginTransaction.commitAllowingStateLoss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        if (!isAdded()) {
            return super.show(fragmentTransaction, str);
        }
        return -1;
    }

    private void destroy() {
        this.mLifeObserverCompat.onDestroy();
        this.mPaddingRunnable.clear();
    }
}
