package com.enterpriseandroid.restfulcontacts;

import java.util.List;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Prefs activity is launched by base activity when an item is selected.
 * Created using Contact example refactored to sprite by author.
 * @author Calvin Williams
 */
public class PrefsActivity extends PreferenceActivity {

    /**
     * Gets some text preferences from xml file which grabs from strings file
     */
    public static class SyncPrefs extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefs);
        }
    }

    /**
     * adds preferences from xml file which grabs from strings file.
     * @param savedInstanceState
     */
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            addPreferencesFromResource(R.xml.prefs);
        }
    }

    /**
     * Loads header frag
     * @param target
     */
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_headers, target);
    }
}
