package beangate.datta.fragmentexample;

public class Item {

    String qname,qid,qemail;

    public Item(String qname, String qid, String qemail) {

        this.qname = qname;
        this.qid = qid;
        this.qemail = qemail;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQemail() {
        return qemail;
    }

    public void setQemail(String qemail) {
        this.qemail = qemail;
    }
}
