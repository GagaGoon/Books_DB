package model;

public class Library {
    private int governmentNumber;
    private String name;
    private String address;

    public Library() {
    }

    public Library(int governmentNumber, String name, String address) {
        this.governmentNumber = governmentNumber;
        this.name = name;
        this.address = address;
    }

    public int getGovernmentNumber() {
        return governmentNumber;
    }
    public void setGovernmentNumber(int governmentNumber) {
        this.governmentNumber = governmentNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
