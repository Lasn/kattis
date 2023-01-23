public class Element {
    
    private String name;
    private Integer parent;

    public Element(String name, Integer parent) {
        this.name = name;
        this.parent = parent;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}
