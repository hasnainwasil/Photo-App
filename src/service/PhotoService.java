package service;
// Method to fetch all photos of a userID.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Photo;
import models.User;

public class PhotoService {
    UserService userService = new UserService();

    public List<Photo> fetchAllPhoto(User user){
        return user.getPhotos();
    }

    public Boolean uploadPhoto(User user, String photo, List<User> tagList){
        Photo image = new Photo(photo, tagList);
        List<Photo> tempPhotoList = user.getPhotos();
        tempPhotoList.add(image);
        user.setPhotos(tempPhotoList);
        return true;
    }

    public List<String> fetchAllFollowers(User user){
        return user.getFollowers();
    }

    public List<String> fetchAllFollowings(User user){
        return user.getFollowings();
    }
    
    public Boolean followUser(User owner, String followerUsername, HashMap<String, User> allUsers){
        increaseFollower(owner, followerUsername);
        increaseFollowing(owner, followerUsername, allUsers);
        return true;
    }

    public void increaseFollower(User owner, String followerUsername){
        List<String> tempFollowers = owner.getFollowers();
        tempFollowers.add(followerUsername);
        owner.setFollowers(tempFollowers);
    }

    public void increaseFollowing(User owner, String followerUsername, HashMap<String, User> allUsers){
        User user = userService.wantUser(followerUsername, allUsers);
        // System.out.println(user.getFollowers());
        List<String> tempFollowing = user.getFollowings();
        tempFollowing.add(owner.getUserName());
        user.setFollowings(tempFollowing);
    }


    public List<Photo> allPhotos(User user, HashMap<String, User> allUsers){
        List<String> following = user.getFollowings();

        List<Photo> photoArray = new ArrayList<>();

        for(int i=0;i<following.size();i++){
           User followingUser = allUsers.get(following.get(i));
            List<Photo> tempPhoto = followingUser.getPhotos();
            for (Photo tempPhoto1 : tempPhoto) {
                // System.out.println("TEMP"+tempPhoto1.getPhotoName());
                photoArray.add(tempPhoto1);
            }
        }

        return photoArray;
    }
}
