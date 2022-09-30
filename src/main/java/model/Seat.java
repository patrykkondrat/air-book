package model;

public class Seat {
    private Long id;
    private String place;
    private String name;
    private String cost;

    public Seat(Long id, String place, String name, String cost) {
        this.id = id;
        this.place = place;
        this.name = name;
        this.cost = cost;
    }

    public Seat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
