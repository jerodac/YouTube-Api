package br.com.jerodac.business;

import br.com.jerodac.vo.PLaylistListResponse;
import br.com.jerodac.vo.VideoInfoResponse;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public interface API {

    //path
    String PLAYLIST = "/playlists";
    String PLAYLIST_ITEM = "/playlistItems";
    String VIDEOS = "/videos";

    //strings query
    String QUERY_KEY = "key";
    String QUERY_ID = "id";
    String QUERY_PART = "part";
    String QUERY_CHANNEL_ID = "channelId";
    String QUERY_PLAYLIST_ID = "playlistId";


    @GET(PLAYLIST)
    PLaylistListResponse playList(@Query(QUERY_PART) String part, @Query(QUERY_CHANNEL_ID) String userId, @Query(QUERY_KEY) String keyGoogle);

    @GET(PLAYLIST_ITEM)
    PLaylistListResponse playListItem(@Query(QUERY_PART) String part, @Query(QUERY_PLAYLIST_ID) String playListId, @Query(QUERY_KEY) String keyGoogle);

    @GET(VIDEOS)
    VideoInfoResponse videoDescribe(@Query(QUERY_PART) String part, @Query(QUERY_ID) String videoId, @Query(QUERY_KEY) String keyGoogle);

}

