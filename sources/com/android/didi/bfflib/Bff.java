package com.android.didi.bfflib;

import android.content.Context;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.concurrent.BffAbilityMapModel;
import com.android.didi.bfflib.concurrent.BffConcurrentFormStore;
import com.android.didi.bfflib.concurrent.BffConfigModel;
import com.android.didi.bfflib.debug.BffDebugUtil;
import com.android.didi.bfflib.task.BffSingleProxyImpl;
import com.android.didi.bfflib.task.taskmanager.BffProxyManager;
import com.android.didi.bfflib.utils.BffLog;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bff {
    public static final String CONCURRENT_FORM_ABILITY_ID = "common/cGetAbilityMap";
    private static BffConfig bffConfig = new BffConfig();
    public static boolean isRequestConcurrentForm;

    private Bff() {
    }

    public static class BffConfig {
        private String mConfig;
        private String mHostAddr = "https://api.didiglobal.com/";
        private boolean mIsOpenRequestConcurrentForm;
        private Map<String, List<String>> mMappingTable = new HashMap();
        private int mMaximumWaitingTime = 1000;
        private CommonParamGenerator mParamGenerator;
        private Map<String, List<String>> mServiceTable = new HashMap();

        public interface CommonParamGenerator {
            Map<String, Object> generateParams();
        }

        public void setHostAddr(String str) {
            this.mHostAddr = str;
        }

        public void setCommonParamsGenerator(CommonParamGenerator commonParamGenerator) {
            this.mParamGenerator = commonParamGenerator;
        }

        public Map<String, Object> getCommonParams() {
            HashMap hashMap = new HashMap();
            CommonParamGenerator commonParamGenerator = this.mParamGenerator;
            if (commonParamGenerator != null) {
                try {
                    hashMap.putAll(commonParamGenerator.generateParams());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }

        public String getHostAddr() {
            return this.mHostAddr;
        }

        public void add(String str, List<String> list) {
            this.mMappingTable.put(str, list);
        }

        public Map<String, List<String>> addTagAndAbilityIds(String str, String[] strArr) {
            this.mMappingTable.put(str, new ArrayList(Arrays.asList(strArr)));
            return this.mMappingTable;
        }

        public Map<String, List<String>> addServiceAndAbilityIds(String str, String[] strArr) {
            this.mServiceTable.put(str, new ArrayList(Arrays.asList(strArr)));
            return this.mServiceTable;
        }

        public Map<String, List<String>> getMappingTable() {
            return this.mMappingTable;
        }

        public Map<String, List<String>> getServiceTable() {
            return this.mServiceTable;
        }

        public void setLogOutput(boolean z) {
            BffLog.setOutput(z);
        }

        public void setOpenRequestConcurrentForm(boolean z) {
            this.mIsOpenRequestConcurrentForm = z;
        }

        public boolean getIsOpenRequestConcurrentForm() {
            return this.mIsOpenRequestConcurrentForm;
        }

        public void setConfig(String str) {
            this.mConfig = str;
        }

        public String getConfig() {
            return this.mConfig;
        }

        public void setServiceMaximunWaitingTime(int i) {
            this.mMaximumWaitingTime = i;
        }

        public int getServiceMaximunWaitingTime() {
            return this.mMaximumWaitingTime;
        }
    }

    public static BffConfig getBffConfig() {
        return bffConfig;
    }

    public static void call(IBffProxy.Ability ability) {
        if (ability.getContext() != null) {
            synchronized (Bff.class) {
                if (!BffDebugUtil.isInited()) {
                    BffDebugUtil.init(ability.getContext());
                }
            }
            if (!isCallImmediatelyByApollo(ability)) {
                BffProxyManager.getInstance().call(ability);
                if (bffConfig.getIsOpenRequestConcurrentForm() && !isRequestConcurrentForm) {
                    final BffAbilityMapModel abilityMapModel = BffConcurrentFormStore.getInstance().getAbilityMapModel();
                    if (abilityMapModel == null || abilityMapModel.errno != 0 || abilityMapModel.data == null) {
                        BffProxyManager.getInstance().call(new IBffProxy.Ability.Builder(ability.getContext(), CONCURRENT_FORM_ABILITY_ID).setCallback(new RpcService.Callback<JsonObject>() {
                            public void onSuccess(JsonObject jsonObject) {
                                if (jsonObject != null) {
                                    BffAbilityMapModel bffAbilityMapModel = BffAbilityMapModel.this;
                                    if (bffAbilityMapModel == null || bffAbilityMapModel.errno != 0 || BffAbilityMapModel.this.data == null) {
                                        BffAbilityMapModel bffAbilityMapModel2 = new BffAbilityMapModel();
                                        bffAbilityMapModel2.parseAbilityMap(jsonObject);
                                        BffConcurrentFormStore.getInstance().setAbilityMapModel(bffAbilityMapModel2);
                                        BffLog.m1480d("bffTime: 并发表解析完成时间: " + System.currentTimeMillis());
                                        if (Bff.isRequestConcurrentForm) {
                                            Bff.isRequestConcurrentForm = false;
                                        }
                                    }
                                }
                            }

                            public void onFailure(IOException iOException) {
                                if (Bff.isRequestConcurrentForm) {
                                    Bff.isRequestConcurrentForm = false;
                                }
                            }
                        }).build());
                        isRequestConcurrentForm = true;
                    }
                }
            }
        }
    }

    private static boolean isCallImmediatelyByApollo(IBffProxy.Ability ability) {
        String config = getBffConfig().getConfig();
        BffConfigModel bffConfigModel = new BffConfigModel();
        bffConfigModel.parseDate(config);
        if (bffConfigModel.interfaces == null || bffConfigModel.interfaces.size() <= 0) {
            return false;
        }
        for (String equals : bffConfigModel.interfaces) {
            if (ability.getId().equals(equals)) {
                callImmediately(ability);
                return true;
            }
        }
        return false;
    }

    public static IBffProxy createOrGet(Context context) {
        synchronized (Bff.class) {
            if (!BffDebugUtil.isInited()) {
                BffDebugUtil.init(context);
            }
        }
        if (!BffDebugUtil.isDebug() || BffDebugUtil.isConcurrenceOpen()) {
            return new BffProxyImpl(context, bffConfig) {
                public void removeCache() {
                }
            };
        }
        return new BffSingleProxyImpl(context, bffConfig) {
            public void removeCache() {
            }
        };
    }

    public static void callImmediately(IBffProxy.Ability ability) {
        if (ability.getContext() != null) {
            C15304 r0 = new BffSingleProxyImpl(ability.getContext(), bffConfig) {
                public void removeCache() {
                }
            };
            r0.addAbility(ability);
            if (r0.getStatus() == 0) {
                r0.requestAbilityInLoop(r0.mAbilityList);
            }
        }
    }

    public static void cancel(IBffProxy.Ability ability) {
        BffProxyManager.getInstance().cancel(ability);
    }
}
