package ru.spbstu.abit.core.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/* Singleton Instance */
public class PreferencesStorage {
    private static PreferencesStorage sharePref = new PreferencesStorage();

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private static final String PLACE_OBJ = "place_obj";

    private PreferencesStorage() {} //prevent creating multiple instances by making the constructor private

    //The context passed into the getInstance should be application level context.
    public static PreferencesStorage getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(
                    context.getPackageName(),
                    Activity.MODE_PRIVATE
            );
            editor = sharedPreferences.edit();
        }

        return sharePref;
    }

    public void save(String placeObjStr) {
        editor.putString(PLACE_OBJ, placeObjStr);
        editor.commit();
    }

    public String get() {
        return sharedPreferences.getString(PLACE_OBJ, "");
    }

    public void remove() {
        editor.remove(PLACE_OBJ);
        editor.commit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
