package com.example.fvotingapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import 	androidx.biometric.BiometricPrompt.PromptInfo.Builder;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class vote extends AppCompatActivity {
   // Intent i=new Intent(this,votingpage.class);
    Executor executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        executor= ContextCompat.getMainExecutor(this);
        biometricPrompt=new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(vote.this,"success",Toast.LENGTH_LONG).show();
               // startActivity(i);

            }

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(vote.this,errString,Toast.LENGTH_LONG).show();
                vote.this.finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(vote.this,"failed",Toast.LENGTH_LONG).show();
            }
        });

        promptInfo=new Builder().setTitle("touch id is required")
                .setDescription("touch the touch id sensor").setNegativeButtonText("exit").build();


        biometricPrompt.authenticate(promptInfo);
    }


    public void auth(View view){


    Intent i=new Intent(this,votingpage.class);
    startActivity(i);}



}
