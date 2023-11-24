import java.util.*;
// POJO
class Post{
    private int postId;
    private String title;
    private String content;
    private int likes;

    Post(String title,String content){
        this.title = title;
        this.content = content;
        this.likes = 0;
    }
    Post(){
        this.title = "Untiled";
        this.content = "Lorium Ipsum";
        this.likes = 0;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public int getLikes(){
        return likes;
    }

    public void like(){
        likes++;
    }

}
class User{
    int id;
    String name;
    List<Post> posts = new ArrayList<Post>();
    User(int id,String name){
        this.id = id;
        this.name = name;
    }

    void createPost(String title, String content){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        posts.add(post);
    }
    
    void viewPosts(){
        for(Post post:posts){
            System.out.println(post.getTitle());
            System.out.println(post.getContent());
            System.out.println("LIKES:"+post.getLikes());
        }
    }

    public Post getPost(String title){
        for(Post post:posts){
            if(post.getTitle()==title){
                return post;
            }
        }
        return null;
    }
}
class FaceBook{
    int next_unique_id = 0;
    
    List<User> users = new ArrayList<User>();

    void createUser(String name){
      User user = new User(next_unique_id++, name);
      users.add(user);
    }
    void displayUsers(){
      for(User user:users){
        System.out.println(user.id+" "+user.name);
      }
    }
}

public class Main {
    public static void main(String[] args) {
        FaceBook faceBook = new FaceBook();
        faceBook.createUser("Rajasekaran");
        faceBook.displayUsers();
        faceBook.createUser("Joel");
        faceBook.displayUsers();

        User user1 = faceBook.users.get(0);
        user1.createPost("APPLE","apple is red");
        user1.createPost("ORANGE","orange is orange");
        user1.viewPosts();

        User user2 = faceBook.users.get(1);
        user2.createPost("CARROT","apple is good");
        user2.createPost("BRINJAL","brinjal is too good");
        user2.viewPosts();

        Post post;
        post = user1.getPost("APPLE");
        post.like();

        user1.viewPosts();
    }    
}