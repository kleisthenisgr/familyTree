package DSProjectThree;

public class Node {
    String name=null;
    private String gender= null;
    private Node father = null;
    private Node mother = null;
    private Node husband = null;

    public Node(String name, String gender ) {
        this.name= name;
        this.gender= gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Node getFather() {
        return father;
    }

    public Node getMother() {
        return mother;
    }

    public Node getHusband() {
        return husband;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    public void setHusband(Node husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Node{" + "name=" + name + ", gender=" + gender + ", father=" + father + ", mother=" + mother + ", husband=" + husband + '}';
    }
       
}
