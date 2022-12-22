package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.p146ad.model.AdParams;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.encrypt.Encrypter;
import com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.DFBioassayFailedAct;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.compare.CompareModel;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.compare.CompareParam;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.compare.CompareResult;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed.ReportFailedModel;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed.ReportFailedParam;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed.ReportFailedResult;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessResult;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class CompareHelper {
    public static final String WATER_MARK_FAIL = "-1";
    public static final String WATER_MARK_SUCCESS = "0";

    /* renamed from: a */
    private static final String f47270a = "NO_BEST_PIC";

    /* renamed from: b */
    private static final String f47271b = "ACTION_PIC_NOT_ENOUGH";

    /* renamed from: c */
    private static final String f47272c = "envPic";

    /* renamed from: d */
    private static final String f47273d = "actionPic";

    /* renamed from: e */
    private static final String f47274e = "bestPic";

    /* renamed from: f */
    private static final String f47275f = "markPic";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final DiFaceSelfLivenessActivity f47276g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final GuideResult f47277h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final RoundMaskLiveness f47278i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f47279j;

    /* renamed from: k */
    private int f47280k = 3;

    public CompareHelper(DiFaceSelfLivenessActivity diFaceSelfLivenessActivity, GuideResult guideResult, RoundMaskLiveness roundMaskLiveness) {
        this.f47276g = diFaceSelfLivenessActivity;
        this.f47277h = guideResult;
        this.f47278i = roundMaskLiveness;
        if (guideResult != null && guideResult.data != null && guideResult.data.result != null && guideResult.data.result.getModelParam() != null && guideResult.data.result.getModelParam().getAlive() != null) {
            this.f47280k = guideResult.data.result.getModelParam().getAlive().getPicNum4AntiAttack();
        }
    }

    public void compare(LivenessResult livenessResult) {
        String str;
        String str2;
        String str3;
        try {
            CompareParam compareParam = new CompareParam();
            compareParam.token = this.f47277h.token;
            compareParam.sessionId = DiFaceFacade.getInstance().getSessionId();
            compareParam.language = DiFaceFacade.getInstance().getLanguage();
            HashMap hashMap = new HashMap();
            hashMap.put("model", SystemUtil.getModel());
            hashMap.put(AdParams.USER_AGENT, String.format("Android/%s %s/%s", new Object[]{Build.VERSION.RELEASE, this.f47276g.getApplicationContext().getPackageName(), SystemUtil.getVersionName(this.f47276g.getApplicationContext())}));
            hashMap.put("brand", Build.BRAND);
            ArrayList arrayList = new ArrayList();
            byte[] generateAesKey = Encrypter.generateAesKey();
            hashMap.put("sc", Encrypter.encryptAesKey(generateAesKey));
            ArrayList arrayList2 = new ArrayList();
            List<ILivenessCallback.PicWithScore> bestPicList = livenessResult.getBestPicList();
            Iterator<ILivenessCallback.PicWithScore> it = bestPicList.iterator();
            String str4 = "";
            String str5 = str4;
            while (true) {
                boolean hasNext = it.hasNext();
                str = f47274e;
                if (!hasNext) {
                    break;
                }
                ILivenessCallback.PicWithScore next = it.next();
                arrayList.add(str);
                hashMap.put("faceImageQualityScore", Double.valueOf(next.qualityScore));
                arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(DFileUtils.compressBitmap(next.width, next.height, next.rgba), generateAesKey), "bestPic.jpg"));
                str5 = FileUtils.byteToMD5(next.rgba);
            }
            String str6 = str4;
            for (ILivenessCallback.PicWithScore next2 : livenessResult.getBestActionPicList()) {
                arrayList.add(f47272c);
                hashMap.put("faceImage2QualityScore", Double.valueOf(next2.qualityScore));
                arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(DFileUtils.compressBitmap(next2.width, next2.height, next2.rgba), generateAesKey), "bestActionPic.jpg"));
                str6 = FileUtils.byteToMD5(next2.rgba);
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            List<ILivenessCallback.PicWithScore> attackPicList = livenessResult.getAttackPicList();
            String str7 = str6;
            String str8 = str4;
            Object obj = f47272c;
            int i = 0;
            while (true) {
                str2 = str5;
                str3 = str;
                if (i >= attackPicList.size()) {
                    break;
                }
                ILivenessCallback.PicWithScore picWithScore = attackPicList.get(i);
                List<ILivenessCallback.PicWithScore> list = attackPicList;
                StringBuilder sb = new StringBuilder();
                sb.append(f47273d);
                int i2 = i + 1;
                sb.append(i2);
                String sb2 = sb.toString();
                arrayList.add(sb2);
                List<ILivenessCallback.PicWithScore> list2 = bestPicList;
                String str9 = str4;
                try {
                    jSONArray.put(picWithScore.qualityScore);
                    jSONArray2.put(picWithScore.attackScore);
                } catch (Exception e) {
                    LogUtils.logStackTrace(e);
                }
                int i3 = i2;
                arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(DFileUtils.compressBitmap(picWithScore.width, picWithScore.height, picWithScore.rgba), generateAesKey), sb2 + ".jpg"));
                str8 = str8 + FileUtils.byteToMD5(picWithScore.rgba) + ParamKeys.SIGN_AND;
                str5 = str2;
                str = str3;
                attackPicList = list;
                bestPicList = list2;
                str4 = str9;
                i = i3;
            }
            List<ILivenessCallback.PicWithScore> list3 = bestPicList;
            String str10 = str4;
            List<ILivenessCallback.PicWithScore> list4 = attackPicList;
            hashMap.put("suspectImageQualityScore", jSONArray);
            hashMap.put("suspectImageAttackScore", jSONArray2);
            compareParam.buildExtra(hashMap);
            List<ILivenessCallback.PicWithScore> waterPicList = livenessResult.getWaterPicList();
            byte[] compressBitmap = DFileUtils.compressBitmap(waterPicList.get(0).width, waterPicList.get(0).height, waterPicList.get(0).rgba);
            arrayList.add(f47275f);
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(CompareModel.addJpgSessionId(this.f47276g, compressBitmap, compareParam.sessionId), generateAesKey), "markPic.jpg"));
            if (waterPicList.get(0).qualityOk == 1.0d) {
                compareParam.mark = this.f47277h.data.result.getWaterMarking() + str10;
            } else {
                compareParam.mark = "-1";
            }
            m33886a(compareParam, (List<String>) arrayList, (List<MultiSerializerForAccessSecurity.MemJpg>) arrayList2);
            if (list3.isEmpty()) {
                m33890a(f47270a, "活体检测失败,没有最佳图片");
            }
            int size = list4.size();
            if (size < this.f47280k) {
                m33890a(f47271b, "动作图片与要求不符,（" + size + "/" + this.f47280k + ")");
            }
            if (!TextUtils.isEmpty(str8) && str8.contains(ParamKeys.SIGN_AND)) {
                str8 = str8.substring(0, str8.length() - 1);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bioType", 2);
            hashMap2.put(str3, str2);
            hashMap2.put(f47273d, str8);
            hashMap2.put(obj, str7);
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES, (HashMap<String, Object>) hashMap2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33886a(final CompareParam compareParam, final List<String> list, final List<MultiSerializerForAccessSecurity.MemJpg> list2) {
        RoundMaskLiveness roundMaskLiveness = this.f47278i;
        if (roundMaskLiveness != null) {
            roundMaskLiveness.onFaceOk();
        }
        this.f47276g.changeTipStatus();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH, DiFaceLogger.setBioType((HashMap<String, Object>) null, "3"));
        new CompareModel(this.f47276g).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                if (!CompareHelper.this.f47276g.isFinishing()) {
                    CompareHelper.this.f47278i.cancelRectAnim();
                    CompareHelper.this.f47276g.uploadVideo();
                    int i = compareResult.data.code;
                    String str = compareResult.data.message;
                    String str2 = compareResult.data.result.session_id;
                    new HashMap().put("code", Integer.valueOf(i));
                    DiFaceFacade.getInstance().reportEventWithCode("16", i);
                    if (i == 100000) {
                        CompareHelper.this.f47276g.finishWithResult(new DiFaceResult(0, str));
                        return;
                    }
                    String str3 = compareResult.data.result.show_appeal_entry ? compareResult.data.result.appealInfo.faceSessionId : "";
                    AppealParam appealParam = new AppealParam();
                    appealParam.token = CompareHelper.this.f47277h.token;
                    appealParam.faceSessionId = str3;
                    appealParam.country = CompareHelper.this.f47277h.data.result.country;
                    appealParam.bizCode = CompareHelper.this.f47277h.bizCode;
                    CompareHelper.this.m33885a(i, str, appealParam);
                }
            }

            public void onFailed(int i, String str) {
                if (!CompareHelper.this.f47276g.isFinishing()) {
                    if (CompareHelper.this.f47279j) {
                        boolean unused = CompareHelper.this.f47279j = false;
                        if (!CompareHelper.this.f47276g.isFinishing()) {
                            CompareHelper.this.f47276g.uploadVideo();
                        }
                        CompareHelper.this.f47276g.finishWithResult(new DiFaceResult(3, str));
                    } else if (NetworkUtils.isNetworkConnected(CompareHelper.this.f47276g)) {
                        boolean unused2 = CompareHelper.this.f47279j = true;
                        CompareHelper.this.m33886a(compareParam, (List<String>) list, (List<MultiSerializerForAccessSecurity.MemJpg>) list2);
                    } else {
                        if (!CompareHelper.this.f47276g.isFinishing()) {
                            CompareHelper.this.f47276g.uploadVideo();
                        }
                        CompareHelper.this.m33884a(112, ResUtils.getString(R.string.df_no_net_connected_toast));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33884a(int i, String str) {
        DFBioassayFailedAct.start(this.f47276g, i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33885a(int i, String str, AppealParam appealParam) {
        DFBioassayFailedAct.start(this.f47276g, i, str, appealParam);
    }

    /* renamed from: a */
    private void m33890a(String str, String str2) {
        ReportFailedParam reportFailedParam = new ReportFailedParam();
        reportFailedParam.aliveErrorCode = str;
        reportFailedParam.aliveErrorMsg = str2;
        reportFailedParam.token = this.f47277h.token;
        reportFailedParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        new ReportFailedModel(this.f47276g).report(reportFailedParam, new AbsHttpCallback<ReportFailedResult>() {
            public void onSuccess(ReportFailedResult reportFailedResult) {
                int i = reportFailedResult.data.code;
                String str = reportFailedResult.data.message;
                LogUtils.m33563d("report living failed done, code=" + i + ", msg=" + str);
            }

            public void onFailed(int i, String str) {
                LogUtils.m33563d("report living failed failed, code=" + i + ", msg=" + str);
            }
        });
    }
}
