package com.didichuxing.publicservice.screenAd;

import android.content.Context;
import com.didichuxing.publicservice.p196db.dao.DaoFactory;
import com.didichuxing.publicservice.p196db.dao.ScreenAdNewDao;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScreenAdManager {
    public static final String FOLDER_PATH = "DidiScreenAd";
    public static final String TAG = "ScreenAdManager";
    private ExecutorService executor;
    /* access modifiers changed from: private */
    public ScreenAdNewDao mScreenAdDao;

    private ScreenAdManager() {
        this.mScreenAdDao = (ScreenAdNewDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.SCREEN_AD_NEW);
        this.executor = Executors.newCachedThreadPool();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ScreenAdManager INSTANCE = new ScreenAdManager();

        private SingletonHolder() {
        }
    }

    public static ScreenAdManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getLocalPath(Context context, String str) {
        return context.getCacheDir().getAbsolutePath() + File.separator + FOLDER_PATH + File.separator + str.replaceAll("/", "").replaceAll(":", "");
    }

    public void insertSingleResource(final Context context, final DSplashResource.DataBean dataBean) {
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.insertSingleResourceSync(context, dataBean);
            }
        });
    }

    public void insertSingleResourceSync(Context context, DSplashResource.DataBean dataBean) {
        this.mScreenAdDao.insertSingleResource(context, dataBean);
    }

    public void deleteExpiredResource(final Context context) {
        this.executor.submit(new Runnable() {
            public void run() {
                DSplashResource resourceByResourceFlag = ScreenAdManager.this.mScreenAdDao.getResourceByResourceFlag(context, 2);
                if (resourceByResourceFlag != null && resourceByResourceFlag.data != null && resourceByResourceFlag.data.size() > 0) {
                    for (DSplashResource.DataBean next : resourceByResourceFlag.data) {
                        if (!(next == null || next.dataDetail == null)) {
                            ScreenAdManager.this.deleteSingleResource(context, (long) next.activity_id, next.dataDetail.localPath);
                        }
                    }
                }
            }
        });
    }

    public void deleteSingleResource(final Context context, final long j) {
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.deleteSingleResourceSync(context, j);
            }
        });
    }

    public void deleteSingleResourceSync(Context context, long j) {
        this.mScreenAdDao.deleteSingleResource(context, j);
    }

    public void deleteSingleResource(Context context, long j, String str) {
        final Context context2 = context;
        final long j2 = j;
        final String str2 = str;
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.mScreenAdDao.deleteSingleResource(context2, j2, str2);
            }
        });
    }

    public void deleteAllResource(final Context context) {
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.deleteAllResourceSync(context);
            }
        });
    }

    public void deleteAllResourceSync(Context context) {
        DSplashResource resourceByResourceFlag = this.mScreenAdDao.getResourceByResourceFlag(context, 0);
        if (resourceByResourceFlag != null && resourceByResourceFlag.data != null && resourceByResourceFlag.data.size() > 0) {
            for (DSplashResource.DataBean next : resourceByResourceFlag.data) {
                if (!(next == null || next.dataDetail == null)) {
                    deleteSingleResource(context, (long) next.activity_id, next.dataDetail.localPath);
                }
            }
        }
    }

    public void updateLastShowTime(final Context context, final long j) {
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.mScreenAdDao.updateLastShowTime(context, j);
            }
        });
    }

    public void updateLocalPath(Context context, long j, String str) {
        final Context context2 = context;
        final long j2 = j;
        final String str2 = str;
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.mScreenAdDao.updateLocalPath(context2, j2, str2);
            }
        });
    }

    public void updateLastShowTime(Context context, DSplashResource dSplashResource, long j) {
        if (dSplashResource != null && dSplashResource.data != null) {
            final DSplashResource dSplashResource2 = dSplashResource;
            final long j2 = j;
            final Context context2 = context;
            this.executor.submit(new Runnable() {
                public void run() {
                    int size = dSplashResource2.data.size() - 1;
                    while (size >= 0) {
                        DSplashResource.DataBean dataBean = dSplashResource2.data.get(size);
                        if (j2 <= dataBean.dataDetail.lastShowTime) {
                            ScreenAdManager.this.mScreenAdDao.updateLastShowTime(context2, (long) dataBean.activity_id);
                            size--;
                        } else {
                            return;
                        }
                    }
                }
            });
        }
    }

    public void updateXMLNode(Context context, long j, String str) {
        final Context context2 = context;
        final long j2 = j;
        final String str2 = str;
        this.executor.submit(new Runnable() {
            public void run() {
                ScreenAdManager.this.mScreenAdDao.updateXMLNode(context2, j2, str2);
            }
        });
    }

    public void submitTask(Runnable runnable) {
        if (runnable != null) {
            this.executor.submit(runnable);
        }
    }

    public boolean isSingleResourceExists(Context context, long j) {
        return this.mScreenAdDao.isSingleResourceExists(context, j);
    }

    public DSplashResource getAvailableResource(Context context) {
        return this.mScreenAdDao.getResourceByResourceFlag(context, 1);
    }

    public DSplashResource getAllResource(Context context) {
        return this.mScreenAdDao.getResourceByResourceFlag(context, 0);
    }
}
