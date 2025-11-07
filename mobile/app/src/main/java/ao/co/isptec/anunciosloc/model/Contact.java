package ao.co.isptec.anunciosloc.model;

public class Contact {
    private String name;
    private String email;
    private int profileImage;

    public Contact(String name, String email, int profileImage) {
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
