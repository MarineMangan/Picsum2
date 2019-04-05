package com.vogella.android.picsum;

import android.content.Context;
import android.content.SharedPreferences;

import com.vogella.android.picsum.Modèle.Picsum;

import java.util.ArrayList;
import java.util.List;

public class PicsumCache {

    private SharedPreferences sharedPreferences;

    public PicsumCache(Context context){
        sharedPreferences = context.getSharedPreferences("Picsum",Context.MODE_PRIVATE);
    }

    public boolean testCache(){
        if(sharedPreferences.contains("NAME")){
            System.out.println("TRUEEEE");
            return true;
        }
        else{
            System.out.println("FALSEEEE");
            return false;
        }
    }

    public List<Picsum> getCache(){

        String format = sharedPreferences.getString("FORMAT",null);
        assert format != null;
        String[] nameG = format.split("&");
        String width = sharedPreferences.getString("WIDTH",null);
        assert width != null;
        String[] widthG = width.split("&");
        String height = sharedPreferences.getString("HEIGHT",null);
        assert height != null;
        String[] heightG = height.split("&");
        String filename = sharedPreferences.getString("FILENAME",null);
        assert filename != null;
        String[] filenameG = filename .split("&");
        String id = sharedPreferences.getString("ID",null);
        assert id != null;
        String[] idG = id.split("&");
        String author = sharedPreferences.getString("AUTHOR",null);
        assert author != null;
        String[] authorG = author.split("&");
        String author_url = sharedPreferences.getString("AUTHOR_URL",null);
        assert author_url != null;
        String[] significationG = author_url.split("&");
        String post_url = sharedPreferences.getString("POST_URL",null);
        assert post_url != null;
        String[] post_urlG = post_url.split("&");

        List<Picsum> liste = new ArrayList<>();
        for(int repetition = 0;repetition<nameG.length;repetition++)
        {
            liste.add(new Picsum(
                    formatG[repetition],
                    widthG[repetition],
                    heightG[repetition].split("\t"),
                    filenameG[repetition],
                    idG[repetition],
                    authorG[repetition],
                    author_urlG[repetition],
                    post_urlG[repetition],
        }

        return liste;


    }

    public void writeCache(List<Picsum> listGod){

        StringBuilder format = new StringBuilder();
        StringBuilder width = new StringBuilder();
        StringBuilder height = new StringBuilder();
        StringBuilder filename = new StringBuilder();
        StringBuilder id = new StringBuilder();
        StringBuilder author = new StringBuilder();
        StringBuilder author_url = new StringBuilder();
        StringBuilder post_url = new StringBuilder();
        Picsum pic;


        for(int repetition = 0; repetition < listGod.size();repetition++){
            pic = listPic.get(repetition);

            format.append(pic.getFormat()).append("&");
            width.append(pic.getWidth()).append("&");
            height.append(pic.getHeight()).append("&");
            filename.append(pic.getFilename()).append("&");
            id.append(pic.getId()).append("&");
            author.append(pic.getAuthor()).append("&");
            author_url.append(pic.getAuthor_url()).append("&");
            post_url.append(pic.getPost_url()).append("&");
        }

        sharedPreferences.edit()
                .putString("FORMAT",format.toString())
                .putString("WIDTH",width.toString())
                .putString("HEIGHT",height.toString())
                .putString("FILENAME",filename.toString())
                .putString("ID",id.toString())
                .putString("AUTHOR",author.toString())
                .putString("AUTHOR_URL",author_url.toString())
                .putString("POST_URL",post_url.toString())
                .apply();
        // List<EgypteGod> goddy = this.getCache();
    }

}
