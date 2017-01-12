package com.example.myfirstapp;


import android.app.Application;
import android.graphics.Path;

public class globalVars extends Application {
    private static globalVars instance;

    private Path path;
    private String selectedColour;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getSelectedColour() {
        return selectedColour;
    }

    public void setSelectedColour(String selectedColour) {
        this.selectedColour = selectedColour;
    }
    public static synchronized globalVars getInstance(){
        if(instance==null){
            instance=new globalVars();
        }
        return instance;
    }
}

