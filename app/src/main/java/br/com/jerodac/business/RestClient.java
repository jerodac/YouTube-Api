package br.com.jerodac.business;

import br.com.jerodac.dto.ResponseDto;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class RestClient {

    private static String USER = "androiddevelopers";
    private static String CHANNEL_ID = "UCVHFbqXqoYvEWM1Ddxl0QDg";
    private static String KEY_GOOGLE = "AIzaSyBPlVYsLeKqj9u7wjIQFzamljTaFKPVFSE";
    private static String PART = "snippet";

    //Returns playlist of user videos
    public static ResponseDto getAllPlayList() {
        return Configuration.getApi().playList(PART, CHANNEL_ID, KEY_GOOGLE);
    }

    //Returns videos from a specific playlist
    public static ResponseDto getVideosByPLayList(String playListId) {
        return Configuration.getApi().playListItem(PART, playListId, KEY_GOOGLE);
    }

    //Returns information about a video
    public static ResponseDto getInfoByVideo(String videoId) {
        return Configuration.getApi().videoDescribe(PART, videoId, KEY_GOOGLE);
    }
}
