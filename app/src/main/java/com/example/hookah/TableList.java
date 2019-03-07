package com.example.hookah;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TableList {

    private List<Table> mTableList;
    private static TableList sTableList;

    public TableList() {
        mTableList = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            mTableList.add(new Table(i));
        }
    }

    public List<Table> getTableList() {
        return mTableList;
    }

    public static TableList get(Context context) {
        if(sTableList == null) {
            sTableList = new TableList();
        }
        return sTableList;
    }
}
