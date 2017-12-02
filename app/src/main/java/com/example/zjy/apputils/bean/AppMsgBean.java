package com.example.zjy.apputils.bean;

import android.graphics.drawable.Drawable;

/**
 * 描述：
 * 作者：zjy on 2017/12/2 15:02
 */

public class AppMsgBean {
    private Drawable appImage;
    private String packageName;
    private String versionCode;
    private String versionName;
    private String appName;

    public Drawable getAppImage() {
        return appImage;
    }

    public void setAppImage(Drawable appImage) {
        this.appImage = appImage;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "AppMsgBean{" +
                "appImage='" + appImage + '\'' +
                ", packageName='" + packageName + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
