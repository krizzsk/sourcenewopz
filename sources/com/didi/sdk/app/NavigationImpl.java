package com.didi.sdk.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.log.Logger;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

class NavigationImpl implements KeyEvent.Callback, FragmentManager.OnBackStackChangedListener, INavigation {
    private int mContainerViewId;
    /* access modifiers changed from: private */
    public FragmentManager mFragmentMgr;
    /* access modifiers changed from: private */
    public INavigationListener mListener;
    private PauseHandler mPauseHandler;
    private Router mRouter = Router.getInstance();
    private Map<Integer, Class<? extends Fragment>> mTemplateMapping;
    private OnBackResultListener onBackResultListener;
    private IStatusBarDelegate statusBarDelegate;

    public void showPopupWindow(int i, PopupWindow popupWindow, int i2, int i3, int i4) {
    }

    public NavigationImpl(FragmentManager fragmentManager, int i, IStatusBarDelegate iStatusBarDelegate, Map<Integer, Class<? extends Fragment>> map) {
        this.mFragmentMgr = fragmentManager;
        this.mContainerViewId = i;
        fragmentManager.addOnBackStackChangedListener(this);
        this.mTemplateMapping = map;
        this.mPauseHandler = new PauseHandler(Looper.getMainLooper(), fragmentManager);
        this.statusBarDelegate = iStatusBarDelegate;
    }

    /* access modifiers changed from: package-private */
    public void onResume() {
        this.mPauseHandler.resume();
    }

    /* access modifiers changed from: package-private */
    public void onPause() {
        this.mPauseHandler.pause();
    }

    public void registerFilter(IntentFilter intentFilter, Class<? extends Fragment> cls) {
        this.mRouter.registerFilter(intentFilter, cls);
    }

    public void transition(BaseBusinessContext baseBusinessContext, Intent intent, INavigation.TransactionAnimation transactionAnimation) {
        Fragment matchPage = this.mRouter.matchPage(baseBusinessContext, intent);
        if (matchPage != null) {
            startPage(intent, matchPage, transactionAnimation);
        } else {
            startActivity(baseBusinessContext, intent, transactionAnimation);
        }
    }

    public void transition(BaseBusinessContext baseBusinessContext, Intent intent) {
        transition(baseBusinessContext, intent, INavigation.TransactionAnimation.DEFAULT);
    }

    private boolean isActivity(ComponentName componentName) {
        if (componentName == null) {
            return false;
        }
        return Activity.class.isAssignableFrom(componentName.getClass());
    }

    private void startPage(Intent intent, Fragment fragment, INavigation.TransactionAnimation transactionAnimation) {
        if (fragment != null && !fragment.isAdded()) {
            log("startPage -> page " + fragment.getClass().getName());
            if (transactionAnimation == null) {
                transactionAnimation = INavigation.TransactionAnimation.DEFAULT;
            }
            transitionImpl(this.mContainerViewId, fragment, intent, transactionAnimation);
        }
    }

    private void startActivity(BaseBusinessContext baseBusinessContext, Intent intent, INavigation.TransactionAnimation transactionAnimation) {
        ComponentName component = intent.getComponent();
        if (component == null || !MainActivity.class.getName().equals(component.getClassName())) {
            Context context = baseBusinessContext.getContext();
            boolean z = context instanceof Activity;
            if (!z) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            if (z) {
                int i = (transactionAnimation == null || transactionAnimation.enter <= 0) ? INavigation.TransactionAnimation.DEFAULT.enter : transactionAnimation.enter;
                if (transactionAnimation == null || transactionAnimation.exit <= 0) {
                    transactionAnimation = INavigation.TransactionAnimation.DEFAULT;
                }
                ((Activity) context).overridePendingTransition(i, transactionAnimation.exit);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment matchPage(BaseBusinessContext baseBusinessContext, Intent intent) {
        return this.mRouter.matchPage(baseBusinessContext, intent, false);
    }

    private void transitionImpl(int i, Fragment fragment, Intent intent, INavigation.TransactionAnimation transactionAnimation) {
        final FragmentTransaction beginTransaction = this.mFragmentMgr.beginTransaction();
        Fragment currentFragment = getCurrentFragment(this.mFragmentMgr);
        boolean booleanExtra = intent.getBooleanExtra(INavigation.BUNDLE_KEY_ALLOW_COVER_PAGE, false);
        if (!onInterceptSameTemplateFragment(fragment, currentFragment) || booleanExtra) {
            if (transactionAnimation != null) {
                beginTransaction.setCustomAnimations(transactionAnimation.enter, transactionAnimation.exit, transactionAnimation.popEnter, transactionAnimation.popExit);
            }
            String fragmentName = getFragmentName(fragment);
            if (intent.getBooleanExtra(INavigation.BUNDLE_KEY_CLEAR_TASK, false)) {
                popBackClearStack((Bundle) null);
            }
            if (intent.getBooleanExtra(INavigation.BUNDLE_KEY_TRASACTION_ADD, false)) {
                beginTransaction.add(i, fragment, fragmentName);
                if (currentFragment != null) {
                    beginTransaction.hide(currentFragment);
                }
            } else {
                beginTransaction.replace(i, fragment, fragmentName);
            }
            if (intent.getBooleanExtra(INavigation.BUNDLE_KEY_BACKSTACK, true)) {
                beginTransaction.addToBackStack(fragmentName);
            }
            if (intent.getBooleanExtra(INavigation.BUNDLE_KEY_SET_REORDERING_ALLOWED, false)) {
                beginTransaction.setReorderingAllowed(true);
            }
            INavigationListener iNavigationListener = this.mListener;
            if (iNavigationListener != null) {
                iNavigationListener.preLeaveHome();
            }
            safePost(new Runnable() {
                public void run() {
                    synchronized (NavigationImpl.this.mFragmentMgr) {
                        if (NavigationImpl.this.getCurrentFragment(NavigationImpl.this.mFragmentMgr) == null && NavigationImpl.this.mListener != null) {
                            BusinessContextManager.getInstance().mo90612a(false);
                            NavigationImpl.this.mListener.onLeaveHome();
                            NavigationImpl.this.log("onBackStackChanged is onLeaveHome");
                        }
                        beginTransaction.commitAllowingStateLoss();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void safePost(Runnable runnable) {
        this.mPauseHandler.sendMessage(Message.obtain(this.mPauseHandler, 0, runnable));
    }

    public void popBackStack() {
        popBackStack((Bundle) null);
    }

    public void popBackStack(final Bundle bundle) {
        safePost(new Runnable() {
            public void run() {
                synchronized (NavigationImpl.this.mFragmentMgr) {
                    NavigationImpl.this.onPopBackStackResult((String) null, 0, bundle);
                    NavigationImpl.this.mFragmentMgr.popBackStack();
                }
            }
        });
    }

    public void popBackStack(String str, int i) {
        popBackStack(str, i, (Bundle) null);
    }

    public void popBackStack(final String str, final int i, final Bundle bundle) {
        safePost(new Runnable() {
            public void run() {
                synchronized (NavigationImpl.this.mFragmentMgr) {
                    NavigationImpl.this.onPopBackStackResult(str, i, bundle);
                    NavigationImpl.this.mFragmentMgr.popBackStack(str, i);
                }
            }
        });
    }

    public void popBackStack(int i) {
        popBackStack(i, (Bundle) null);
    }

    public void popBackStack(int i, Bundle bundle) {
        if (i == 0) {
            popBackExclusive(bundle);
        } else if (i == 1) {
            popBackOnRoot(bundle);
        } else if (i == 2) {
            popBackClearStack(bundle);
        } else if (i == 3) {
            popBackFinishActivity();
        } else if (i != 4) {
            popBackStack(bundle);
        } else {
            popBackExitApp();
        }
    }

    private void popBackExclusive(Bundle bundle) {
        log("popBackExclusive");
        popBackStack(bundle);
    }

    private void popBackOnRoot(Bundle bundle) {
        if (this.mFragmentMgr.getBackStackEntryCount() <= 1) {
            log("current is root Page");
            return;
        }
        String name = this.mFragmentMgr.getBackStackEntryAt(0).getName();
        popBackStack(name, 0, bundle);
        log("popBackOnRoot -> root Page " + name);
    }

    private void popBackClearStack(Bundle bundle) {
        if (this.mFragmentMgr.getBackStackEntryCount() > 0) {
            String name = this.mFragmentMgr.getBackStackEntryAt(0).getName();
            popBackStack(name, 1, bundle);
            log("popBackClearStack -> root Page " + name);
        }
    }

    private void popBackFinishActivity() {
        FragmentActivity activity = getCurrentFragment(this.mFragmentMgr).getActivity();
        if (activity != null) {
            log("popBackFinishActivity -> activity " + activity.getClass().getName());
            activity.finish();
        }
    }

    private void popBackExitApp() {
        log("popBackExitApp");
        System.exit(0);
    }

    /* access modifiers changed from: package-private */
    public void setOnBackResultListener(OnBackResultListener onBackResultListener2) {
        this.onBackResultListener = onBackResultListener2;
    }

    /* access modifiers changed from: private */
    public void onPopBackStackResult(String str, int i, Bundle bundle) {
        OnBackResultListener onBackResultListener2;
        boolean z = true;
        Fragment fragment = null;
        if (this.mFragmentMgr.getBackStackEntryCount() != 1) {
            if (str == null) {
                fragment = getLastIndexFragment(this.mFragmentMgr, 2);
            } else {
                int backStackEntryCount = this.mFragmentMgr.getBackStackEntryCount() - 1;
                while (true) {
                    if (backStackEntryCount < 0) {
                        break;
                    } else if (!str.equals(this.mFragmentMgr.getBackStackEntryAt(backStackEntryCount).getName())) {
                        backStackEntryCount--;
                    } else if (i == 1) {
                        int i2 = backStackEntryCount - 1;
                        if (i2 >= 0) {
                            fragment = this.mFragmentMgr.findFragmentByTag(this.mFragmentMgr.getBackStackEntryAt(i2).getName());
                        }
                    } else {
                        fragment = this.mFragmentMgr.findFragmentByTag(str);
                    }
                }
            }
            z = false;
        }
        if (fragment != null) {
            Bundle arguments = fragment.getArguments();
            if (arguments != null && bundle != null) {
                arguments.putAll(bundle);
            }
        } else if (z && (onBackResultListener2 = this.onBackResultListener) != null) {
            onBackResultListener2.onPopBackToHome(bundle);
        }
    }

    public void showDialog(final DialogFragment dialogFragment) {
        safePost(new Runnable() {
            public void run() {
                if (!dialogFragment.isAdded()) {
                    dialogFragment.show(NavigationImpl.this.mFragmentMgr, (String) null);
                }
            }
        });
    }

    public void dismissDialog(final DialogFragment dialogFragment) {
        safePost(new Runnable() {
            public void run() {
                DialogFragment dialogFragment = dialogFragment;
                if ((dialogFragment instanceof BaseDialogFragment) || dialogFragment.getFragmentManager() != null) {
                    dialogFragment.dismiss();
                }
            }
        });
    }

    public String getFragmentName(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments != null && arguments.containsKey(INavigation.BUNDLE_KEY_FRAGMENT_NAME)) {
            return arguments.getString(INavigation.BUNDLE_KEY_FRAGMENT_NAME);
        }
        return fragment.getClass().getName() + "@" + System.identityHashCode(fragment);
    }

    private void hideHomeFragments(FragmentManager fragmentManager, Fragment fragment) {
        Bundle bundle;
        final boolean z;
        Fragment findFragmentById = fragmentManager.findFragmentById(R.id.home_map_fragment);
        if (fragment == null) {
            bundle = null;
        } else {
            bundle = fragment.getArguments();
        }
        boolean z2 = false;
        if (fragment == null) {
            z = true;
            z2 = true;
        } else if (bundle == null) {
            z = false;
        } else {
            bundle.getBoolean(INavigation.BUNDLE_KEY_TITLE_BAR_NEED);
            z2 = bundle.getBoolean(INavigation.BUNDLE_KEY_MAP_NEED);
            z = bundle.getBoolean(INavigation.BUNDLE_KEY_BOTTOM_NEED);
        }
        final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        if (z2) {
            beginTransaction.show(findFragmentById);
        } else {
            beginTransaction.hide(findFragmentById);
        }
        log("mListener:" + this.mListener + "  fNeedShowBootom:" + z);
        safePost(new Runnable() {
            public void run() {
                if (NavigationImpl.this.mListener != null) {
                    NavigationImpl.this.mListener.onEntranceVisible(z);
                }
                beginTransaction.commitAllowingStateLoss();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Fragment getCurrentFragment(FragmentManager fragmentManager) {
        return getLastIndexFragment(fragmentManager, 1);
    }

    private Fragment getLastIndexFragment(FragmentManager fragmentManager, int i) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount <= i - 1) {
            return null;
        }
        return fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - i).getName());
    }

    public void onBackStackChanged() {
        safePost(new Runnable() {
            public void run() {
                NavigationImpl.this.performBackStackChanged();
            }
        });
    }

    /* access modifiers changed from: private */
    public void performBackStackChanged() {
        Fragment currentFragment = getCurrentFragment(this.mFragmentMgr);
        if (currentFragment != null && currentFragment.isHidden()) {
            FragmentTransaction beginTransaction = this.mFragmentMgr.beginTransaction();
            beginTransaction.show(currentFragment);
            beginTransaction.commitAllowingStateLoss();
        }
        hideHomeFragments(this.mFragmentMgr, currentFragment);
        if (this.mListener == null) {
            return;
        }
        if (currentFragment == null) {
            BusinessContextManager.getInstance().mo90612a(true);
            log("onBackStackChanged is popBackStack to home");
            this.mListener.onBackToHome();
            return;
        }
        boolean z = false;
        if (currentFragment instanceof IStatusBar) {
            z = ((IStatusBar) currentFragment).showStatusBar();
        }
        this.statusBarDelegate.changedStatusBar(true ^ z);
    }

    public void setNavigationListener(INavigationListener iNavigationListener) {
        this.mListener = iNavigationListener;
    }

    /* access modifiers changed from: private */
    public void log(String str) {
        Logger.m25811i("Navigation: " + str, new Object[0]);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Fragment currentFragment = getCurrentFragment(this.mFragmentMgr);
        if (currentFragment instanceof KeyEvent.Callback) {
            return ((KeyEvent.Callback) currentFragment).onKeyDown(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Fragment currentFragment = getCurrentFragment(this.mFragmentMgr);
        if (currentFragment instanceof KeyEvent.Callback) {
            return ((KeyEvent.Callback) currentFragment).onKeyUp(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        Fragment currentFragment = getCurrentFragment(this.mFragmentMgr);
        if (currentFragment instanceof KeyEvent.Callback) {
            return ((KeyEvent.Callback) currentFragment).onKeyLongPress(i, keyEvent);
        }
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        Fragment currentFragment = getCurrentFragment(this.mFragmentMgr);
        if (currentFragment instanceof KeyEvent.Callback) {
            return ((KeyEvent.Callback) currentFragment).onKeyMultiple(i, i2, keyEvent);
        }
        return false;
    }

    public static class PauseHandler extends Handler {
        /* access modifiers changed from: private */
        public final Vector<Message> mBuffer = new Vector<>();
        /* access modifiers changed from: private */
        public volatile boolean mIsPaused;
        /* access modifiers changed from: private */
        public FragmentManager manager;

        public PauseHandler(Looper looper, FragmentManager fragmentManager) {
            super(looper);
            this.manager = fragmentManager;
        }

        /* access modifiers changed from: package-private */
        public final void resume() {
            Logger.m25811i("resume and consume", new Object[0]);
            this.mIsPaused = false;
            while (this.mBuffer.size() > 0 && !this.mIsPaused) {
                final ArrayList arrayList = new ArrayList(this.mBuffer);
                this.mBuffer.clear();
                post(new Runnable() {
                    public void run() {
                        if (!PauseHandler.this.mIsPaused) {
                            for (Message message : arrayList) {
                                if (!PauseHandler.this.mIsPaused) {
                                    PauseHandler.this.processMessage(message);
                                    message.recycle();
                                } else {
                                    PauseHandler.this.mBuffer.add(message);
                                }
                            }
                            PauseHandler.this.manager.executePendingTransactions();
                            return;
                        }
                        PauseHandler.this.mBuffer.addAll(arrayList);
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        public final void pause() {
            Logger.m25811i("pause", new Object[0]);
            this.mIsPaused = true;
        }

        public boolean isPaused() {
            return this.mIsPaused;
        }

        /* access modifiers changed from: protected */
        public void processMessage(Message message) {
            Logger.m25811i("processMessage", new Object[0]);
            ((Runnable) message.obj).run();
        }

        public final void handleMessage(Message message) {
            if (this.mIsPaused) {
                this.mBuffer.add(Message.obtain(message));
                return;
            }
            processMessage(message);
        }
    }

    private boolean onInterceptSameTemplateFragment(Fragment fragment, Fragment fragment2) {
        return isMatchInFragmentTemplate(fragment2) && fragment2 != null && isMatchInFragmentTemplate(fragment) && fragment != null && TextUtils.equals(fragment2.getClass().getName(), fragment.getClass().getName());
    }

    private boolean isMatchInFragmentTemplate(Fragment fragment) {
        Map<Integer, Class<? extends Fragment>> map;
        if (fragment == null || (map = this.mTemplateMapping) == null || map.size() <= 0 || this.mTemplateMapping.values() == null) {
            return false;
        }
        return this.mTemplateMapping.values().contains(fragment.getClass());
    }
}
