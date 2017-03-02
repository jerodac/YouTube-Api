package br.com.jerodac.vo;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class PlayListItem {

    private String id;

    private Snippet snippet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }
}
