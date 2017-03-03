package br.com.jerodac.model;

import java.util.List;

import br.com.jerodac.vo.PlayListItem;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class ModelPresenter {

    private List<PlayListItem> channelList;
    private List<PlayListItem> playlistList;
    private PlayListItem currentChannel;
    private PlayListItem currentPLaylist;
    private PlayListItem currentInfoVideo;

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

    public PlayListItem getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(PlayListItem currentChannel) {
        this.currentChannel = currentChannel;
    }

    public PlayListItem getCurrentPLaylist() {
        return currentPLaylist;
    }

    public void setCurrentPLaylist(PlayListItem currentPLaylist) {
        this.currentPLaylist = currentPLaylist;
    }

    public PlayListItem getCurrentInfoVideo() {
        return currentInfoVideo;
    }

    public void setCurrentInfoVideo(PlayListItem currentInfoVideo) {
        this.currentInfoVideo = currentInfoVideo;
    }
}
