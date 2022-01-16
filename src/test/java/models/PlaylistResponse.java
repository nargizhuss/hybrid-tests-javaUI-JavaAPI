package models;

public class PlaylistResponse {

    private String name;
    private int id;

    public PlaylistResponse(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public PlaylistResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
