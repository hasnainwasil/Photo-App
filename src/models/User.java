package models;

import java.util.ArrayList;
import java.util.List;


public class User {

    private String userName;
    private List<String> followers = new ArrayList<>();
    private List<String> followings = new ArrayList<>();
    private List<Photo> photos =new ArrayList<>();

    public List<String> getFollowings() {
        return followings;
    }

    public void setFollowings(List<String> followings) {
        this.followings = followings;
    }


    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    
}
