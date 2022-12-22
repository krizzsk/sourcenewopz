package com.didi.addressold.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.address.cache.CacheManager;
import com.didi.address.util.ApolloUtil;
import com.didi.addressold.util.AddressConvertUtil;
import com.didi.common.map.MapVendor;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sdk.poibase.BaseModel;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommon;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.sdk.poibase.store.PoiStore;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectAddressModel extends BaseModel implements ISelectAddressModel {
    public static final String KEY_CACHE_COMMON_ADDRESS = "ADDRESS";
    public static final String KEY_CACHE_RECOMMEND_POI = "RECOMMEND_POI";
    public static final String KEY_CACHE_START_POI = "START_POI_NEW";

    /* renamed from: a */
    private static final boolean f7757a = true;

    /* renamed from: b */
    private IPoiBaseApi f7758b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CacheManager f7759c;

    /* renamed from: d */
    private Context f7760d;

    public void uploadPoi(AddressParam addressParam, ResultCallback<String> resultCallback) {
    }

    public SelectAddressModel(Context context) {
        super(context);
        this.f7760d = context;
        this.f7758b = PoiBaseApiFactory.createDidiApi(context);
        if (ApolloUtil.useRecCache()) {
            this.f7759c = new CacheManager(context);
        }
    }

    /* renamed from: a */
    private void m4930a(AddressParam addressParam) {
        addressParam.uid = PaxEnvironment.getInstance().getUid();
        addressParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        addressParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        addressParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        addressParam.token = PaxEnvironment.getInstance().getToken();
        addressParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        addressParam.cityId = PaxEnvironment.getInstance().getCityId();
        addressParam.productId = PaxEnvironment.getInstance().getProductId();
        addressParam.mapType = MapVendor.GOOGLE.toString();
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f7760d).getLastKnownLocation();
        if (lastKnownLocation != null) {
            addressParam.user_loc_lat = lastKnownLocation.getLatitude();
            addressParam.user_loc_lng = lastKnownLocation.getLongitude();
            addressParam.accuracy = lastKnownLocation.getAccuracy();
            addressParam.provider = lastKnownLocation.getProvider();
        }
    }

    public void getRecommendPoiList(final AddressParam addressParam, final ResultCallback<RpcRecSug> resultCallback) {
        if (addressParam != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.getRecommendList(addressParam, new IHttpListener<RpcRecSug>() {
                public void onSuccess(RpcRecSug rpcRecSug) {
                    ResultCallback resultCallback;
                    if (rpcRecSug != null && rpcRecSug.errno == 0) {
                        ResultCallback resultCallback2 = resultCallback;
                        if (resultCallback2 != null) {
                            resultCallback2.onSuccess(rpcRecSug);
                        }
                        if (SelectAddressModel.this.f7759c != null) {
                            SelectAddressModel.this.f7759c.storeRecSug(addressParam, rpcRecSug);
                        }
                    } else if ((SelectAddressModel.this.f7759c == null || !SelectAddressModel.this.f7759c.useRecSugCache(addressParam, resultCallback)) && (resultCallback = resultCallback) != null) {
                        resultCallback.onFailure(new IOException("cache fetch error"));
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback;
                    if ((SelectAddressModel.this.f7759c == null || !SelectAddressModel.this.f7759c.useRecSugCache(addressParam, resultCallback)) && (resultCallback = resultCallback) != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public void getSuggestPoiList(AddressParam addressParam, final ResultCallback<RpcRecSug> resultCallback) {
        if (addressParam != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.getTextSearchList(addressParam, new IHttpListener<RpcRecSug>() {
                public void onSuccess(RpcRecSug rpcRecSug) {
                    String str;
                    if (rpcRecSug != null && rpcRecSug.errno == 0) {
                        ResultCallback resultCallback = resultCallback;
                        if (resultCallback != null) {
                            resultCallback.onSuccess(rpcRecSug);
                        }
                    } else if (resultCallback != null) {
                        if (rpcRecSug == null) {
                            str = "rpcRecSug is null";
                        } else {
                            str = "rpcRecSug error no:" + rpcRecSug.errno;
                        }
                        resultCallback.onFailure(new IOException(str));
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public void getGeocodeResult(AddressParam addressParam, RpcPoi rpcPoi, final ResultCallback<RpcRecSug> resultCallback) {
        if (addressParam != null && rpcPoi != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.getGeocodeResult(addressParam, rpcPoi, new IHttpListener<RpcRecSug>() {
                public void onSuccess(RpcRecSug rpcRecSug) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onSuccess(rpcRecSug);
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public void getCommonAddress(AddressParam addressParam, final ResultCallback<RpcCommon> resultCallback) {
        if (addressParam != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.getCommonAddress(addressParam, new IHttpListener<RpcRecSug>() {
                public void onSuccess(RpcRecSug rpcRecSug) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback == null) {
                        return;
                    }
                    if (rpcRecSug == null) {
                        resultCallback.onSuccess(null);
                        return;
                    }
                    RpcCommon convertToCommon = AddressConvertUtil.convertToCommon(SelectAddressModel.this.getContext(), rpcRecSug);
                    SelectAddressModel.this.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), convertToCommon);
                    resultCallback.onSuccess(convertToCommon);
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public void setCommonAddress(final AddressParam addressParam, final RpcPoi rpcPoi, final ResultCallback<RpcCommon> resultCallback) {
        if (addressParam != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.updateCommonAddress(addressParam, rpcPoi, new IHttpListener<HttpResultBase>() {
                public void onSuccess(HttpResultBase httpResultBase) {
                    if (httpResultBase == null || httpResultBase.errno == 0) {
                        RpcCommon commonAddressCache = SelectAddressModel.this.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
                        if (commonAddressCache == null) {
                            commonAddressCache = new RpcCommon();
                            commonAddressCache.errno = 0;
                        }
                        if (commonAddressCache.commonAddresses == null) {
                            commonAddressCache.commonAddresses = new ArrayList<>();
                        }
                        Iterator<RpcCommonPoi> it = commonAddressCache.commonAddresses.iterator();
                        while (it.hasNext()) {
                            RpcCommonPoi next = it.next();
                            if (next != null && next.type == addressParam.addressType) {
                                it.remove();
                            }
                        }
                        RpcCommonPoi recsugToCommon = AddressConvertUtil.recsugToCommon(rpcPoi);
                        recsugToCommon.type = addressParam.addressType;
                        if (recsugToCommon.type == 3) {
                            commonAddressCache.commonAddresses.add(0, recsugToCommon);
                        } else {
                            commonAddressCache.commonAddresses.add(recsugToCommon);
                        }
                        SelectAddressModel.this.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), commonAddressCache);
                        ResultCallback resultCallback = resultCallback;
                        if (resultCallback != null) {
                            resultCallback.onSuccess(commonAddressCache);
                            return;
                        }
                        return;
                    }
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFailure(new IOException(httpResultBase.errmsg));
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public void deleteCommonAddress(final AddressParam addressParam, final ResultCallback<RpcCommon> resultCallback) {
        if (addressParam != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.deleteCommonAddress(addressParam, new IHttpListener<HttpResultBase>() {
                public void onSuccess(HttpResultBase httpResultBase) {
                    if (httpResultBase == null || httpResultBase.errno == 0) {
                        RpcCommon commonAddressCache = SelectAddressModel.this.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
                        if (commonAddressCache == null) {
                            commonAddressCache = new RpcCommon();
                            commonAddressCache.errno = 0;
                        }
                        if (commonAddressCache.commonAddresses == null) {
                            commonAddressCache.commonAddresses = new ArrayList<>();
                        }
                        Iterator<RpcCommonPoi> it = commonAddressCache.commonAddresses.iterator();
                        while (it.hasNext()) {
                            RpcCommonPoi next = it.next();
                            if (next != null && next.type == addressParam.addressType) {
                                it.remove();
                            }
                        }
                        SelectAddressModel.this.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), commonAddressCache);
                        ResultCallback resultCallback = resultCallback;
                        if (resultCallback != null) {
                            resultCallback.onSuccess(commonAddressCache);
                            return;
                        }
                        return;
                    }
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFailure(new IOException(httpResultBase.errmsg));
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public RpcCommon getCommonAddressCache(String str) {
        PoiStore instance = PoiStore.getInstance(getContext());
        String string = instance.getString("ADDRESS" + str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (RpcCommon) new Gson().fromJson(string, RpcCommon.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setCommonAddressCache(String str, RpcCommon rpcCommon) {
        String str2 = "ADDRESS" + str;
        PoiStore instance = PoiStore.getInstance(getContext());
        if (rpcCommon == null) {
            instance.remove(str2);
        } else {
            instance.putAndSave(str2, new Gson().toJson((Object) rpcCommon));
        }
    }

    public void setRecommendPoiCache(int i, ArrayList<RpcPoi> arrayList) {
        String str = "RECOMMEND_POI" + i;
        PoiStore instance = PoiStore.getInstance(getContext());
        if (arrayList == null) {
            instance.remove(str);
        } else {
            instance.putAndSave(str, new Gson().toJson((Object) arrayList));
        }
    }

    public ArrayList<RpcPoi> getRecommendPoisCache(int i) {
        PoiStore instance = PoiStore.getInstance(getContext());
        String string = instance.getString("RECOMMEND_POI" + i, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (ArrayList) new Gson().fromJson(string, new TypeToken<ArrayList<RpcPoi>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void getStartPoiInfo(AddressParam addressParam, final IHttpListener<ReverseGeoResult> iHttpListener) {
        ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        reverseGeoParam.mapType = addressParam.mapType;
        reverseGeoParam.select_lat = addressParam.currentAddress.latitude;
        reverseGeoParam.select_lng = addressParam.currentAddress.longitude;
        reverseGeoParam.user_loc_lat = addressParam.currentAddress.latitude;
        reverseGeoParam.user_loc_lng = addressParam.currentAddress.longitude;
        reverseGeoParam.accuracy = addressParam.currentAddress.accuracy;
        reverseGeoParam.callFrom = CallFrom.SUG_PACKING_PROMPT;
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
        reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        reverseGeoParam.provider = addressParam.currentAddress.provider;
        DLog.m7384d("SelectAddressModel", "old getStartPoiInfo params reverseGeo: " + reverseGeoParam, new Object[0]);
        this.f7758b.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                RpcPoi rpcPoi;
                if (!(reverseGeoResult == null || reverseGeoResult.result == null || reverseGeoResult.result.isEmpty() || (rpcPoi = reverseGeoResult.result.get(0)) == null)) {
                    Address address = new Address();
                    String string = SelectAddressModel.this.getContext().getResources().getString(R.string.global_sug_current_location);
                    if (rpcPoi.base_info.displayname.equals(string)) {
                        address.displayName = string;
                        address.address = string;
                        address.fullName = string;
                    } else {
                        address.displayName = rpcPoi.base_info.displayname;
                        address.address = rpcPoi.base_info.address;
                        address.fullName = rpcPoi.base_info.addressAll;
                    }
                    address.latitude = rpcPoi.base_info.lat;
                    address.longitude = rpcPoi.base_info.lng;
                    address.poiId = rpcPoi.base_info.poi_id;
                    address.uid = rpcPoi.base_info.poi_id;
                    address.cityId = rpcPoi.base_info.city_id;
                    address.cityName = rpcPoi.base_info.city_name;
                    address.countryID = rpcPoi.base_info.countryId;
                    address.hideAddress = rpcPoi.base_info.hide_address;
                    SelectAddressModel.this.cacheStartPoiInfo(address);
                }
                IHttpListener iHttpListener = iHttpListener;
                if (iHttpListener != null) {
                    iHttpListener.onSuccess(reverseGeoResult);
                }
            }

            public void onFail(IOException iOException) {
                IHttpListener iHttpListener = iHttpListener;
                if (iHttpListener != null) {
                    iHttpListener.onFail(iOException);
                }
            }
        });
    }

    public void cacheStartPoiInfo(Address address) {
        PoiStore instance = PoiStore.getInstance(getContext());
        if (address != null) {
            instance.putJsonObj("START_POI_NEW" + address.longitude + address.latitude, address);
        }
    }

    public Address getStartPoiInfoFromCache(Address address) {
        if (address == null) {
            return null;
        }
        PoiStore instance = PoiStore.getInstance(getContext());
        return (Address) instance.getJsonObj("START_POI_NEW" + address.longitude + address.latitude, Address.class);
    }

    public void recordClickPoi(AddressParam addressParam, RpcPoiBaseInfo rpcPoiBaseInfo) {
        if (addressParam != null && rpcPoiBaseInfo != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.recordClickPoi(addressParam, rpcPoiBaseInfo, new IHttpListener<HttpResultBase>() {
                public void onSuccess(HttpResultBase httpResultBase) {
                    if (httpResultBase == null) {
                        SystemUtils.log(6, "xu", "recordClickPoi failed", (Throwable) null, "com.didi.addressold.model.SelectAddressModel$9", 564);
                    } else if (httpResultBase.errno != 0) {
                        SystemUtils.log(6, "xu", "recordClickPoi failed: " + httpResultBase.toString(), (Throwable) null, "com.didi.addressold.model.SelectAddressModel$9", 561);
                    }
                }

                public void onFail(IOException iOException) {
                    SystemUtils.log(6, "xu", "recordClickPoi failed: " + iOException.getMessage(), (Throwable) null, "com.didi.addressold.model.SelectAddressModel$9", 570);
                }
            });
        }
    }

    public void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z, final ResultCallback<HttpResultBase> resultCallback) {
        if (addressParam != null && this.f7758b != null) {
            m4930a(addressParam);
            this.f7758b.updateFavoritePlace(addressParam, rpcCommonPoi, z, new IHttpListener<HttpResultBase>() {
                public void onSuccess(HttpResultBase httpResultBase) {
                    if (httpResultBase == null || httpResultBase.errno == 0) {
                        ResultCallback resultCallback = resultCallback;
                        if (resultCallback != null) {
                            resultCallback.onSuccess(httpResultBase);
                            return;
                        }
                        return;
                    }
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFailure(new IOException(httpResultBase.errmsg));
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }

    public void deleteFavoritePlace(AddressParam addressParam, final String str, final ResultCallback<RpcCommon> resultCallback) {
        if (addressParam != null && this.f7758b != null && !TextUtils.isEmpty(str)) {
            m4930a(addressParam);
            this.f7758b.deleteFavoritePlace(addressParam, str, new IHttpListener<HttpResultBase>() {
                public void onSuccess(HttpResultBase httpResultBase) {
                    if (httpResultBase == null || httpResultBase.errno == 0) {
                        RpcCommon commonAddressCache = SelectAddressModel.this.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
                        if (commonAddressCache == null) {
                            commonAddressCache = new RpcCommon();
                            commonAddressCache.errno = 0;
                        }
                        if (commonAddressCache.commonAddresses == null) {
                            commonAddressCache.commonAddresses = new ArrayList<>();
                        }
                        Iterator<RpcCommonPoi> it = commonAddressCache.commonAddresses.iterator();
                        while (it.hasNext()) {
                            RpcCommonPoi next = it.next();
                            if (next != null && str.equals(next.primaryId)) {
                                it.remove();
                            }
                        }
                        SelectAddressModel.this.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), commonAddressCache);
                        ResultCallback resultCallback = resultCallback;
                        if (resultCallback != null) {
                            resultCallback.onSuccess(commonAddressCache);
                            return;
                        }
                        return;
                    }
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 != null) {
                        resultCallback2.onFailure(new IOException(httpResultBase.errmsg));
                    }
                }

                public void onFail(IOException iOException) {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onFailure(iOException);
                    }
                }
            });
        }
    }
}
