package com.didi.dimina.container.bridge;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.canvas.CanvasSubJsBridge;
import com.didi.dimina.container.bridge.loading.LoadingSubJSBridge;
import com.didi.dimina.container.bridge.loadsubpackage.LoadSubPackageSubJSBridge;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.LogUtil;

public class DMServiceJSModuleLazyParameter {
    private final FragmentActivity mActivity;
    private volatile BackgroundFetchDataSubJSBridge mBackgroundFetchDataSubJSBridge;
    private volatile BatteryInfoSubJSBridge mBatterySubJSBridge;
    private volatile CanvasSubJsBridge mCanvasSubJsBridge;
    private volatile CapsuleButtonSubJSBridge mCapsuleButtonSubJSBridge;
    private volatile BridgeCheckBridge mCheckBridgeSubJSBridge;
    private volatile ClipboardSubJSBridge mClipboard;
    private final DMMina mDimina;
    private volatile C7430a mFileOperation;
    private volatile FileSystemManagerSubJSBridge mFileSystemManagerSubJSBridge;
    private volatile ForceUpdateSubJSBridge mForceUpdateSubJsBridge;
    private volatile ImageSubJSBridge mImage;
    private volatile ImagePreviewSubJSBridge mImagePreview;
    private volatile InnerAudioContextSubJSBridge mInnerAudioContextSubJSBridge;
    private volatile KeyEventJSBridge mKeyEvent;
    private volatile KeyboardSubJSBridge mKeyboard;
    private volatile LaunchOptionsSubJSBridge mLaunchOptions;
    private volatile LoadSubPackageSubJSBridge mLoadSubPackageSubJSBridge;
    private volatile LoadingSubJSBridge mLoading;
    private volatile C7431b mLog;
    private volatile MemoryWarningSubJSBridge mMemoryWarningSubJSBridge;
    private volatile ModalSubJSBridge mModal;
    private volatile C7432c mNavigationBar;
    private volatile NavigateSubJSBridge mNavigator;
    private volatile NetworkSubJSBridge mNetworkSubJSBridge;
    private volatile C7434d mPackage;
    private volatile PageRefreshSubJSBridge mPageRefresh;
    private volatile PhoneSubJSBridge mPhone;
    private volatile PopupSubJSBridge mPopup;
    private volatile PreLoadSubPackageSubJSBridge mPreloadSubPackageSubJSBridge;
    private volatile RecordSubJSBridge mRecordSubJSBridge;
    private volatile ScreenSubJSBridge mScreenSubJSBridge;
    private volatile SettingSubJSBridge mSettingSubJSBridge;
    private volatile SnapshotSubJSBridge mSnapshotSubJSBridge;
    private volatile C7435e mStorage;
    private volatile C7436f mSystemInfo;
    private volatile C7437g mTabBar;
    private volatile C7438h mToast;
    private volatile UncaughtErrorSubJsBridge mUncaughtErrorSubJsBridge;
    private volatile VibrateSubJSBridge mVibrateSubJSBridge;
    private volatile WifiSubJSBridge mWifiSubJSBridge;

    public CanvasSubJsBridge getCanvas() {
        if (this.mCanvasSubJsBridge == null) {
            synchronized (this) {
                if (this.mCanvasSubJsBridge == null) {
                    this.mCanvasSubJsBridge = new CanvasSubJsBridge(this.mDimina.getConfig());
                }
            }
        }
        return this.mCanvasSubJsBridge;
    }

    /* access modifiers changed from: package-private */
    public NavigateSubJSBridge getNavigator() {
        if (this.mNavigator == null) {
            synchronized (this) {
                if (this.mNavigator == null) {
                    this.mNavigator = new NavigateSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mNavigator;
    }

    /* access modifiers changed from: package-private */
    public C7438h getToast() {
        if (this.mToast == null) {
            synchronized (this) {
                if (this.mToast == null) {
                    this.mToast = new C7438h(this.mActivity);
                }
            }
        }
        return this.mToast;
    }

    /* access modifiers changed from: package-private */
    public C7435e getStorage() {
        if (this.mStorage == null) {
            synchronized (this) {
                if (this.mStorage == null) {
                    this.mStorage = new C7435e(this.mDimina);
                }
            }
        }
        return this.mStorage;
    }

    /* access modifiers changed from: package-private */
    public C7431b getLog() {
        if (this.mLog == null) {
            synchronized (this) {
                if (this.mLog == null) {
                    this.mLog = new C7431b();
                }
            }
        }
        return this.mLog;
    }

    /* access modifiers changed from: package-private */
    public ImageSubJSBridge getImage() {
        if (this.mImage == null) {
            synchronized (this) {
                if (this.mImage == null) {
                    this.mImage = new ImageSubJSBridge(this.mActivity, this.mDimina);
                }
            }
        }
        return this.mImage;
    }

    /* access modifiers changed from: package-private */
    public PopupSubJSBridge getPopup() {
        if (this.mPopup == null) {
            synchronized (this) {
                if (this.mPopup == null) {
                    this.mPopup = new PopupSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mPopup;
    }

    /* access modifiers changed from: package-private */
    public KeyEventJSBridge getKeyEvent() {
        if (this.mKeyEvent == null) {
            synchronized (this) {
                if (this.mKeyEvent == null) {
                    this.mKeyEvent = new KeyEventJSBridge(this.mActivity);
                }
            }
        }
        return this.mKeyEvent;
    }

    /* access modifiers changed from: package-private */
    public ModalSubJSBridge getModal() {
        if (this.mModal == null) {
            synchronized (this) {
                if (this.mModal == null) {
                    this.mModal = new ModalSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mModal;
    }

    /* access modifiers changed from: package-private */
    public C7430a getFileOperation() {
        if (this.mFileOperation == null) {
            synchronized (this) {
                if (this.mFileOperation == null) {
                    this.mFileOperation = new C7430a(this.mDimina.getConfig());
                }
            }
        }
        return this.mFileOperation;
    }

    /* access modifiers changed from: package-private */
    public LoadingSubJSBridge getLoading() {
        if (this.mLoading == null) {
            synchronized (this) {
                if (this.mLoading == null) {
                    this.mLoading = new LoadingSubJSBridge(this.mActivity, this.mDimina);
                }
            }
        }
        return this.mLoading;
    }

    /* access modifiers changed from: package-private */
    public PhoneSubJSBridge getPhone() {
        if (this.mPhone == null) {
            synchronized (this) {
                if (this.mPhone == null) {
                    this.mPhone = new PhoneSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mPhone;
    }

    /* access modifiers changed from: package-private */
    public ClipboardSubJSBridge getClipboard() {
        if (this.mClipboard == null) {
            synchronized (this) {
                if (this.mClipboard == null) {
                    this.mClipboard = new ClipboardSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mClipboard;
    }

    /* access modifiers changed from: package-private */
    public C7437g getTabBar() {
        if (this.mTabBar == null) {
            synchronized (this) {
                if (this.mTabBar == null) {
                    this.mTabBar = new C7437g(this.mDimina);
                }
            }
        }
        return this.mTabBar;
    }

    /* access modifiers changed from: package-private */
    public LaunchOptionsSubJSBridge getLaunchOptions() {
        if (this.mLaunchOptions == null) {
            synchronized (this) {
                if (this.mLaunchOptions == null) {
                    this.mLaunchOptions = new LaunchOptionsSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mLaunchOptions;
    }

    /* access modifiers changed from: package-private */
    public C7436f getSystemInfo() {
        if (this.mSystemInfo == null) {
            synchronized (this) {
                if (this.mSystemInfo == null) {
                    this.mSystemInfo = new C7436f(this.mDimina, this.mActivity);
                }
            }
        }
        return this.mSystemInfo;
    }

    /* access modifiers changed from: package-private */
    public C7432c getNavigationBar() {
        if (this.mNavigationBar == null) {
            synchronized (this) {
                if (this.mNavigationBar == null) {
                    this.mNavigationBar = new C7432c(this.mDimina, this.mActivity);
                }
            }
        }
        return this.mNavigationBar;
    }

    /* access modifiers changed from: package-private */
    public NetworkSubJSBridge getNetworkSubJSBridge(boolean z) {
        if (!z) {
            return this.mNetworkSubJSBridge;
        }
        if (this.mNetworkSubJSBridge == null) {
            synchronized (this) {
                if (this.mNetworkSubJSBridge == null) {
                    this.mNetworkSubJSBridge = new NetworkSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mNetworkSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public WifiSubJSBridge getWifiSubJSBridge(boolean z) {
        if (!z) {
            return this.mWifiSubJSBridge;
        }
        if (this.mWifiSubJSBridge == null) {
            synchronized (this) {
                if (this.mWifiSubJSBridge == null) {
                    this.mWifiSubJSBridge = new WifiSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mWifiSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public FileSystemManagerSubJSBridge getFileSystemManager() {
        if (this.mFileSystemManagerSubJSBridge == null) {
            synchronized (this) {
                if (this.mFileSystemManagerSubJSBridge == null) {
                    this.mFileSystemManagerSubJSBridge = new FileSystemManagerSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mFileSystemManagerSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public ImagePreviewSubJSBridge getImagePreview() {
        if (this.mImagePreview == null) {
            synchronized (this) {
                if (this.mImagePreview == null) {
                    this.mImagePreview = new ImagePreviewSubJSBridge(this.mDimina, this.mActivity);
                }
            }
        }
        return this.mImagePreview;
    }

    /* access modifiers changed from: package-private */
    public C7434d getPackage() {
        if (this.mPackage == null) {
            synchronized (this) {
                if (this.mPackage == null) {
                    this.mPackage = new C7434d(this.mDimina, this.mActivity, this.mDimina.getConfig());
                }
            }
        }
        return this.mPackage;
    }

    /* access modifiers changed from: package-private */
    public PageRefreshSubJSBridge getPageRefresh() {
        if (this.mPageRefresh == null) {
            synchronized (this) {
                if (this.mPageRefresh == null) {
                    this.mPageRefresh = new PageRefreshSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mPageRefresh;
    }

    /* access modifiers changed from: package-private */
    public SettingSubJSBridge getSettingSubJSBridge() {
        if (this.mSettingSubJSBridge == null) {
            synchronized (this) {
                if (this.mSettingSubJSBridge == null) {
                    this.mSettingSubJSBridge = new SettingSubJSBridge(this.mDimina, this.mActivity);
                }
            }
        }
        return this.mSettingSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public PreLoadSubPackageSubJSBridge getPreLoadSubPackage() {
        if (this.mPreloadSubPackageSubJSBridge == null) {
            synchronized (this) {
                if (this.mPreloadSubPackageSubJSBridge == null) {
                    this.mPreloadSubPackageSubJSBridge = new PreLoadSubPackageSubJSBridge(this.mDimina, this.mDimina.getConfig());
                }
            }
        }
        return this.mPreloadSubPackageSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public LoadSubPackageSubJSBridge getLoadSubPackage() {
        if (this.mLoadSubPackageSubJSBridge == null) {
            synchronized (this) {
                if (this.mLoadSubPackageSubJSBridge == null) {
                    this.mLoadSubPackageSubJSBridge = new LoadSubPackageSubJSBridge(this.mDimina, this.mActivity, this.mDimina.getConfig());
                }
            }
        }
        return this.mLoadSubPackageSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public CapsuleButtonSubJSBridge getCapsuleButton() {
        if (this.mCapsuleButtonSubJSBridge == null) {
            synchronized (this) {
                if (this.mCapsuleButtonSubJSBridge == null) {
                    this.mCapsuleButtonSubJSBridge = new CapsuleButtonSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mCapsuleButtonSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public VibrateSubJSBridge getVibrateSubJSBridge() {
        if (this.mVibrateSubJSBridge == null) {
            synchronized (this) {
                if (this.mVibrateSubJSBridge == null) {
                    this.mVibrateSubJSBridge = new VibrateSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mVibrateSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public MemoryWarningSubJSBridge getMemoryWarningSubJSBridge() {
        if (this.mMemoryWarningSubJSBridge == null) {
            synchronized (this) {
                if (this.mMemoryWarningSubJSBridge == null) {
                    this.mMemoryWarningSubJSBridge = new MemoryWarningSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mMemoryWarningSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public ForceUpdateSubJSBridge getForceUpdateSubJSBridge() {
        if (this.mForceUpdateSubJsBridge == null) {
            synchronized (this) {
                if (this.mForceUpdateSubJsBridge == null) {
                    this.mForceUpdateSubJsBridge = new ForceUpdateSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mForceUpdateSubJsBridge;
    }

    /* access modifiers changed from: package-private */
    public BackgroundFetchDataSubJSBridge getFirstTogetherSubJSBridge() {
        if (this.mBackgroundFetchDataSubJSBridge == null) {
            synchronized (this) {
                if (this.mBackgroundFetchDataSubJSBridge == null) {
                    this.mBackgroundFetchDataSubJSBridge = new BackgroundFetchDataSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mBackgroundFetchDataSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public SnapshotSubJSBridge getSnapshotSubJSBridge() {
        if (this.mSnapshotSubJSBridge == null) {
            synchronized (this) {
                if (this.mSnapshotSubJSBridge == null) {
                    this.mSnapshotSubJSBridge = new SnapshotSubJSBridge();
                }
            }
        }
        return this.mSnapshotSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public InnerAudioContextSubJSBridge getInnerAudioContext(boolean z) {
        if (!z) {
            return this.mInnerAudioContextSubJSBridge;
        }
        if (this.mInnerAudioContextSubJSBridge == null) {
            synchronized (this) {
                if (this.mInnerAudioContextSubJSBridge == null) {
                    this.mInnerAudioContextSubJSBridge = new InnerAudioContextSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mInnerAudioContextSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public KeyboardSubJSBridge getKeyboard() {
        if (this.mKeyboard == null) {
            synchronized (this) {
                if (this.mKeyboard == null) {
                    DMPage page = this.mDimina.getCurNavigator().getCurrentPage().getPage();
                    if (page == null) {
                        LogUtil.m13409e("DMServiceJSModuleLazyParameter::getMap -> dmPage is null");
                        return null;
                    }
                    this.mKeyboard = new KeyboardSubJSBridge(this.mActivity, page.getWebViewContainer().getWebView());
                }
            }
        }
        return this.mKeyboard;
    }

    /* access modifiers changed from: package-private */
    public BatteryInfoSubJSBridge getBatteryInfoBridge() {
        if (this.mBatterySubJSBridge == null) {
            synchronized (this) {
                if (this.mBatterySubJSBridge == null) {
                    this.mBatterySubJSBridge = new BatteryInfoSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mBatterySubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public ScreenSubJSBridge getScreenBridge() {
        if (this.mScreenSubJSBridge == null) {
            synchronized (this) {
                if (this.mScreenSubJSBridge == null) {
                    this.mScreenSubJSBridge = new ScreenSubJSBridge(this.mActivity);
                }
            }
        }
        return this.mScreenSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public RecordSubJSBridge getRecordSubJSBridge() {
        if (this.mRecordSubJSBridge == null) {
            synchronized (this) {
                if (this.mRecordSubJSBridge == null) {
                    this.mRecordSubJSBridge = new RecordSubJSBridge(this.mDimina);
                }
            }
        }
        return this.mRecordSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public BridgeCheckBridge getBridgeCheckBridge() {
        if (this.mCheckBridgeSubJSBridge == null) {
            synchronized (this) {
                if (this.mCheckBridgeSubJSBridge == null) {
                    this.mCheckBridgeSubJSBridge = new BridgeCheckBridge(this.mDimina);
                }
            }
        }
        return this.mCheckBridgeSubJSBridge;
    }

    /* access modifiers changed from: package-private */
    public UncaughtErrorSubJsBridge getUncaughtErrorSubBridge() {
        if (this.mUncaughtErrorSubJsBridge == null) {
            synchronized (this) {
                if (this.mUncaughtErrorSubJsBridge == null) {
                    this.mUncaughtErrorSubJsBridge = new UncaughtErrorSubJsBridge(this.mDimina);
                }
            }
        }
        return this.mUncaughtErrorSubJsBridge;
    }

    public DMServiceJSModuleLazyParameter(DMMina dMMina) {
        this.mDimina = dMMina;
        this.mActivity = dMMina.getActivity();
    }

    /* access modifiers changed from: package-private */
    public void init() {
        Looper myLooper;
        if (Build.VERSION.SDK_INT < 23 || (myLooper = Looper.myLooper()) == null) {
            getMemoryWarningSubJSBridge();
        } else {
            myLooper.getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public final boolean queueIdle() {
                    return DMServiceJSModuleLazyParameter.this.lambda$init$0$DMServiceJSModuleLazyParameter();
                }
            });
        }
    }

    public /* synthetic */ boolean lambda$init$0$DMServiceJSModuleLazyParameter() {
        getMemoryWarningSubJSBridge();
        return false;
    }
}
