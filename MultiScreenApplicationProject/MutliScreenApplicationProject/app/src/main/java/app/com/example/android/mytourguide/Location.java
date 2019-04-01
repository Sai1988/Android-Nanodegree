package app.com.example.android.mytourguide;

/**
 * Created by Speed on 14-08-2016.
 */
public class Location {
    private String mName;
    private String mDescription;
    private String mAddress;
    private String mContact;
    private int mImage;

    //constructor for class Location
    public Location(String name, String description, String address, String contact, int image) {
        mName = name;
        mDescription = description;
        mAddress = address;
        mContact = contact;
        mImage = image;
    }

    // Getter methods for the members of class Location
    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getContact() {
        return mContact;
    }

    public int getImage() {
        return mImage;
    }
}
