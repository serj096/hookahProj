package com.example.hookah;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TasteActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TasteFragment();
    }
}
