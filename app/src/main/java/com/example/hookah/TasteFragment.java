package com.example.hookah;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TasteFragment extends Fragment {

    private RecyclerView mTasteRecyclerView;
    private TasteAdapter mTasteAdapter;
    private List<Taste> mTasteList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.taste,container,false);

        mTasteRecyclerView = (RecyclerView)view.findViewById(R.id.taste_recycler);
        mTasteRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        mTasteList = new ArrayList<>();
        mTasteList = TasteList.get(getActivity()).getTasteList();
        if(mTasteAdapter == null) {
            mTasteAdapter = new TasteAdapter(mTasteList);
            mTasteRecyclerView.setAdapter(mTasteAdapter);
        }

        return view;
    }

    private class TasteHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitleTextView;
        private Taste mTaste;

        public TasteHolder (View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_taste_title_text_view);
        }

        public void bindTaste(Taste taste) {
            mTaste = taste;
            mTitleTextView.setText(mTaste.getTitle());
        }

        @Override
        public void onClick(View v) {

        }
    }


    private class TasteAdapter extends RecyclerView.Adapter<TasteHolder> {

        private List<Taste> mTastes;

        @Override
        public int getItemCount() {
            return mTastes.size();
        }

        public TasteAdapter(List<Taste> mTasteList) {
            mTastes = mTasteList;
        }

        @NonNull
        @Override
        public TasteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_taste,viewGroup,false);
            return new TasteHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TasteHolder tastesHolder, int position) {
            Taste taste = mTastes.get(position);
            tastesHolder.bindTaste(taste);
        }

    }


}
