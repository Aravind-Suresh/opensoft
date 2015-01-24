package com.example.opensoft;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        adapter_list_element adapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setHasFixedSize(true);

            List<ListElement> data= new ArrayList<ListElement>();
            data.add(new ListElement("first","caption"));
            data.add(new ListElement("second"));

            final adapter_list_element adapterListElement = new adapter_list_element(data,rootView.getContext());
            recyclerView.setAdapter(adapterListElement);
            this.adapter = adapterListElement;

            EditText edit_search = (EditText) rootView.findViewById(R.id.search_bar);
            edit_search.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    adapter = filter_adapter(adapterListElement, charSequence, rootView.getContext());
                    //adapterListElement.notifyDataSetChanged();
                    recyclerView.swapAdapter(adapter, false);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            return rootView;
        }

        private adapter_list_element filter_adapter(adapter_list_element adapterListElement, CharSequence charSequence, Context c) {

            List<ListElement> list = adapterListElement.getList();
            List<ListElement> list_filtered = new ArrayList<ListElement>();
            for(ListElement l : list) {
                if(l.info.contains(charSequence) || l.info.contains(charSequence)) {
                    list_filtered.add(l);
                }
            }
            return new adapter_list_element(list_filtered, c);
        }
    }
}
