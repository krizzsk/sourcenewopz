package com.didi.sdk.onehotpatch;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.dynamic.manager.Module;
import com.didi.dynamic.manager.utils.DownloadUtil;
import com.didi.dynamic.manager.utils.IDUtil;
import com.didi.dynamic.manager.utils.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils;
import com.didi.sdk.onehotpatch.installer.LocalTest;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class DebugActivity extends Activity {
    public static final String ACTION = "local_test";
    public static final String KEY_MSG = "key_msg";
    private static final int READ_REQUEST_CODE = 4322;
    private final BroadcastReceiver TEST_RECEIVER = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!DebugActivity.this.isFinishing()) {
                String stringExtra = intent.getStringExtra("key_msg");
                if (!TextUtils.isEmpty(stringExtra)) {
                    SystemUtils.showToast(Toast.makeText(context, stringExtra, 0));
                }
            }
        }
    };
    private Runnable mCallBacks = new Runnable() {
        int max = 600;

        public void run() {
            try {
                if (this.max <= 0) {
                    return;
                }
                if (!DebugActivity.this.isFinishing()) {
                    this.max--;
                    DebugActivity.this.inflatePatchInfo();
                    DebugActivity.this.getWindow().getDecorView().postDelayed(this, 1000);
                }
            } catch (IOException e) {
                Logger.warn(e);
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.hotpatch_debug_layout);
        File patchHome = PatchManager.getPatchHome(this);
        if (!patchHome.exists() || patchHome.list() == null || patchHome.list().length == 0) {
            SystemUtils.showToast(Toast.makeText(this, "Empty patch dir.", 0));
        }
        ((TextView) findViewById(R.id.sdk_version)).setText(BuildConfig.HOTPATCH_VERSION);
        TextView textView = (TextView) findViewById(R.id.running_time);
        final TextView textView2 = (TextView) findViewById(R.id.content);
        Button button = (Button) findViewById(R.id.copy);
        final Button button2 = (Button) findViewById(R.id.restart);
        Button button3 = (Button) findViewById(R.id.ota);
        Button button4 = (Button) findViewById(R.id.check);
        Button button5 = (Button) findViewById(R.id.clear);
        Button button6 = (Button) findViewById(R.id.local_patch);
        Button button7 = (Button) findViewById(R.id.export);
        Button button8 = (Button) findViewById(R.id.enable_log);
        try {
            long startTime = getStartTime();
            textView.setText(String.format(Locale.getDefault(), "%ds", new Object[]{Long.valueOf((SystemClock.elapsedRealtime() - startTime) / 1000)}));
        } catch (Exception unused) {
            textView.setText("failed");
            Logger.log("failed to fetch app running time.", new Object[0]);
        }
        try {
            str = DownloadManager.getInstance(this).getFetchUrl();
        } catch (Exception unused2) {
            str = IDUtil.getUUID(this);
        }
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((ClipboardManager) DebugActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, textView2.getText()));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.showToast(Toast.makeText(view.getContext(), R.string.hotpatch_restarting, 1));
                Intent launchIntentForPackage = DebugActivity.this.getPackageManager().getLaunchIntentForPackage(WsgSecInfo.packageName(view.getContext()));
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent(view.getContext(), DebugActivity.class);
                }
                ((AlarmManager) DebugActivity.this.getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(view.getContext(), 0, launchIntentForPackage, 335544320));
                if (Build.VERSION.SDK_INT >= 16) {
                    DebugActivity.this.finishAffinity();
                } else {
                    DebugActivity.this.finish();
                }
                System.exit(0);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PatchManager.setFingerPrint(view.getContext(), "123456");
                button2.performClick();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DownloadUtil.setRequestTime(view.getContext(), 0);
                DownloadManager.getInstance(view.getContext()).checkModuleAndDownload();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                try {
                    PatchManager.clearPatch(view.getContext());
                } catch (IOException e) {
                    Logger.warn(e);
                }
                button2.performClick();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DebugActivity.this.performFileSearch();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    SystemUtils.showToast(Toast.makeText(view.getContext(), "sdcard is unavailable!", 0));
                    return;
                }
                final File patchHome = PatchManager.getPatchHome(view.getContext());
                final File file = new File(DebugActivity.this.getExternalFilesDir((String) null), patchHome.getName());
                Context context = view.getContext();
                SystemUtils.showToast(Toast.makeText(context, "Copy\n  " + patchHome.getAbsolutePath() + "\nto\n  " + file.getAbsolutePath() + "\n...", 1));
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            if (file.exists()) {
                                FileUtils.deleteDirectory(file);
                            }
                            DebugActivity.this.copyDir(patchHome, file);
                            view.post(new Runnable() {
                                public void run() {
                                    SystemUtils.showToast(Toast.makeText(view.getContext(), "Copy success!", 0));
                                }
                            });
                        } catch (Exception e) {
                            view.post(new Runnable() {
                                public void run() {
                                    Context context = view.getContext();
                                    SystemUtils.showToast(Toast.makeText(context, "Copy error: " + Log.getStackTraceString(e), 0));
                                }
                            });
                        }
                    }
                }, "hotpatch-export-data").start();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean enableLog = PatchManager.getEnableLog(view.getContext());
                PatchManager.setEnableLog(view.getContext(), !enableLog);
                Context context = view.getContext();
                StringBuilder sb = new StringBuilder();
                sb.append("Log switcher: ");
                sb.append(!enableLog);
                SystemUtils.showToast(Toast.makeText(context, sb.toString(), 0));
            }
        });
        new Handler(Looper.getMainLooper()).post(this.mCallBacks);
        registerDebugReceiver();
    }

    /* access modifiers changed from: private */
    public void copyDir(File file, File file2) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                FileUtils.copyFile(file, file2);
                return;
            }
            file2.mkdir();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    copyDir(file3, new File(file2, file3.getName()));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void inflatePatchInfo() throws IOException {
        Button button = (Button) findViewById(R.id.downloaded_version);
        Module newestDownloadedModule = DownloadManager.getInstance(this).getNewestDownloadedModule("hotpatch");
        if (newestDownloadedModule != null) {
            button.setText(newestDownloadedModule.version);
        } else {
            button.setText("");
        }
        inflatePatchInfo(PatchManager.getLoadPatch(this), R.id.loaded_version, newestDownloadedModule, button);
        inflatePatchInfo(PatchManager.getInstalledPatch(this), R.id.installed_version, newestDownloadedModule, button);
        inflatePatchInfo(PatchManager.getInstallingPatch(this), R.id.installing_version, newestDownloadedModule, button);
    }

    private void inflatePatchInfo(final PatchModule patchModule, int i, Module module, Button button) {
        Button button2 = (Button) findViewById(i);
        if (patchModule != null) {
            if (module != null && TextUtils.equals(patchModule.version, module.version)) {
                button.setText("");
            }
            if (PatchManager.getEnabledFlag(this, patchModule) == -100) {
                button2.setText(String.format("已禁用: %s", new Object[]{patchModule.version}));
                return;
            }
            button2.setText(patchModule.version);
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TextView textView = (TextView) DebugActivity.this.findViewById(R.id.patch_detail);
                    StringBuilder sb = new StringBuilder();
                    sb.append("app版本：");
                    sb.append(patchModule.appVersion);
                    sb.append("\n\npatch版本：");
                    sb.append(patchModule.version);
                    sb.append("\n\npatch包路径:");
                    sb.append(patchModule.modulePath);
                    sb.append("\n\npatch安装路径:");
                    sb.append(PatchManager.getPatchDir(view.getContext(), patchModule));
                    try {
                        MetaBean patchMeta = PatchManager.getPatchMeta(view.getContext(), patchModule);
                        sb.append("\n\npatch关联app版本：");
                        sb.append(patchMeta.target_version);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    textView.setText(sb.toString());
                }
            });
            return;
        }
        button2.setText("");
    }

    /* access modifiers changed from: private */
    public void installLocalPatch(final File file) {
        if (!file.exists()) {
            SystemUtils.showToast(Toast.makeText(this, String.format("%s不存在", new Object[]{file.getAbsolutePath()}), 0));
        } else if (!ZipUtils.isArchiveFile(file)) {
            SystemUtils.showToast(Toast.makeText(this, String.format("%s不是合法的zip文件", new Object[]{file.getAbsolutePath()}), 0));
        } else {
            SystemUtils.showToast(Toast.makeText(this, "Installing patch: " + file.getAbsolutePath(), 0));
            getWindow().getDecorView().postDelayed(new Runnable() {
                public void run() {
                    LocalTest.installLocalPatch(DebugActivity.this.getWindow().getContext(), file);
                }
            }, 500);
        }
    }

    /* access modifiers changed from: private */
    public void performFileSearch() {
        if (Build.VERSION.SDK_INT >= 19) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("application/zip");
            startActivityForResult(intent, 4322);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4322 && i2 == -1 && intent != null) {
            final Uri data = intent.getData();
            SystemUtils.showToast(Toast.makeText(this, "Selected uri: " + data.toString(), 0));
            new Thread(new Runnable() {
                public void run() {
                    final File file = new File(DebugActivity.this.getExternalFilesDir((String) null), "patch.zip");
                    try {
                        Thread.sleep(1000);
                        FileUtils.copyInputStreamToFile(new BufferedInputStream(DebugActivity.this.getContentResolver().openInputStream(data)), file);
                    } catch (Throwable th) {
                        Logger.warn(th);
                    }
                    DebugActivity.this.getWindow().getDecorView().post(new Runnable() {
                        public void run() {
                            DebugActivity.this.installLocalPatch(file);
                        }
                    });
                }
            }, "copy-patch").start();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        unregisterDebugReceiver();
        super.onDestroy();
    }

    private void registerDebugReceiver() {
        try {
            registerReceiver(this.TEST_RECEIVER, new IntentFilter(ACTION));
        } catch (Exception e) {
            android.util.Log.d("Context", "registerReceiver", e);
        } catch (Throwable th) {
            Logger.warn(th);
            return;
        }
        Logger.info("registerDebugReceiver", new Object[0]);
    }

    private void unregisterDebugReceiver() {
        try {
            unregisterReceiver(this.TEST_RECEIVER);
        } catch (Exception e) {
            android.util.Log.d("Context", "unregisterReceiver", e);
        } catch (Throwable th) {
            Logger.warn(th);
            return;
        }
        Logger.info("unregisterDebugReceiver", new Object[0]);
    }

    /* JADX INFO: finally extract failed */
    private long getStartTime() throws Exception {
        int i;
        if (Build.VERSION.SDK_INT >= 24) {
            return Process.getStartElapsedRealtime();
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/stat"));
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            long parseLong = Long.parseLong(readLine.substring(readLine.lastIndexOf(") ")).split(" ")[20]);
            try {
                i = Class.forName("android.system.OsConstants").getField("_SC_CLK_TCK").getInt((Object) null);
            } catch (ClassNotFoundException unused) {
                i = Class.forName("libcore.io.OsConstants").getField("_SC_CLK_TCK").getInt((Object) null);
            }
            Object obj = Class.forName("libcore.io.Libcore").getField("os").get((Object) null);
            return (parseLong * 1000) / ((Long) obj.getClass().getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue();
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }
}
