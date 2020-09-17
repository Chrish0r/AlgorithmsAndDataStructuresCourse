package stack_stapel.url;

public class URLElement {

    private String url;

    private URLElement next; // -> darunterliegendes Element

    public URLElement(String url, URLElement next) {
        this.url = url;
        this.next = next;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public URLElement getNext() {
        return next;
    }

    public void setNext(URLElement next) {
        this.next = next;
    }
}
