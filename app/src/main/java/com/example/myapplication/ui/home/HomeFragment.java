package com.example.myapplication.ui.home;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.LoginRequest;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import org.json.JSONObject;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        final TextView tv_check = root.findViewById(R.id.text_check);
        Button btn_check = root.findViewById(R.id.text_check_button);

        btn_check.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                int value = Integer.parseInt(tv_check.getText().toString());
                if(value>=500){

                }
            }
        });
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;




    }
}