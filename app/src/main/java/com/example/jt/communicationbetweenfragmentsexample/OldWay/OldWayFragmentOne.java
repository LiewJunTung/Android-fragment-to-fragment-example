package com.example.jt.communicationbetweenfragmentsexample.OldWay;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jt.communicationbetweenfragmentsexample.R;
import com.example.jt.communicationbetweenfragmentsexample.User;

/**
 * Created by jt on 3/15/15.
 */
public class OldWayFragmentOne extends Fragment {
    ViewHolder vh;
    Comm comm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ow_fragment_one, container, false);
        vh = new ViewHolder();
        vh.mEditName = (EditText) view.findViewById(R.id.o1_name);
        vh.mEditEmail = (EditText) view.findViewById(R.id.o1_email);
        vh.mEditAge = (EditText) view.findViewById(R.id.o1_age);
        vh.mButton = (Button) view.findViewById(R.id.o1_button);
        comm = (Comm) getActivity();

        vh.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = vh.mEditName.getText().toString();
                String email = vh.mEditEmail.getText().toString();
                int age = Integer.parseInt(vh.mEditAge.getText().toString());
                User user = new User(name, email, age);
                comm.respond(user);
            }
        });
        return view;
    }


    private static class ViewHolder{
        EditText mEditName;
        EditText mEditEmail;
        EditText mEditAge;
        Button mButton;
    }

}
