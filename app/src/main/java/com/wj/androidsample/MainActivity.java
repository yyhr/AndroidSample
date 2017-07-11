package com.wj.androidsample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<String> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv_activity_main_content);
        data.add("Activity Ani");
        mListView.setAdapter(new MyAdapter(this,data));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = data.get(position);
                if (item.compareTo("Activity Ani")==0){
                    Intent intent = new Intent(MainActivity.this,AniSwitchActivity.class);
                    startActivity(intent);
                }
            }
        });
        
    }
    class MyAdapter extends BaseAdapter{

        private Context mContext;
        private ArrayList<String> data;
        public MyAdapter(Context context,ArrayList<String> data){
            mContext = context;
            this.data = data;
        }
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = null;
            if(convertView==null){
                view = new TextView(mContext);
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        (int) TypedValue.applyDimension(COMPLEX_UNIT_DIP,45,mContext.getResources().getDisplayMetrics()));
                view.setGravity(Gravity.CENTER_VERTICAL);
                view.setLayoutParams(layoutParams);
                
            }else{
                view = (TextView) convertView;
            }
            view.setText(data.get(position));
            return view;
        }
    }
}
