package br.com.jerodac.vo;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class PageInfo {

    private int totalResults;
    private int resultsPerPage;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
