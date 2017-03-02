package br.com.jerodac.vo;

import com.google.api.services.youtube.model.Video;
import com.google.gson.annotations.SerializedName;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class VideoListResponse extends com.google.api.client.json.GenericJson {

    /**
     * Etag of this resource.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String etag;

    /**
     * Serialized EventId of the request which produced this response.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String eventId;

    /**
     * A list of videos that match the request criteria.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.util.List<Video> items;

    static {
        // hack to force ProGuard to consider Video used, since otherwise it would be stripped out
        // see https://github.com/google/google-api-java-client/issues/543
        com.google.api.client.util.Data.nullOf(Video.class);
    }

    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#videoListResponse".
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String kind;

    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the next page in
     * the result set.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String nextPageToken;

    @SerializedName("pageInfo")
    private PageInfo pageInfo;


    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the previous
     * page in the result set.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String prevPageToken;

    /**
     * Etag of this resource.
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getEtag() {
        return etag;
    }

    /**
     * Etag of this resource.
     *
     * @param etag etag or {@code null} for none
     */
    public VideoListResponse setEtag(java.lang.String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Serialized EventId of the request which produced this response.
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getEventId() {
        return eventId;
    }

    /**
     * Serialized EventId of the request which produced this response.
     *
     * @param eventId eventId or {@code null} for none
     */
    public VideoListResponse setEventId(java.lang.String eventId) {
        this.eventId = eventId;
        return this;
    }

    /**
     * A list of videos that match the request criteria.
     *
     * @return value or {@code null} for none
     */
    public java.util.List<Video> getItems() {
        return items;
    }

    /**
     * A list of videos that match the request criteria.
     *
     * @param items items or {@code null} for none
     */
    public VideoListResponse setItems(java.util.List<Video> items) {
        this.items = items;
        return this;
    }

    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#videoListResponse".
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * Identifies what kind of resource this is. Value: the fixed string "youtube#videoListResponse".
     *
     * @param kind kind or {@code null} for none
     */
    public VideoListResponse setKind(java.lang.String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the next page in
     * the result set.
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getNextPageToken() {
        return nextPageToken;
    }

    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the next page in
     * the result set.
     *
     * @param nextPageToken nextPageToken or {@code null} for none
     */
    public VideoListResponse setNextPageToken(java.lang.String nextPageToken) {
        this.nextPageToken = nextPageToken;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    /**
     * @param pageInfo pageInfo or {@code null} for none
     */
    public VideoListResponse setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the previous
     * page in the result set.
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getPrevPageToken() {
        return prevPageToken;
    }

    /**
     * The token that can be used as the value of the pageToken parameter to retrieve the previous
     * page in the result set.
     *
     * @param prevPageToken prevPageToken or {@code null} for none
     */
    public VideoListResponse setPrevPageToken(java.lang.String prevPageToken) {
        this.prevPageToken = prevPageToken;
        return this;
    }

    @Override
    public VideoListResponse set(String fieldName, Object value) {
        return (VideoListResponse) super.set(fieldName, value);
    }

    @Override
    public VideoListResponse clone() {
        return (VideoListResponse) super.clone();
    }

}
