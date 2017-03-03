package br.com.jerodac.vo;

import java.util.List;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class VideoInfoResponse extends BaseResponse {

    private String kind;
    private List<PlayListItem> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<PlayListItem> getItems() {
        return items;
    }

    public void setItems(List<PlayListItem> items) {
        this.items = items;
    }
}
