//import com.sun.org.apache.xpath.internal.operations.Div;

import java.util.ArrayList;

public class Division {
    private String department;
    private String section;
    private int id;
    private String staff;
    private String role;
    private String responsibilities;
    private static ArrayList<Division>  instances = new ArrayList<>();
    private Boolean created;
//, String section, String staff, String role, String responsibilities
    public Division(String department, String section, String staff, String role, String responsibilities) {
        this.department = department;
        this.section = section;
        this.staff = staff;
        this.role = role;
        this. responsibilities = responsibilities;
        this.created = false;
        instances.add(this);
        this.id = instances.size();
    }

    public String getDepartment() {
        return department;
    }
    public String getSection() {
        return section;
    }
    public int getId() {
        return id;
    }
    public String getStaff() {
        return staff;
    }
    public String getRole() {
        return role;
    }
    public String getResponsibilities() {
        return responsibilities;
    }

    public static ArrayList<Division> getAll() {
        return instances;
    }
    public static void clearAllDivisions(){
        instances.clear(); //clear as a method is part of the ArrayList class.
    }
//    public boolean getCreated(){
//        return this.created;
//    }
    public static Division findById(int id){
        return instances.get(id-1);
    }
    public void update(String department, String section, int id, String staff, String role, String responsibilities) {
        this.department = department;
        this.section = section;
//        this.id = id;
        this.staff = staff;
        this.role = role;
        this. responsibilities = responsibilities;
    }

    public void deleteDivision(){
        instances.remove(id - 1);
    }

//    public boolean getShape() {
//        return shape;
//    }
//
//    public boolean isRectSquare() {
//        if (height == width) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}