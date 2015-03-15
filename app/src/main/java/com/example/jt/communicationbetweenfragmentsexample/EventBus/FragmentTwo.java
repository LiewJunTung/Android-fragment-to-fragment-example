package com.example.jt.communicationbetweenfragmentsexample.EventBus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jt.communicationbetweenfragmentsexample.R;
import com.example.jt.communicationbetweenfragmentsexample.User;

import de.greenrobot.event.EventBus;

/**
 * Created by jt on 3/15/15.
 */
public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        final ViewHolder vh = new ViewHolder();
        vh.mName = (TextView) view.findViewById(R.id.sf_name);
        vh.mEmail = (TextView) view.findViewById(R.id.sf_email);
        vh.mAge = (TextView) view.findViewById(R.id.sf_age);
        vh.mButton = (Button) view.findViewById(R.id.sf_send);
        vh.mEditName = (EditText) view.findViewById(R.id.sf_editName);
        vh.mEditEmail = (EditText) view.findViewById(R.id.sf_editEmail);
        vh.mEditAge = (EditText) view.findViewById(R.id.sf_editAge);

        /**
         * Get the user object using getStickyEvent to get the Sticky the User.class.
         */

        final User user = EventBus.getDefault().getStickyEvent(User.class);

        vh.mName.setText(user.getName());
        vh.mEmail.setText(user.getEmail());
        vh.mAge.setText(Integer.toString(user.getAge()));

        vh.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = vh.mEditName.getText().toString();
                String email = vh.mEditEmail.getText().toString();
                int age = Integer.parseInt(vh.mEditAge.getText().toString());
                /**
                 * Post a User event (not sticky)
                 */
                EventBus.getDefault().post(new User(name, email, age));
            }
        });
        return view;
    }

    private static class ViewHolder{
        TextView mName;
        TextView mEmail;
        TextView mAge;
        Button mButton;
        EditText mEditName;
        EditText mEditEmail;
        EditText mEditAge;
    }

}
