package com.luyunfeng.resourcehelper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

/**
 * Created by luyunfeng on 2017/1/10.
 */

public class ResourceHelper {

    private static Resources resources;

    public static void init(Context context) {
        resources = context.getResources();
    }

    public static Resources getResources() {
        return resources;
    }

    public static float getDimension(int resId) {
        return resources.getDimension(resId);
    }

    public static int getDimensionPixelSize(int resId) {
        return resources.getDimensionPixelSize(resId);
    }

    public static String getString(@StringRes int resId) {
        return resources.getString(resId);
    }

    public static String[] getStringArray(@ArrayRes int resId) {
        return resources.getStringArray(resId);
    }

    public static int getColor(int resId) {
        return resources.getColor(resId);
    }

    public static Drawable getDrawable(int resId) {
        return resources.getDrawable(resId);
    }

    public static int getIdentifier(String name, @IdentifierType String type) {
        return resources.getIdentifier(name, type, BuildConfig.APPLICATION_ID);
    }
}
