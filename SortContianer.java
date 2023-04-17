public class SortContianer implements Comparable<SortContianer>{
    private String uuId;
    private String shortNameTag;
    private String longNameTag;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getShortNameTag() {
        return shortNameTag;
    }

    public void setShortNameTag(String shortNameTag) {
        this.shortNameTag = shortNameTag;
    }

    public String getLongNameTag() {
        return longNameTag;
    }

    public void setLongNameTag(String longNameTag) {
        this.longNameTag = longNameTag;
    }
//override to string method
    @Override
    public String toString() {
        return "<CONTAINER " + uuId + '>' + "\n" +
                "<SHORT-NAME>"+ shortNameTag +"</SHORT-NAME>" + "\n" +
                "<LONG-NAME>"+ longNameTag +"</LONG-NAME>" +"\n"
                +"</CONTAINER>\n";
    }
//override compare to
    @Override
    public int compareTo(SortContianer o) {
        if(this.getShortNameTag().charAt(9)>o.getShortNameTag().charAt(9))
        {
            return 1;
        }
        else if(this.getShortNameTag().charAt(9)<o.getShortNameTag().charAt(9))
        {
            return -1;
        }
        return 0;
    }
}
