package com.didi.foundation.sdk.application.ability;

import android.app.Application;
import android.text.TextUtils;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.service.VariantConfigService;
import com.didi.sdk.push.TransAdapter;
import com.didi.security.wireless.adapter.SignInterceptor;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.util.Converter;
import com.didichuxing.foundation.util.TypeResolver;
import com.didichuxing.mas.sdk.quality.init.MASSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import didihttp.DidiHttpClient;
import didihttp.Interceptor;
import didihttp.Response;
import didihttp.StatisticalCallback;
import didihttp.StatisticalContext;
import didihttpdns.HttpDnsManager;
import didihttpdns.model.DnsParam;
import didihttpdns.security.InterceptorGetter;
import didihttpdns.security.SigGenerator;
import didinet.ApolloAPI;
import didinet.NetEngine;
import didinet.OmegaAPI;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class NetStatisticsAbility {
    private NetStatisticsAbility() {
    }

    public static void init(final Application application, NetEngine netEngine) {
        String transApolloName = VariantConfigService.getInstance().getTransApolloName();
        if (!TextUtils.isEmpty(transApolloName)) {
            netEngine.setTerminalTag(transApolloName);
        }
        netEngine.setPushAPI(new TransAdapter());
        netEngine.setApolloAPI(new ApolloAPI() {
            public ApolloAPI.Toggle getToggle(String str, boolean z) {
                return null;
            }

            public ApolloAPI.Toggle getToggle(String str) {
                final IToggle toggle = Apollo.getToggle(str);
                return toggle == null ? ApolloAPI.Toggle.NONE : new ApolloAPI.Toggle() {
                    public boolean allow() {
                        return toggle.allow();
                    }

                    public ApolloAPI.Experiment getExperiment() {
                        final IExperiment experiment = toggle.getExperiment();
                        return experiment == null ? ApolloAPI.Experiment.NONE : new ApolloAPI.Experiment() {
                            public <T> T getParam(String str, T t) {
                                return experiment.getParam(str, t);
                            }

                            public String getTestKey() {
                                return experiment.getTestKey();
                            }
                        };
                    }

                    public Integer getLogRate() {
                        return toggle.getLogRate();
                    }

                    public String getName() {
                        return toggle.getName();
                    }
                };
            }
        });
        netEngine.setOmegaAPI(new OmegaAPI() {
            public void trackEvent(String str) {
                OmegaSDKAdapter.trackEvent(str);
            }

            public void trackEvent(String str, String str2) {
                OmegaSDKAdapter.trackEvent(str, str2);
            }

            public void trackEvent(String str, String str2, Map map) {
                OmegaSDKAdapter.trackEvent(str, str2, map);
            }
        });
        netEngine.addStatisticalCallback(new StatisticalCallback() {
            public void onStatisticalDataCallback(StatisticalContext statisticalContext) {
                HashMap hashMap = new HashMap();
                hashMap.put("url", statisticalContext.getCall().request().url().toString());
                statisticalContext.addDataToOmega(hashMap);
                MASSDK.trackHttpTransactionEvent(hashMap);
            }
        });
        netEngine.setParamGetter(new NetEngine.ExternalParamGetter() {
            public NetEngine.ExternalParam onGetExternalParam() {
                NetEngine.ExternalParam externalParam = new NetEngine.ExternalParam();
                try {
                    if (!TextUtils.isEmpty(AccountService.getInstance().getCityId())) {
                        externalParam.setCityId(Integer.parseInt(AccountService.getInstance().getCityId()));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                return externalParam;
            }
        });
        Apollo.addCacheLoadedListener(new OnCacheLoadedListener() {
            public void onCacheAlreadyLoaded() {
                DnsParam dnsParam = new DnsParam();
                dnsParam.apolloName = VariantConfigService.getInstance().apolloName();
                dnsParam.requestHttpDnsUrl = VariantConfigService.getInstance().getHttpDnsUrl();
                dnsParam.hostNames = VariantConfigService.getInstance().getHttpDnsCache();
                HttpDnsManager.getInstance().init(application, dnsParam, new SigGenerator() {
                    public String genSig(Map<String, String> map) {
                        return null;
                    }
                }, new SignInterceptorGetter());
            }
        });
    }

    private static class SignInterceptorGetter implements InterceptorGetter {
        final ServiceLoader<Converter> mConverters;
        final Interceptor mEmptyInterceptor;
        final Type mRpcInterceptorType;

        private SignInterceptorGetter() {
            this.mConverters = ServiceLoader.load(Converter.class);
            this.mRpcInterceptorType = TypeResolver.getSuperclassTypeParameter((Object) new Converter<RpcInterceptor<HttpRpcRequest, HttpRpcResponse>, Interceptor>() {
                public Interceptor convert(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor, Object... objArr) {
                    return null;
                }
            });
            this.mEmptyInterceptor = new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    return chain.proceed(chain.request());
                }
            };
        }

        public Interceptor get(DidiHttpClient didiHttpClient) {
            Iterator<Converter> it = this.mConverters.iterator();
            while (it.hasNext()) {
                Converter next = it.next();
                if (this.mRpcInterceptorType.equals(next.getOriginType()) && Interceptor.class.equals(next.getTargetType())) {
                    return (Interceptor) next.convert(new SignInterceptor(), didiHttpClient);
                }
            }
            return this.mEmptyInterceptor;
        }
    }
}
