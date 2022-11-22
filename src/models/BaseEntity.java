package models;

import java.util.Date;

public abstract class BaseEntity {
    private Long id;
    private String name;
    private Boolean active;
    private String  addDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return
                "| id: " + id +
                "| name: " + name +
                "| active: " + active +
                "| addDate: " + addDate;
    }


    public void toStringIdName() {
        System.out.println(id + ": " + name);
    }
}
