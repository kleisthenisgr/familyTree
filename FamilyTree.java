package DSProjectThree;

import java.util.ArrayList;
import java.util.HashMap;

public class FamilyTree {
    private HashMap<String , Node> familyTree;
    public FamilyTree() {
        this.familyTree = new HashMap<>();
    }

    public void setFamilyTree(HashMap<String, Node> familyTree) {
        this.familyTree = familyTree;
    }

    public HashMap<String, Node> getFamilyTree() {
        return familyTree;
    }
    
    public void initialize(ArrayList results){
        for(int i=0; i<results.size(); i++){
            ArrayList<String> entry = (ArrayList<String>) results.get(i);
            if(entry.size()== 2){
                addPerson(entry);
            }
            else if(entry.size()==3){
                addRelation(entry);
            }
        }
    }
    
    void addPerson(ArrayList<String> entry){
        Node person = new Node(entry.get(0), entry.get(1));
        familyTree.put(person.name, person);
    }
    
    void addRelation(ArrayList<String> entry){
        Node person = familyTree.get(entry.get(2));
        familyTree.put(person.name, person);
        
        if(entry.get(1).compareTo("Father")==0)
            person.setFather(familyTree.get(entry.get(0)));
        else if(entry.get(1).compareTo("Mother")==0)
            person.setMother(familyTree.get(entry.get(0)));
        else if(entry.get(1).compareTo("Husband")==0)
            person.setHusband(familyTree.get(entry.get(0)));
    }
    
    public void makeQuery(String firstPerson, String secondPerson){
        if (checkIfFather(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Father of "+secondPerson);
        else if(checkIfMother(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Mother of "+secondPerson);
        else if(checkIfSon(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Son of "+secondPerson);
        else if(checkIfDaughter(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Daughter of "+secondPerson);
        else if(checkIfBrother(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Brother of "+secondPerson);
        else if(checkIfSister (firstPerson, secondPerson))
            System.out.println(firstPerson+" is Sister of "+secondPerson);
        else if(checkIfCousin(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Cousin of "+secondPerson);
        else if(checkIfGrandpa(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Grandfather of "+secondPerson);
        else if(checkIfGrandma(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Grandmother of "+secondPerson);
        else if(checkIfGrandson(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Grandson of "+secondPerson);
        else if (checkIfGranddaughter(firstPerson,secondPerson))
            System.out.println(firstPerson+" is Granddaughter of "+secondPerson);
        else if (checkIfHusband(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Husband of "+ secondPerson);
        else if (checkIfWife(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Wife of "+secondPerson);
        else if (checkIfUncle(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Uncle of "+ secondPerson);
        else if (checkIfAunt(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Aunt of "+secondPerson);
        else if (checkIfNephew(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Nephew of "+secondPerson);
        else if (checkIfNiece(firstPerson, secondPerson))
            System.out.println(firstPerson+" is Niece of "+secondPerson);
        else
            System.out.println("No relation found between "+firstPerson+" and "+secondPerson);
    }
        
    private boolean checkIfFather(String parentName, String childName){
        Node person = familyTree.get(childName);
        if (person.getFather()!=null && person.getFather().name.compareTo(parentName)==0)
            return true;
        return false;    
    }
    
    private boolean checkIfMother(String parentName, String childName){
        Node person = familyTree.get(childName);
        if (person.getMother()!=null && person.getMother().name.compareTo(parentName)==0)
            return true;
        return false;
    }
    
    private boolean checkIfSon(String sonName, String parentName){
        Node person = familyTree.get(sonName);
        if ((person.getFather()!=null && person.getFather().name.compareTo(parentName)==0) || (person.getMother()!=null && person.getMother().name.compareTo(parentName)==0))
            if(checkIfMale(sonName))
                return true;
        return false;
    }
    
    private boolean checkIfDaughter(String daughterName, String parentName){
        Node person = familyTree.get(daughterName);
        if ((person.getFather()!=null && person.getFather().name.compareTo(parentName)==0) || (person.getMother()!=null && person.getMother().name.compareTo(parentName)==0))
            if(!checkIfMale(daughterName))
                return true;
        return false;
    }
    
    private boolean checkIfMale(String person){
        Node p = familyTree.get(person);
        return p.getGender()!=null && p.getGender().compareTo("Man")==0;
    }
    
    private boolean checkIfBrother(String brother1, String sibling){
        Node person1 = familyTree.get(brother1);
        Node person2 = familyTree.get(sibling);
        String father1 = null;
        String father2 = null;
        String mother1 = null;
        String mother2 = null;
        
        if (person1.getFather()!=null && person2.getFather()!=null)
        {
            father1= person1.getFather().name;
            father2 = person2.getFather().name;
        }
        
        if (person1.getMother()!=null && person2.getMother()!=null)
        {
            mother1= person1.getMother().name;
            mother2= person2.getMother().name;
        }
        
        if (((father1!=null && father2!=null)&& father1.equals(father2)) || (mother1!=null && mother2!=null) && mother1.equals(mother2))
        {
            return checkIfMale(person1.getName());
        }
        
        return false;
    }
    
    // Assumed 1 parent is common to find siblings
    private boolean checkIfSister(String sister1, String sibling)
    {
        Node person1 = familyTree.get(sister1);
        Node person2 = familyTree.get(sibling);
        String father1 = null;
        String father2 = null;
        String mother1 = null;
        String mother2 = null;
        
        if (person1.getFather()!=null && person2.getFather()!=null)
        {
            father1= person1.getFather().name;
            father2 = person2.getFather().name;
        }
        
        if (person1.getMother()!=null && person2.getMother()!=null)
        {
            mother1= person1.getMother().name;
            mother2= person2.getMother().name;
        }
        
        if (((father1!=null && father2!=null)&& father1.equals(father2)) || (mother1!=null && mother2!=null) && mother1.equals(mother2))
        {
            return (!checkIfMale(person1.getName()));
        }
        
        return false;
    }
    
    // Assumed 1 parent is sibling to other person's parent for cousins
    private boolean checkIfCousin(String firstPerson, String secondPerson){
        Node person1 = familyTree.get(firstPerson);
        Node person2 = familyTree.get(secondPerson);
        String father1 = null;
        String father2 = null;
        String mother1 = null;
        String mother2 = null;
        
        if (person1.getFather()!=null) 
        {
            father1 = person1.getFather().name;   
        }
        
        if (person2.getFather()!=null)
        {    
            father2 = person2.getFather().name;
        }
        
        if (person1.getMother()!=null) 
        {
            mother1 = person1.getMother().name;
        }
        
        if (person2.getMother()!=null)
        {   
            mother2 = person2.getMother().name;
        }
        
        if (father1!=null && father2!=null && checkIfBrother(father1, father2)){
            return true;
        }
        
        if (father1!=null && mother2!=null && checkIfBrother(father1, mother2))
        {
            return true;
        }
        
        if (mother1!=null && father2!=null && checkIfSister(mother1, father2))
        {
            return true;
        }
        
        if (mother1!=null && mother2!=null && checkIfSister(mother1, mother2)){
            return true;
        }
        
        return false;       
    }
    
    // father's father, or mother's father
    private boolean checkIfGrandpa(String grandfather, String grandChild){
        Node person2= familyTree.get(grandChild);
        String grandpa2a = null;
        String grandpa2b = null;
        
        if (person2.getFather()!=null){
            Node person2father= familyTree.get(person2.getFather().name);
            if (person2father.getFather()!=null)
                grandpa2a= person2father.getFather().name;
        }
        
        if (person2.getMother()!=null){
            Node person2mother= familyTree.get(person2.getMother().name);
            if (person2mother.getFather()!=null)
                grandpa2b= person2mother.getFather().name;
        }
        
        if (grandpa2a!=null && grandpa2a.equals(grandfather) || grandpa2b!=null && grandpa2b.equals(grandfather))
            return true;
                
        return false;
    }
    
    // father's mother or mother's mother
    private boolean checkIfGrandma(String grandmother, String grandchild)
    {
        Node person2 = familyTree.get(grandchild);
        String grandma2a = null;
        String grandma2b = null;
        
        if(person2.getFather()!=null){
            Node person2father= familyTree.get(person2.getFather().name);
            if(person2father.getMother()!=null)
                grandma2a = person2father.getMother().name;
        }
        
        if(person2.getMother()!=null){
            Node person2mother = familyTree.get(person2.getMother().name);
            if(person2mother.getMother()!=null)
                grandma2b = person2mother.getMother().name;
        }
        
        if (grandma2a!=null && grandma2a.equals(grandmother) || grandma2b!=null && grandma2b.equals(grandmother))
            return true;
        
        return false;
    }
    
    // reverse parameters and rerun grandpa, check gender
    private boolean checkIfGrandson(String grandson, String grandparent)
    {
        if (checkIfGrandpa(grandparent, grandson) || checkIfGrandma(grandparent,grandson))
            if (checkIfMale(grandson))
                return true;
        
        return false;
    }
    
    // reverse parameters and rerun grandpa, check gender
    private boolean checkIfGranddaughter(String granddaughter, String grandparent)
    {
        if (checkIfGrandpa(grandparent, granddaughter) || checkIfGrandma(grandparent,granddaughter))
            if (!checkIfMale(granddaughter))
                return true;
        
        return false;
    }
        
    private boolean checkIfHusband(String husband, String wife)
    {
        Node person2= familyTree.get(wife);
        if (person2.getHusband()!=null)
            if (person2.getHusband().name.equals(husband))
                return true;
        return false;
    }
    
    // reverse parameters and check wife's husband
    private boolean checkIfWife(String wife, String husband)
    {
        Node person1= familyTree.get(wife);
        if (person1.getHusband()!=null)
            if(person1.getHusband().name.equals(husband))
                return true;
        return false;
    }
    
    // check sibling relation between nephew's 1 parent and uncle
    private boolean checkIfUncle(String uncle, String nephewOrNiece)
    {
        Node person2= familyTree.get(nephewOrNiece);
        if (person2.getFather()!=null)
            if(checkIfBrother(person2.getFather().name, uncle))
                    return true;
        
        if (person2.getMother()!= null)
            if(checkIfSister(person2.getMother().name, uncle))
                return true;
        return false;
    }
    
    // check sibling relation between nephew's 1 parent and aunt
    private boolean checkIfAunt(String aunt, String nephewOrNiece)
    {
        Node person2 = familyTree.get(nephewOrNiece);
        if(person2.getFather()!=null)
            if(checkIfSister(aunt, person2.getFather().name))
                return true;
        
        if (person2.getMother()!=null)
            if (checkIfSister(aunt, person2.getMother().name))
                return true;
        
        return false;
    }
    
    //reverse uncle-aunt check
    private boolean checkIfNephew(String nephew, String uncleOrAunt)
    {
        if(checkIfAunt(uncleOrAunt, nephew) || checkIfUncle(uncleOrAunt, nephew))
            if(checkIfMale(nephew))
                return true;
        
        return false;
    }
    
    private boolean checkIfNiece(String niece, String uncleOrAunt)
    {
        if (checkIfAunt(uncleOrAunt, niece) || checkIfUncle(uncleOrAunt, niece))
            if(!checkIfMale(niece))
                return true;
        
        return false;
    }
}
