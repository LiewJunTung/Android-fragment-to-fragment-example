package com.example.jt.communicationbetweenfragmentsexample.EventBus;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jt.communicationbetweenfragmentsexample.OldWay.OldWayActivity;
import com.example.jt.communicationbetweenfragmentsexample.R;
import com.example.jt.communicationbetweenfragmentsexample.User;

import de.greenrobot.event.EventBus;

/**
 * Created by jt on 3/15/15.
 */
public class FragmentOne extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        final ViewHolder vh = new ViewHolder();
        vh.mName = (EditText) view.findViewById(R.id.fo_editName);
        vh.mEmail = (EditText) view.findViewById(R.id.fo_editEmail);
        vh.mAge = (EditText) view.findViewById(R.id.editAge);
        vh.mButton = (Button) view.findViewById(R.id.fo_sendF2);
        vh.mButtonOldWay = (Button) view.findViewById(R.id.fo_oldway);
        vh.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get values from the textviews
                String name = vh.mName.getText().toString();
                String email = vh.mEmail.getText().toString();
                int age = Integer.parseInt(vh.mAge.getText().toString());

                if(!name.matches("") && !email.matches("") && age != 0){
                    User user = new User(name, email, age);

                    /**
                     * use EventBus to post sticky events. Sticky means this value 'sticks'
                     * throughout the application.
                     */
                    EventBus.getDefault().postSticky(user);

                    startActivity(new Intent(getActivity(), SecondActivity.class));

                }else {
                    Toast.makeText(getActivity(),
                            "Please fill in all the Text Fields to proceed",
                            Toast.LENGTH_SHORT
                            ).show();
                }

            }
        });

        vh.mButtonOldWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OldWayActivity.class));
            }
        });
        return view;
    }

    /**
     * Viewholder to hold all the views
     */

    private static class ViewHolder{
        EditText mName;
        EditText mEmail;
        EditText mAge;
        Button mButton;
        Button mButtonOldWay;
    }
}
