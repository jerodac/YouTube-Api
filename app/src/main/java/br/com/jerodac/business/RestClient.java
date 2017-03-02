package br.com.jerodac.business;


import com.google.api.client.json.GenericJson;

import br.com.jerodac.vo.PlaylistListResponse;
import br.com.jerodac.vo.VideoListResponse;


/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class RestClient {

    private static String USER = "androiddevelopers";
    private static String CHANNEL_ID = "UCVHFbqXqoYvEWM1Ddxl0QDg";
    private static String KEY_GOOGLE = "AIzaSyBPlVYsLeKqj9u7wjIQFzamljTaFKPVFSE";
    private static String PART = "snippet";

    //Returns playlist of user videos
    public static PlaylistListResponse getAllPlayList() {
        return Configuration.getApi().playList(PART, CHANNEL_ID, KEY_GOOGLE);
    }

    //Returns videos from a specific playlist
    public static PlaylistListResponse getVideosByPLayList(String playListId) {
        return Configuration.getApi().playListItem(PART, playListId, KEY_GOOGLE);
    }

    //Returns information about a video
    public static VideoListResponse getInfoByVideo(String videoId) {
        return Configuration.getApi().videoDescribe(PART, videoId, KEY_GOOGLE);
    }
}
