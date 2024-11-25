package models;

import java.util.List;

public class Photo {
    private String photoName;
    private List<User> tagList;

    public Photo(String photoName, List<User> tagList) {
        this.photoName = photoName;
        this.tagList = tagList;
    }

    public String getPhotoName() {
        return photoName;
    }

    public List<User> getTagList() {
        return tagList;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setTagList(List<User> tagList) {
        this.tagList = tagList;
    }
}
