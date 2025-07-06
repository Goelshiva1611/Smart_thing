package com.example.smarthomecarapp;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.car.app.CarAppService;
import androidx.car.app.Session;
import androidx.car.app.Screen;

public class MyCarAppService extends CarAppService {
    @NonNull
    @Override
    public Session onCreateSession() {
        return new Session() {
            @NonNull
            @Override
            public Screen onCreateScreen(@NonNull Intent intent) {
                return new SmartHomeScreen(getCarContext());
            }
        };
    }
}