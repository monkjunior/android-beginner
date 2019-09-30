package com.example.gmail;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomIconLabelAdapter extends ArrayAdapter<String> {
    Context context;
    Integer[] thumbnails;
    String[] receivers;
    String[] mails;
    public CustomIconLabelAdapter( Context context, int layoutToBeInflated,
                                   String[] receivers, String[] mails,Integer[] thumbnails) {
        super(context, R.layout.custom_row, receivers);
        this.context = context;
        this.thumbnails = thumbnails;
        this.receivers = receivers;
        this.mails = mails;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_row, null);

        ImageView avatar = (ImageView) row.findViewById(R.id.avatar);
        TextView receiver = (TextView) row.findViewById(R.id.receiver);
        TextView mail = (TextView) row.findViewById(R.id.mail);

        receiver.setText(receivers[position]);
        mail.setText(mails[position]);
        avatar.setImageResource(thumbnails[position]);

        return (row);
    }

}// CustomAdapter
