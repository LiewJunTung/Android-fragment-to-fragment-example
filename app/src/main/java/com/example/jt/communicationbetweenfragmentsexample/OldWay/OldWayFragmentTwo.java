package com.example.jt.communicationbetweenfragmentsexample.OldWay;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jt.communicationbetweenfragmentsexample.R;
import com.example.jt.communicationbetweenfragmentsexample.User;

/**
 * Created by jt on 3/15/15.
 */
public class OldWayFragmentTwo extends Fragment {
    ViewHolder vh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ow_fragment_two, container, false);
        vh = new ViewHolder();
        vh.mName = (TextView) view.findViewById(R.id.o2_name);
        vh.mEmail = (TextView) view.findViewById(R.id.o2_email);
        vh.mAge = (TextView) view.findViewById(R.id.o2_age);
        return view;
    }

    private static class ViewHolder{
        TextView mName;
        TextView mEmail;
        TextView mAge;
    }

    public void getUserAndSetText(User user){
        vh.mName.setText(user.getName());
        vh.mEmail.setText(user.getEmail());
        vh.mAge.setText(Integer.toString(user.getAge()));
    }
}
