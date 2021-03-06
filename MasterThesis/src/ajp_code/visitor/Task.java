package ajp_code.visitor;
import java.util.ArrayList;
/**
 * @author  Marcel Birkner
 */
public class Task implements ProjectItem{
    private String name;
    private ArrayList projectItems = new ArrayList();
    private Contact owner;
    private double timeRequired;
    
    public Task(){ }
    public Task(String newName, Contact newOwner,
        double newTimeRequired){
        name = newName;
        owner = newOwner;
        timeRequired = newTimeRequired;
    }
    
    /**
     * @return  the name
     * @uml.property  name="name"
     */
    public String getName(){ return name; }
    /**
     * @return  the projectItems
     * @uml.property  name="projectItems"
     */
    public ArrayList getProjectItems(){ return projectItems; }
    /**
     * @return  the owner
     * @uml.property  name="owner"
     */
    public Contact getOwner(){ return owner; }
    /**
     * @return  the timeRequired
     * @uml.property  name="timeRequired"
     */
    public double getTimeRequired(){ return timeRequired; }
    
    /**
     * @param name  the name to set
     * @uml.property  name="name"
     */
    public void setName(String newName){ name = newName; }
    /**
     * @param owner  the owner to set
     * @uml.property  name="owner"
     */
    public void setOwner(Contact newOwner){ owner = newOwner; }
    /**
     * @param timeRequired  the timeRequired to set
     * @uml.property  name="timeRequired"
     */
    public void setTimeRequired(double newTimeRequired){ timeRequired = newTimeRequired; }
    
    public void addProjectItem(ProjectItem element){
        if (!projectItems.contains(element)){
            projectItems.add(element);
        }
    }
    
    public void removeProjectItem(ProjectItem element){
        projectItems.remove(element);
    }
    
    public void accept(ProjectVisitor v){
        v.visitTask(this);
    }
}