package com.example.jt.communicationbetweenfragmentsexample.EventBus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jt.communicationbetweenfragmentsexample.R;
import com.example.jt.communicationbetweenfragmentsexample.User;

import de.greenrobot.event.EventBus;

/**
 * Created by jt on 3/15/15.
 */
public class FragmentThree extends Fragment {
    ViewHolder vh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        vh = new ViewHolder();
        vh.mName = (TextView) view.findViewById(R.id.ft_name);
        vh.mEmail = (TextView) view.findViewById(R.id.ft_email);
        vh.mAge = (TextView) view.findViewById(R.id.ft_age);

        return view;
    }

    private static class ViewHolder{
        TextView mName;
        TextView mEmail;
        TextView mAge;
    }

    /**
     * Register the activity/fragment for the EventBus event.
     * Kinda like jQuery way of subscribing elements to events - $('#xx').on('event', function(user){...});
     */
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onEvent(User user){
        vh.mName.setText(user.getName());
        vh.mAge.setText(Integer.toString(user.getAge()));
        vh.mEmail.setText(user.getEmail());
    }
}
