package com.rizwa.modlebasedlistview;

/**
 * Created by mac on 19/01/2018.
 */

public class MoviesModel {
    private int ImageId;
    private String moviesTitle;
    private String moviesSubTitle;

    public MoviesModel(int imageId, String moviesTitle, String moviesSubTitle) {
        this.ImageId = imageId;
        this.moviesTitle = moviesTitle;
        this.moviesSubTitle = moviesSubTitle;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getMoviesTitle() {
        return moviesTitle;
    }

    public void setMoviesTitle(String moviesTitle) {
        this.moviesTitle = moviesTitle;
    }

    public String getMoviesSubTitle() {
        return moviesSubTitle;
    }

    public void setMoviesSubTitle(String moviesSubTitle) {
        this.moviesSubTitle = moviesSubTitle;
    }
}
