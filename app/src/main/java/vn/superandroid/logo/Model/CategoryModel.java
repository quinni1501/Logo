package vn.superandroid.logo.Model;

import java.io.Serializable;
import java.util.List;

public class CategoryModel implements Serializable {
    private String categoryId;
    private String name;
    private List<MovieModel> listMovie;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public CategoryModel(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public CategoryModel(String categoryId, String name, List<MovieModel> listMovie) {
        this.categoryId = categoryId;
        this.name = name;
        this.listMovie = listMovie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieModel> getListMovie() {
        return listMovie;
    }

    public void setListMovie(List<MovieModel> listMovie) {
        this.listMovie = listMovie;
    }
}
