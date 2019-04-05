package com.vogella.android.picsum;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vogella.android.picsum.Modèle.Picsum;

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
        Intent descriptif = SecondActivity.getIntent();

         Picsum picsum = new Picsum(
                descriptif.getStringExtra("format"),
                descriptif.getStringExtra("width"),
                descriptif.getStringArrayExtra("height"),
                descriptif.getStringExtra("filename"),
                descriptif.getStringExtra("id"),
                descriptif.getStringExtra("author_url"),

        TextView format = SecondActivity.findViewById(R.id.format);
        TextView width = SecondActivity.findViewById(R.id.width);
        TextView height = SecondActivity.findViewById(R.id.height);
        TextView filename = SecondActivity.findViewById(R.id.filename);
        TextView id = SecondActivity.findViewById(R.id.id);
        TextView author_url = SecondActivity.findViewById(R.id.authourl);

        format.setText(Picsum.getFormat());
        width.setText(width.getWidth());
        height.setText(Picsum.getHeight());
        filename.setText(Picsum.getFilename());
        id.setText(Picsum.getId());
        author_url.setText(Picsum.getAuthor_url());
    }
    }
}
