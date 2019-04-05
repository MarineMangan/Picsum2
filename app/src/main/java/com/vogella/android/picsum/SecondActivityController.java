package com.vogella.android.picsum;

import android.annotation.SuppressLint;

public class SecondActivityController {
    private static SecondActivityController instanceDC = null;
    private SecondActivityController secondActivityController;

    private SecondActivityController(SecondActivityController descriptionActivity) {

        this.secondActivityController = descriptionActivity;
    }
    public static SecondActivityController getInstance(SecondActivityController mainActivity){
        if(instanceDC==null){
            instanceDC = new SecondActivityController(mainActivity);
        }
        else {
            instanceDC.secondActivityController = mainActivity;
        }
        return instanceDC;
    }

    public void onCreate(){
        this.ecranDescriptif();
    }

    @SuppressLint("SetTextI18n")
    private void ecranDescriptif(){
    }
}
