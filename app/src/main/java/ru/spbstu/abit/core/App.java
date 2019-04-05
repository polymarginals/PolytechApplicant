package ru.spbstu.abit.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }

    public static int getColorId(int colorId) {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                ? getContext().getColor(colorId)
                : getContext().getResources().getColor(colorId);
    }
}
