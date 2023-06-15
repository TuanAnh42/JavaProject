/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlamda;

/**
 *
 * @author std
 */
public class Track {
    private String name;
    private int viewCount;

    public Track(String name, int viewCount) {
        this.name = name;
        this.viewCount = viewCount;
    }

    public Track() {
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "Track{" + "name=" + name + ", viewCount=" + viewCount + '}';
    }
    
    
    
}
