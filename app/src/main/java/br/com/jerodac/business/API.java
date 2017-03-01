package br.com.jerodac.business;

import br.com.jerodac.dto.ResponseDto;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public interface API {

    String PLAYLIST = "/playlist";
    String PLAYLIST_ITEM = "/playlistitems";
    String VIDEOS = "/videos";

    @GET(PLAYLIST)
    ResponseDto playList(@Query("ID_USER") String userId, @Query("KEY_GOOGLE") String keyGoogle);

    @GET(PLAYLIST_ITEM)
    ResponseDto playListItem(@Query("PLAY_LIST_ID") String playListId, @Query("KEY_GOOGLE") String keyGoogle);

    @GET(VIDEOS)
    ResponseDto videoDescribe(@Query("ID_VIDEO") String videoId, @Query("KEY_GOOGLE") String keyGoogle);

}

