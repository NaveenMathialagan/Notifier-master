package exam.vsrk.notifier.Gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by VSRK on 1/12/2016.
 */
public class Post {
    @SerializedName("package")
    public String packa;
    public String logo;
    public String description;
    public String notification;
    public String app_type;

}
