package things;

public abstract class Thing {
    public boolean isMany;
    private String descr;

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDescr() {
        return this.descr;
    }
}
