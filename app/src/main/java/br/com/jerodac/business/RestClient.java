package br.com.jerodac.business;

import br.com.jerodac.dto.ResponseDto;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class RestClient {

    String USER = "androiddevelopers";
    String ID_USER = "UCVHFbqXqoYvEWM1Ddxl0QDg";
    String KEY_GOOGLE = "AIzaSyBPlVYsLeKqj9u7wjIQFzamljTaFKPVFSE";

    //Returns playlist of user videos
    public ResponseDto getAllPlayList() {
        return Configuration.getApi().playList(ID_USER, KEY_GOOGLE);
    }

    //Returns videos from a specific playlist
    public ResponseDto getVideosByPLayList(String playListId) {
        return Configuration.getApi().playListItem(playListId, KEY_GOOGLE);
    }

    //Returns information about a video
    public ResponseDto getInfoByVideo(String videoId) {
        return Configuration.getApi().videoDescribe(videoId, KEY_GOOGLE);
    }
}
