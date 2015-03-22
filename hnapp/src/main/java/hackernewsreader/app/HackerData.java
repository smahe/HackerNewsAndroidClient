package hackernewsreader.app;

public class HackerData {
    private String title;
    private String url;
    private int rank;
    private String cmts;

    public HackerData(String title,String url,int rank,String cmts){
        this.title = title;
        this.url = url;
        this.rank  = rank;
        this.cmts = cmts;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setUrl(String title){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }

    public void setComments(String cmts){
        this.cmts = cmts;
    }

    public String getComments(){
        return cmts;
    }
}

