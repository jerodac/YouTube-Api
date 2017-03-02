package br.com.jerodac.vo;

import com.google.gson.annotations.SerializedName;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class Snippet {
    private String channelId;
    private String title;
    private String description;

    @SerializedName("thumbnails")
    private Thumbnails thumbnails;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }
}
