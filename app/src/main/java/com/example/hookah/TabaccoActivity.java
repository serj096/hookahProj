package com.example.hookah;

import android.support.v4.app.Fragment;

public class TabaccoActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TabaccoFragment();
    }
}
