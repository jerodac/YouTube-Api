package br.com.jerodac.model;

import java.util.List;

import br.com.jerodac.vo.PlayListItem;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class ModelPresenter {

    private List<PlayListItem> channelList;
    private List<PlayListItem> playlistList;
    private PlayListItem currentPlaylist;

    public List<PlayListItem> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<PlayListItem> channelList) {
        this.channelList = channelList;
    }

    public List<PlayListItem> getPlaylistList() {
        return playlistList;
    }

    public void setPlaylistList(List<PlayListItem> playlistList) {
        this.playlistList = playlistList;
    }

    public PlayListItem getCurrentPlaylist() {
        return currentPlaylist;
    }

    public void setCurrentPlaylist(PlayListItem currentPlaylist) {
        this.currentPlaylist = currentPlaylist;
    }
}
