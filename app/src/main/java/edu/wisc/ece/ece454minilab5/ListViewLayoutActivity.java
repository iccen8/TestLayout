package edu.wisc.ece.ece454minilab5;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewLayoutActivity extends ListActivity {

    private ArrayAdapter<String> mAdapter;
    //private ArrayList<String> FOLKS = new ArrayList<String>(Arrays.asList("studentA", "studentB", "studentC", "studentD"));
    private ArrayList<String> newFolks = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_list_view_layout);

        loadNameData();

        // Define a new adapter
        mAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_list_view_layout, newFolks);


        // Assign the adapter to ListView
        setListAdapter(mAdapter);

        // Define the listener interface
        OnItemClickListener mListener = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Your code here...
                //System.out.println("position is: " + position + " id is: " + id + " " + FOLKS.get(position));
                String toastMsg = mAdapter.getItem(position) + " is removed from the list!";
                mAdapter.remove(mAdapter.getItem(position));
                mAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),
                        toastMsg, Toast.LENGTH_SHORT).show();

                saveNameData();
            }
        };



        // Get the ListView and wired the listener
        ListView listView = getListView();
        listView.setOnItemClickListener(mListener);

    }

    public void onClickedAddName(View v){
        String mValue = (String) ((EditText) findViewById(R.id.editNewName))
                .getText().toString();
        mAdapter.add(mValue);
        mAdapter.notifyDataSetChanged();
        saveNameData();

    }

    private void saveNameData(){

        String mKey = "my_shared_names";
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.clear();

        for(int i=0; i<mAdapter.getCount(); i++){
            mKey = "new_name" + i;
            String mValue = mAdapter.getItem(i);
            mEditor.putString(mKey, mValue);
        }

        mEditor.commit();

    }

    private void loadNameData(){

        String mKey = "my_shared_names";
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        int counter = 0;

        mKey = "new_name" + counter;
        String mValue = mPrefs.getString(mKey, "");

        while(!mValue.equals("")){
            mKey = "new_name" + counter;
            mValue = mPrefs.getString(mKey, "");
            newFolks.add(mValue);

            counter++;
        }

    }


}