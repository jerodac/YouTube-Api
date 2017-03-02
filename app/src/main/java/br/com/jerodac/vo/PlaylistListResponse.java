package br.com.jerodac.vo;

import com.google.api.client.json.GenericJson;
import com.google.api.services.youtube.model.Playlist;
import com.google.api.services.youtube.model.TokenPagination;
import com.google.gson.annotations.SerializedName;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class PlaylistListResponse extends GenericJson {

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
     * A list of playlists that match the request criteria.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.util.List<Playlist> items;

    static {
        // hack to force ProGuard to consider Playlist used, since otherwise it would be stripped out
        // see https://github.com/google/google-api-java-client/issues/543
        com.google.api.client.util.Data.nullOf(Playlist.class);
    }

    /**
     * Identifies what kind of resource this is. Value: the fixed string
     * "youtube#playlistListResponse".
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

    /**
     * The value may be {@code null}.
     */
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
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private TokenPagination tokenPagination;

    /**
     * The visitorId identifies the visitor.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private java.lang.String visitorId;

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
    public PlaylistListResponse setEtag(java.lang.String etag) {
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
    public PlaylistListResponse setEventId(java.lang.String eventId) {
        this.eventId = eventId;
        return this;
    }

    /**
     * A list of playlists that match the request criteria.
     *
     * @return value or {@code null} for none
     */
    public java.util.List<Playlist> getItems() {
        return items;
    }

    /**
     * A list of playlists that match the request criteria.
     *
     * @param items items or {@code null} for none
     */
    public PlaylistListResponse setItems(java.util.List<Playlist> items) {
        this.items = items;
        return this;
    }

    /**
     * Identifies what kind of resource this is. Value: the fixed string
     * "youtube#playlistListResponse".
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * Identifies what kind of resource this is. Value: the fixed string
     * "youtube#playlistListResponse".
     *
     * @param kind kind or {@code null} for none
     */
    public PlaylistListResponse setKind(java.lang.String kind) {
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
    public PlaylistListResponse setNextPageToken(java.lang.String nextPageToken) {
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
    public PlaylistListResponse setPageInfo(PageInfo pageInfo) {
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
    public PlaylistListResponse setPrevPageToken(java.lang.String prevPageToken) {
        this.prevPageToken = prevPageToken;
        return this;
    }

    /**
     * @return value or {@code null} for none
     */
    public TokenPagination getTokenPagination() {
        return tokenPagination;
    }

    /**
     * @param tokenPagination tokenPagination or {@code null} for none
     */
    public PlaylistListResponse setTokenPagination(TokenPagination tokenPagination) {
        this.tokenPagination = tokenPagination;
        return this;
    }

    /**
     * The visitorId identifies the visitor.
     *
     * @return value or {@code null} for none
     */
    public java.lang.String getVisitorId() {
        return visitorId;
    }

    /**
     * The visitorId identifies the visitor.
     *
     * @param visitorId visitorId or {@code null} for none
     */
    public PlaylistListResponse setVisitorId(java.lang.String visitorId) {
        this.visitorId = visitorId;
        return this;
    }

    @Override
    public com.google.api.services.youtube.model.PlaylistListResponse set(String fieldName, Object value) {
        return (com.google.api.services.youtube.model.PlaylistListResponse) super.set(fieldName, value);
    }

    @Override
    public com.google.api.services.youtube.model.PlaylistListResponse clone() {
        return (com.google.api.services.youtube.model.PlaylistListResponse) super.clone();
    }

}

