package rwConfig;

import java.util.ArrayList;

interface Tags {

    ArrayList<String> getTags();

    void setTags(ArrayList<String> tags);

    default void addTag(String tag){
        getTags().add(tag);
    }

    default void delTag(String tag){
        getTags().remove(tag);
    }
}
