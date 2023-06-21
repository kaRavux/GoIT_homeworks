package org.example.models;

public class CompanyEntity {
    private String name;
    private String catchPhrase;
    private String bs;

    public CompanyEntity(String companyName, String companyCatchPhrase, String companyBs) {
        this.name = companyName;
        this.catchPhrase = companyCatchPhrase;
        this.bs = companyBs;
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }

}
