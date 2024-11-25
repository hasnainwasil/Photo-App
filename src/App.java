
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Photo;
import models.User;
import service.PhotoService;
import service.UserService;
import utils.PhotoUtils;

public class App {
//     Features:
// Users should be able to post photos.
// Method to fetch all photos of a userID.
// Method to fetch all the followers.
// Method to fetch all the userID user is following.
// Photos can contain tags to other userID.
// Feed
// A user can follow other users.
//  Function to get all photos for his feed. (All photos of users this user is following.

    public static void main(String[] args) throws Exception {
        HashMap<String, User> allUSers = new HashMap<>();

        PhotoService photoService = new PhotoService();
        UserService userService = new UserService();
        PhotoUtils photoUtils = new PhotoUtils();

        User user1 = userService.addUser("Wasil", allUSers); 
        User user2 = userService.addUser("Pullak", allUSers);
        User user3 = userService.addUser("User3", allUSers);
        User user4 = userService.addUser("User4", allUSers);


        List<User> tagList = new ArrayList<>();
        photoService.uploadPhoto(user1, "Ooty 1",tagList);

        List<User> tagListUser2 = new ArrayList<>();
        tagListUser2.add(user1);
        tagListUser2.add(user2);

        photoService.uploadPhoto(user2, "Ooty TEMP",tagListUser2);

        photoService.uploadPhoto(user3, "Ooty 3",tagList);

        photoService.uploadPhoto(user4, "Ooty 4",tagList);
        photoService.uploadPhoto(user4, "Delhi 4",tagList);

        List<Photo> photo = photoService.fetchAllPhoto(user1);
        // for (int i = 0; i < photo.size(); i++) {
        //     System.out.println(photo.get(i).getPhotoName());
        // };


        photoService.followUser(user4, user1.getUserName(), allUSers);
        photoService.followUser(user4, user2.getUserName(), allUSers);
        photoService.followUser(user4, user3.getUserName(), allUSers);

        photoService.followUser(user1, user2.getUserName(), allUSers);
        photoService.followUser(user3, user2.getUserName(), allUSers);

        photoService.followUser(user1, user3.getUserName(), allUSers);

        List<String> followers = photoService.fetchAllFollowers(user4);
        // for (int i = 0; i < followers.size(); i++) {
        //     System.out.println(followers.get(i));
        // };
        // photoUtils.printArray(followers);

        List<String> followings = photoService.fetchAllFollowings(user4);
        photoUtils.printArray(followings);


        // photoService.uploadPhoto(user1, "Ooty 2",tagList);
        
        photo = photoService.fetchAllPhoto(user4);
        System.out.println("USER PHOTOS");

        for (int i = 0; i < photo.size(); i++) {
            System.out.println(photo.get(i).getPhotoName());
            List<User> user = photo.get(i).getTagList();
            for (int j = 0; j < user.size(); j++) {
                System.out.println(user.get(j).getUserName());
            };
        };

        // tagList.add(user2);


        List<Photo> Allphoto = photoService.allPhotos(user2, allUSers);
        // System.out.println("ALL PHOTOS");
        // for (int i = 0; i < Allphoto.size(); i++) {
        //     System.out.println(Allphoto.get(i).getPhotoName());
        //     List<User> user = Allphoto.get(i).getTagList();
        //     for (int j = 0; j < user.size(); j++) {
        //         System.out.println(user.get(j).getUserName());
        //     };
        // };
    }
}
