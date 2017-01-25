package exam.vsrk.notifier.Instances;

/**
 * Created by VSRK on 1/12/2016.
 */
public class FeedItem {
    private String appName;
    private String icon;
    private String description;
    private String notification;
    private String pack;

    public void setNotification(String notification) {
        this.notification=notification;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getIcon(){
        return icon;
    }
    public String getDescription(){
        return description;
    }
    public String getNotification(){
        return notification;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getPack() {
        return pack;
    }
}
