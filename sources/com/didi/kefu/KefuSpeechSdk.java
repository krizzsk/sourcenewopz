package com.didi.kefu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.sdk.webview.Constant;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.speech.asr.AsrLogger;
import com.didi.speech.asr.MediaIdPlay;
import com.didi.speech.asr.VoiceClientStatusChangeListener;
import com.didi.speech.asr.VoiceRecognitionClient;
import com.taxis99.R;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class KefuSpeechSdk implements VoiceClientStatusChangeListener {
    private static final String TAG = "SpeechRecorder";
    /* access modifiers changed from: private */
    public SpeechCorpus corpus;
    private ImageView leftWaveImageView;
    /* access modifiers changed from: private */
    public AsrSpeechCallBack mCallBackMethod;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mCounterVolume = 0;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public int mSpeechClientErrorID = 0;
    private long mSpeechStartRecordTime = 0;
    private VoiceRecognitionClient mVoiceClient;
    /* access modifiers changed from: private */
    public View oldSpeechTips;
    private EditText oldpartialView;
    FileOutputStream outputStream = null;
    private ImageView rightWaveImageView;

    public void onClientStatusChange(int i, final Object obj) {
        switch (i) {
            case 1001:
                this.corpus = new SpeechCorpus(this.mContext.getApplicationContext(), (Bundle) obj);
                try {
                    this.outputStream = new FileOutputStream(this.corpus.getTransFilePath());
                    return;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
            case 1003:
                showRmsAction(((Float) obj).floatValue());
                return;
            case 1004:
                FileOutputStream fileOutputStream = this.outputStream;
                if (fileOutputStream != null) {
                    try {
                        byte[] bArr = (byte[]) obj;
                        if (bArr != null && bArr.length > 0) {
                            fileOutputStream.write(bArr);
                            return;
                        }
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                } else {
                    return;
                }
            case 1005:
                onEndOfSpeech();
                return;
            case 1006:
                onPartialResults((Bundle) obj);
                return;
            case 1007:
                onEndOfSpeech();
                new Thread() {
                    public void run() {
                        super.run();
                        if (KefuSpeechSdk.this.corpus != null && KefuSpeechSdk.this.corpus.save(UUID.randomUUID().toString()) && KefuSpeechSdk.this.mHandler != null) {
                            Message obtainMessage = KefuSpeechSdk.this.mHandler.obtainMessage(2);
                            obtainMessage.obj = obj;
                            KefuSpeechSdk.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                }.start();
                return;
            default:
                return;
        }
    }

    public void onError(int i, int i2, Object obj) {
        String str;
        onEndOfSpeech();
        int i3 = 4;
        if (3005 == i2) {
            i = 4;
        }
        boolean z = true;
        if (i == 1) {
            str = this.mContext.getString(R.string.record_error);
            i3 = 1;
        } else if (i != 2) {
            if (i == 3) {
                str = this.mContext.getString(R.string.network_timed_out);
                i3 = 3;
            } else if (i != 4) {
                str = "";
                i3 = 0;
            } else {
                str = this.mContext.getString(R.string.volume_too_small);
            }
            z = false;
        } else {
            str = this.mContext.getString(R.string.check_net);
            i3 = 2;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ((Bundle) obj).get("asr_sid"));
            jSONObject.put("err_num", "" + i3);
            jSONObject.put("err_info", str);
            if (this.mHandler != null) {
                this.mHandler.removeMessages(0);
            }
            if (z) {
                jSONObject.put("time", "");
                this.mCallBackMethod.voiceLocalFinish(jSONObject);
                return;
            }
            jSONObject.put(ParamConst.WORD, "");
            this.mCallBackMethod.voiceUploadFinish(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public KefuSpeechSdk(AsrSpeechCallBack asrSpeechCallBack, Activity activity) {
        this.mCallBackMethod = asrSpeechCallBack;
        Context applicationContext = activity.getApplicationContext();
        this.mContext = applicationContext;
        View inflate = View.inflate(applicationContext, R.layout.touch_asr_popup, (ViewGroup) null);
        this.oldSpeechTips = inflate;
        this.oldpartialView = (EditText) inflate.findViewById(R.id.speech_partial_view);
        this.leftWaveImageView = (ImageView) this.oldSpeechTips.findViewById(R.id.leftWave);
        this.rightWaveImageView = (ImageView) this.oldSpeechTips.findViewById(R.id.rightWave);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.oldSpeechTips.setVisibility(8);
        activity.addContentView(this.oldSpeechTips, layoutParams);
        this.mVoiceClient = VoiceRecognitionClient.getInstance(this.mContext);
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void dispatchMessage(Message message) {
                super.dispatchMessage(message);
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        KefuSpeechSdk.this.oldSpeechTips.setVisibility(0);
                    } else if (i == 2) {
                        try {
                            String fileSid = KefuSpeechSdk.this.corpus.getFileSid();
                            float transFileLength = KefuSpeechSdk.this.corpus.getTransFileLength() + 0.5f;
                            if (transFileLength <= 1.0f) {
                                transFileLength = 1.0f;
                            }
                            if (transFileLength > 60.0f) {
                                transFileLength = 60.0f;
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", fileSid);
                            jSONObject.put("time", String.format("%.0f", new Object[]{Float.valueOf(transFileLength)}));
                            jSONObject.put("err_num", "0");
                            jSONObject.put("err_info", KefuSpeechSdk.this.mContext.getString(R.string.save_success));
                            KefuSpeechSdk.this.mCallBackMethod.voiceLocalFinish(jSONObject);
                            KefuSpeechSdk.this.onResults((Bundle) message.obj, KefuSpeechSdk.this.corpus.getFileSid());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (KefuSpeechSdk.this.mSpeechClientErrorID < 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", "");
                        jSONObject2.put("time", "");
                        jSONObject2.put("err_num", "4");
                        jSONObject2.put("err_info", KefuSpeechSdk.this.mContext.getString(R.string.volume_too_small));
                        KefuSpeechSdk.this.mCallBackMethod.voiceLocalFinish(jSONObject2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
    }

    public void showRmsAction(float f) {
        if (this.mCounterVolume % 8 == 0) {
            double d = (double) f;
            if (d < 0.05d) {
                this.leftWaveImageView.setImageResource(R.drawable.dd_asr_left_now1);
                this.rightWaveImageView.setImageResource(R.drawable.dd_asr_right_now1);
            } else if (d < 0.1d) {
                this.leftWaveImageView.setImageResource(R.drawable.dd_asr_left_now2);
                this.rightWaveImageView.setImageResource(R.drawable.dd_asr_right_now2);
            } else if (d < 0.15d) {
                this.leftWaveImageView.setImageResource(R.drawable.dd_asr_left_now3);
                this.rightWaveImageView.setImageResource(R.drawable.dd_asr_right_now3);
            } else if (d < 0.2d) {
                this.leftWaveImageView.setImageResource(R.drawable.dd_asr_left_now4);
                this.rightWaveImageView.setImageResource(R.drawable.dd_asr_right_now4);
            } else {
                this.leftWaveImageView.setImageResource(R.drawable.dd_asr_left_now5);
                this.rightWaveImageView.setImageResource(R.drawable.dd_asr_right_now5);
            }
        }
    }

    public void onEndOfSpeech() {
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
                this.outputStream = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onResults(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (this.oldSpeechTips.getVisibility() == 0) {
            stopViewRecord();
        }
        if (this.mSpeechClientErrorID >= 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put(ParamConst.WORD, stringArrayList.get(0));
                jSONObject.put("err_num", "0");
                jSONObject.put("err_info", this.mContext.getString(R.string.success));
                this.mCallBackMethod.voiceUploadFinish(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onPartialResults(Bundle bundle) {
        String str;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("results_recognition");
        if (stringArrayList.size() > 0) {
            String str2 = "";
            for (int i = 0; i < stringArrayList.size(); i++) {
                str2 = str2 + stringArrayList.get(i);
            }
            int length = str2.length();
            if (length < 12) {
                str = str2;
            } else if (length < 24) {
                str = str2.substring(0, 12) + "\n" + str2.substring(12, length);
            } else {
                int i2 = length - 12;
                str = str2.substring(length - 24, i2) + "\n" + str2.substring(i2, length);
            }
            this.oldpartialView.setText(str);
            this.mCallBackMethod.getPartialResults(str2);
            AsrLogger.logD(TAG, bundle.toString());
        }
    }

    public void cancel() {
        VoiceRecognitionClient voiceRecognitionClient = this.mVoiceClient;
        if (voiceRecognitionClient != null) {
            voiceRecognitionClient.cancelRecognition();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
            this.mHandler.removeMessages(0);
        }
        dismissView();
    }

    public void destroy() {
        VoiceRecognitionClient voiceRecognitionClient = this.mVoiceClient;
        if (voiceRecognitionClient != null) {
            voiceRecognitionClient.releaseInstance();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler = null;
        }
        dismissView();
    }

    private void dismissView() {
        View view = this.oldSpeechTips;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void palyVoice(JSONObject jSONObject) {
        SpeechCorpus speechCorpus = new SpeechCorpus(this.mContext);
        if (jSONObject != null) {
            try {
                speechCorpus.play(jSONObject.getString("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void startViewRecord(JSONObject jSONObject) {
        String str;
        stopPlayVoice();
        this.mSpeechStartRecordTime = System.currentTimeMillis();
        this.mSpeechClientErrorID = 0;
        if (jSONObject != null) {
            try {
                str = jSONObject.getString("url");
            } catch (JSONException e) {
                e.printStackTrace();
                str = "";
            }
            try {
                int i = jSONObject.getInt("pid");
                JSONObject jSONObject2 = jSONObject.getJSONObject("chatInfo");
                Intent intent = new Intent();
                intent.putExtra(Constant.EXTRA_NEED_CORPUS_STORE, true);
                intent.putExtra("pid", i);
                intent.putExtra(Constant.EXTRA_APP_PARAM, jSONObject2.toString());
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("url", str);
                }
                this.oldpartialView.setText(R.string.startChat);
                intent.putExtra("vad_is_on", 0);
                intent.putExtra(Constant.EXTRA_SOUND_START, -1);
                intent.putExtra(Constant.EXTRA_SOUND_END, -1);
                intent.putExtra("isLimit", true);
                this.mVoiceClient.startRecognition(intent, this);
                this.mHandler.sendEmptyMessageDelayed(1, 300);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void stopViewRecord() {
        this.mVoiceClient.stopRecognition();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
        if (System.currentTimeMillis() - this.mSpeechStartRecordTime < 500) {
            this.mSpeechClientErrorID = -2;
            this.mHandler.sendEmptyMessageDelayed(0, 500);
        }
        this.oldSpeechTips.setVisibility(8);
    }

    public void stopPlayVoice() {
        dismissView();
        MediaIdPlay.stop();
        new SpeechCorpus(this.mContext).stop();
    }
}
