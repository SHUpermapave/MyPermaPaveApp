package com.example.myfirstapp;


import android.app.Application;
import android.graphics.Path;

public class globalVars extends Application {
    private static globalVars instance;

    private Path path;
    private Path fullPath;
    private String selectedColour;
    private Boolean isArea = false;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Path getFullPath() {
        return fullPath;
    }

    public void setFullPath(Path fullPath) {
        this.fullPath = fullPath;
    }

    public String getSelectedColour() {
        return selectedColour;
    }

    public void setSelectedColour(String selectedColour) {
        this.selectedColour = selectedColour;
    }

    public Boolean getIsArea(){
        return isArea;
    }

    public void setIsArea(Boolean isArea){
        this.isArea = isArea;
    }

    public static synchronized globalVars getInstance(){
        if(instance==null){
            instance=new globalVars();
        }
        return instance;
    }
}

