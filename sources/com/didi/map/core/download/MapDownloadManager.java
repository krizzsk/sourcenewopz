package com.didi.map.core.download;

import com.didi.hawaii.log.HWLog;
import com.didi.map.constant.NavUrls;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

public class MapDownloadManager {

    /* renamed from: a */
    private Hashtable<String, Boolean> f24726a = new Hashtable<>();

    /* renamed from: b */
    private ExecutorService f24727b;

    /* renamed from: c */
    private ExecutorService f24728c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MapDownloadExecutor f24729d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapDownloadListener f24730e;

    /* renamed from: f */
    private final Object f24731f = new Object();

    /* renamed from: g */
    private boolean f24732g = false;

    public void setDownloadExecutor(MapDownloadExecutor mapDownloadExecutor) {
        this.f24729d = mapDownloadExecutor;
    }

    public void setDownloadListener(MapDownloadListener mapDownloadListener) {
        this.f24730e = mapDownloadListener;
    }

    public void stop() {
        stop((Runnable) null);
    }

    public void stop(Runnable runnable) {
        this.f24732g = true;
        cancel();
        this.f24729d = null;
        ExecutorService executorService = this.f24727b;
        if (executorService != null) {
            executorService.shutdown();
            this.f24727b = null;
        }
        synchronized (this.f24731f) {
            if (this.f24728c != null) {
                this.f24728c.shutdown();
                this.f24728c = null;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void cancel() {
        this.f24726a.clear();
    }

    public void addRequestIgnoreCache(String str, byte[] bArr) {
        if (this.f24729d != null) {
            m17581a(str, bArr);
        }
    }

    public void addRequest(String str) {
        if (this.f24729d != null && !this.f24726a.containsKey(str)) {
            m17580a(str);
            this.f24726a.put(str, true);
        }
    }

    /* renamed from: a */
    private void m17581a(final String str, final byte[] bArr) {
        m17577a();
        try {
            this.f24727b.execute(new Runnable() {
                public void run() {
                    try {
                        MapDownloadManager.this.m17584b(str, MapDownloadManager.this.f24729d.download(NavUrls.DiDiVecEnlargeUrl, bArr));
                    } catch (Exception e) {
                        e.printStackTrace();
                        MapDownloadManager.this.m17584b(str, (byte[]) null);
                    }
                }
            });
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException unused) {
            HWLog.m16760e(1, "MapDownloadMannager", "Download Crossing Manager has Reject:" + str);
        }
    }

    /* renamed from: a */
    private void m17580a(final String str) {
        m17577a();
        try {
            this.f24727b.execute(new Runnable() {
                public void run() {
                    MapDownloadManager.this.m17583b(str);
                }
            });
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException unused) {
            HWLog.m16760e(1, "MapDownloadMannager", "Download Crossing Manager has Reject:" + str);
        }
    }

    /* renamed from: a */
    private void m17577a() {
        if (this.f24727b == null) {
            this.f24727b = Executors.newFixedThreadPool(5, new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "HAWAII SDK MapDownloadManager Downloadpool");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17583b(String str) {
        try {
            m17584b(str, this.f24729d.download(str));
        } catch (Exception e) {
            e.printStackTrace();
            m17584b(str, (byte[]) null);
        }
        this.f24726a.remove(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17584b(final String str, final byte[] bArr) {
        if (this.f24730e != null) {
            synchronized (this.f24731f) {
                if (this.f24728c == null && !this.f24732g) {
                    this.f24728c = Executors.newSingleThreadExecutor(new ThreadFactory() {
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, "HAWAII SDK MapDownloadManager WritePool");
                        }
                    });
                }
                if (!this.f24732g) {
                    this.f24728c.execute(new Runnable() {
                        public void run() {
                            try {
                                if (bArr == null) {
                                    MapDownloadManager.this.f24730e.onFail(str);
                                } else {
                                    MapDownloadManager.this.f24730e.onData(str, bArr);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        }
    }
}
