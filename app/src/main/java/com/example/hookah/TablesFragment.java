package com.example.hookah;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TablesFragment extends Fragment {

    private final static String TAG = "mTest";

    private RecyclerView mRecycleView;
    private TablesAdapter mTablesAdapter;
    private List<Table> mTableList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tables_list, container, false);

        mRecycleView = (RecyclerView) view.findViewById(R.id.tables_recycle_view);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mTableList = new ArrayList<>();
        mTableList = TableList.get(getActivity()).getTableList();

        Log.i(TAG, "Table list: " + mTableList.get(0) + " " + mTableList.get(1) + " " + mTableList.get(2));

        if(mTablesAdapter == null) {
            mTablesAdapter = new TablesAdapter(mTableList);
            mRecycleView.setAdapter(mTablesAdapter);
        }

        return view;
    }

    private class TablesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Table mTable;
        private TextView mTitleTextView;

        public TablesHolder (View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_table_title_text_view);
        }

        public void bindTable(Table table) {
            mTable = table;
            mTitleTextView.setText(mTable.getTitle());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), TabaccoActivity.class);
            startActivity(intent);
        }
    }

    private class TablesAdapter extends RecyclerView.Adapter<TablesHolder> {

        private List<Table> mTables;

        @Override
        public int getItemCount() {
            return mTables.size();
        }

        public TablesAdapter(List<Table> mTableList) {
            mTables = mTableList;
        }

        @Override
        public void onBindViewHolder(@NonNull TablesHolder tablesHolder, int position) {
            Table table = mTables.get(position);
            tablesHolder.bindTable(table);
        }

        @NonNull
        @Override
        public TablesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater= LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_table, viewGroup, false);
            return new TablesHolder(view);
        }
    }
}
