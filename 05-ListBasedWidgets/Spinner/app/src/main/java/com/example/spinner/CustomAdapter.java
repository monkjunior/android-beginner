package com.example.spinner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    Context context;
    String[] receivers;
    String[] mails;
    public  CustomAdapter( Context context, int layoutToBeInflated,
                           String[] receivers, String[] mails) {
        super(context, R.layout.custom_row, receivers);
        this.context = context;
        this.receivers = receivers;
        this.mails = mails;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView receiver = (TextView) row.findViewById(R.id.receiver);
        TextView mail = (TextView) row.findViewById(R.id.mail);

        receiver.setText(receivers[position]);
        mail.setText(mails[position]);

        return (row);
    }

}
