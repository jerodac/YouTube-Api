package br.com.jerodac.vo;

import com.google.gson.annotations.SerializedName;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class Thumbnails {

    @SerializedName("default")
    private ImageType defaultImage;

    @SerializedName("medium")
    private ImageType medium;

    @SerializedName("high")
    private ImageType high;

    @SerializedName("standard")
    private ImageType standard;

    public ImageType getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(ImageType defaultImage) {
        this.defaultImage = defaultImage;
    }

    public ImageType getMedium() {
        return medium;
    }

    public void setMedium(ImageType medium) {
        this.medium = medium;
    }

    public ImageType getHigh() {
        return high;
    }

    public void setHigh(ImageType high) {
        this.high = high;
    }

    public ImageType getStandard() {
        return standard;
    }

    public void setStandard(ImageType standard) {
        this.standard = standard;
    }

    public class ImageType {
        private String url;
        private int width;
        private int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

}
