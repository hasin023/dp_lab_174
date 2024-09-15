public class Champion {
    private String name;
    private String role;
    private String lane;

    public Champion(String name, String role, String lane) {
        this.name = name;
        this.role = role;
        this.lane = lane;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getLane() {
        return lane;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String toString() {
        return "Champion: " + name + ", Role: " + role + ", Lane: " + lane;
    }
}
