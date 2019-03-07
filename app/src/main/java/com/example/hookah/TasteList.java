package com.example.hookah;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
public class TasteList  {


        private List<Taste> mTasteList;
        private static TasteList sTasteList;

        public TasteList() {
            mTasteList = new ArrayList<>();
            for(int i = 1; i <= 3; i++) {
                mTasteList.add(new Taste("Taste " + i));
            }
        }

        public List<Taste> getTasteList() {
            return mTasteList;
        }

        public static TasteList get(Context context) {
            if(sTasteList == null) {
                sTasteList = new TasteList();
            }
            return sTasteList;
        }
    }

