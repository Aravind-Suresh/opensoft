package com.example.opensoft;

import android.content.Context;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Arvind on 24-01-2015.
 */

public class adapter_list_element extends RecyclerView.Adapter<adapter_list_element.ListItemViewHolder> {

    private List<ListElement> items;
    static Context c;

    adapter_list_element(List<ListElement> modelData, Context c) {
        if (modelData == null) {
            throw new IllegalArgumentException(
                    "modelData must not be null");
        }
        this.items = modelData;
        this.c = c;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.layout_list_element,
                        viewGroup,
                        false);
        return new ListItemViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(ListItemViewHolder viewHolder, int position) {
        viewHolder.currentItem = items.get(position);
        ListElement model = items.get(position);
        viewHolder.txtTitle.setText(model.title);
        viewHolder.txtInfo.setText(model.info);
        viewHolder.imgViewIcon.setImageResource(R.drawable.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<ListElement> getList() {
        return items;
    }

    public final static class ListItemViewHolder
            extends RecyclerView.ViewHolder {
        ImageView imgViewIcon;
        TextView txtTitle;
        TextView txtInfo;

        public ListElement currentItem;

        public ListItemViewHolder(final View itemView) {
            super(itemView);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.icon);
            txtInfo = (TextView) itemView.findViewById(R.id.info);
            txtTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}