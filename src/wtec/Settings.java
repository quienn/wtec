package wtec;

import java.io.Serializable;

public class Settings implements Serializable {

    private int staffCount;
    private int alumniCount;
    private int itemsCount;

    private int staffSize;
    private int alumniSize;
    private int itemsSize;

    public Settings() {
        this.staffCount = 0;
        this.alumniCount = 0;
        this.itemsCount = 0;
        this.staffSize = 0;
        this.alumniSize = 0;
        this.itemsSize = 0;
    }

    public int getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(int staffSize) {
        this.staffSize = staffSize;
    }

    public int getAlumniSize() {
        return alumniSize;
    }

    public void setAlumniSize(int alumniSize) {
        this.alumniSize = alumniSize;
    }

    public int getItemsSize() {
        return itemsSize;
    }

    public void setItemsSize(int itemsSize) {
        this.itemsSize = itemsSize;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public int getAlumniCount() {
        return alumniCount;
    }

    public void setAlumniCount(int alumniCount) {
        this.alumniCount = alumniCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }
}
