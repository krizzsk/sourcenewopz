package com.appsflyer.internal;

import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.util.HashMap;

class a$4 extends HashMap<String, String> {
    public a$4() {
        put("0", "ro.arch");
        put("1", "ro.chipname");
        put("2", "ro.dalvik.vm.native.bridge");
        put("3", "persist.sys.nativebridge");
        put("4", "ro.enable.native.bridge.exec");
        put("5", "dalvik.vm.isa.x86.features");
        put("6", "dalvik.vm.isa.x86.variant");
        put("7", "ro.zygote");
        put("8", "ro.allow.mock.location");
        put("9", "ro.dalvik.vm.isa.arm");
        put("10", "dalvik.vm.isa.arm.features");
        put("11", "dalvik.vm.isa.arm.variant");
        put("12", "dalvik.vm.isa.arm64.features");
        put(DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS, "dalvik.vm.isa.arm64.variant");
        put("14", "vzw.os.rooted");
        put(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH, "ro.build.user");
        put("16", "ro.kernel.qemu");
        put(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, "ro.hardware");
        put(DiFaceLogger.EVENT_ID_ENTER_APPEAL_DIALOG, "ro.product.cpu.abi");
        put(DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL, "ro.product.cpu.abilist");
        put("20", "ro.product.cpu.abilist32");
        put(ScarShareReportModel.CHANNEL_FACEBOOK, "ro.product.cpu.abilist64");
    }
}
