package com.didi.zxing.barcodescanner;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.util.DecodeConfigUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public class DefaultDecoderFactory implements DecoderFactory {

    /* renamed from: a */
    private Collection<BarcodeFormat> f45283a;

    /* renamed from: b */
    private Map<DecodeHintType, Object> f45284b;

    /* renamed from: c */
    private String f45285c;

    /* renamed from: d */
    private boolean f45286d;

    public DefaultDecoderFactory() {
        this("");
    }

    public DefaultDecoderFactory(String str) {
        this.f45285c = "utf-8";
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.f45284b = enumMap;
        enumMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        ArrayList arrayList = new ArrayList();
        this.f45283a = arrayList;
        arrayList.add(BarcodeFormat.QR_CODE);
        C14921Util.addExtraBarcodeFormats(str, this.f45283a);
    }

    public DefaultDecoderFactory(Collection<BarcodeFormat> collection, Map<DecodeHintType, Object> map, String str, boolean z) {
        this.f45283a = collection;
        this.f45284b = map;
        this.f45285c = str;
        this.f45286d = z;
    }

    public Decoder createDecoder(Map<DecodeHintType, ?> map) {
        int binarizerType;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map<DecodeHintType, Object> map2 = this.f45284b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        if (this.f45283a != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, this.f45283a);
        } else {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, new ArrayList());
        }
        if (this.f45285c != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, this.f45285c);
        }
        DecodeOptions decodeOptions = new DecodeOptions();
        DecodeConfig config = DecodeConfigUtil.getConfig();
        decodeOptions.binarizer = BinarizerEnum.CommixtureWithOpenCV;
        if (config != null && (binarizerType = config.binarizerType()) > -1 && binarizerType < BinarizerEnum.values().length) {
            decodeOptions.binarizer = BinarizerEnum.values()[binarizerType];
        }
        decodeOptions.baseHints = enumMap;
        decodeOptions.decodeFormats = this.f45283a;
        return new Decoder(decodeOptions, this.f45286d);
    }

    public void setDecodeFormats(Collection<BarcodeFormat> collection) {
        this.f45283a = collection;
    }
}
