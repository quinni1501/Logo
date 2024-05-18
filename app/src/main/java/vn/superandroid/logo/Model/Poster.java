package vn.superandroid.logo.Model;

public class Poster {
    private int imageResId;
    private String filmName;

    public Poster(int imageResId, String filmName) {
        this.imageResId = imageResId;
        this.filmName = filmName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getFilmName() {
        return filmName;
    }
}
