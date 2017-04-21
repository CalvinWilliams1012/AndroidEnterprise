package com.enterpriseandroid.restfulcontacts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.enterpriseandroid.restfulcontacts.data.SpritesContract;


/**
 * Base activity which is used for other activitys to extend from.
 * Created using Contact example refactored to sprite by author.
 * @author Calvin Williams
 */
@SuppressLint("Registered")
public class BaseActivity extends Activity {
    private static final String TAG = "BASE";

    private static final SparseIntArray STATUS_COLOR_MAP;
    static {
        SparseIntArray a = new SparseIntArray();
        a.put(SpritesContract.STATUS_OK, Color.GREEN);
        a.put(SpritesContract.STATUS_SYNC, Color.YELLOW);
        a.put(SpritesContract.STATUS_DIRTY, Color.RED);
        STATUS_COLOR_MAP = a;
    }

    /**
     * Sets the background color
     * @param status
     * @param view
     */
    protected static void setStatusBackground(int status, View view) {
        int color = STATUS_COLOR_MAP.get(status);
        view.setBackgroundColor((0 != color) ? color : Color.BLACK);
    }

    /**
     * onCreate for the menu, inflates the menu and returns true
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * When an item is selected ( only one item in case) start the prefs activity with this context return true.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_prefs:
                startActivity(new Intent(this, PrefsActivity.class));
                break;

            default:
                Log.i(TAG, "Unrecognized menu item: " + item);
                return false;
        }

        return true;
    }
}
