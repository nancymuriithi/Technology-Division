import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//
//import models.Post;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App{
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Division> divisions = Division.getAll();
            model.put("division", divisions);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new department form
        get("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newdepartment-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new department form
        post("/posts/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            //int id = Integer.parseInt(request.queryParams("id"));
            String name = request.queryParams("staff_name");
            String department = request.queryParams("department");
            String section = request.queryParams("section");
            String role = request.queryParams("role");
            String responsibilities = request.queryParams("responsibilities");
            System.out.println(department);
//            ,section, name, role, responsibilities
            Division division = new Division(department,section, name, role, responsibilities);

            response.redirect("/");
            return null;
//            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show created departments
//        get("/posts", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());

        //get: delete all departments
        get("/posts/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Division.clearAllDivisions();
            return new ModelAndView(model, "department-delete.hbs");
        }, new HandlebarsTemplateEngine());


        get("/posts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDepartmentToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Division foundDivision = Division.findById(idOfDepartmentToFind);
            model.put("division", foundDivision); //add it to model for template to display
            return new ModelAndView(model, "department-detail.hbs"); //individual department page.
        }, new HandlebarsTemplateEngine());

//        //get: show all departments
//        get("/posts", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            ArrayList<Division> divisions = Division.getAll();
//            model.put("divisions", divisions);
//            return new ModelAndView(new HashMap(), "department-detail.hbs");
//        }, new HandlebarsTemplateEngine());


        //get: show a form to update a post
        get("/posts/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDivisionToEdit = Integer.parseInt(req.params("id"));
            Division editDivision = Division.findById(idOfDivisionToEdit);
            model.put("editDivision", editDivision);
            return new ModelAndView(model, "editdepartment-form.hbs");
        }, new HandlebarsTemplateEngine());
//
        get("/posts/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfDivisionToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Division deleteDivision = Division.findById(idOfDivisionToDelete); //use it to find post
            deleteDivision.deleteDivision();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show new department form
//        get("/posts/new/staff", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "form.hbs");
//        }, new HandlebarsTemplateEngine());

//        post: process new staff form
//        post("/posts/new/staff", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            //int id = Integer.parseInt(request.queryParams("id"));
//            String name = request.queryParams("staff_name");
//            String department = request.queryParams("department");
//            String section = request.queryParams("section");
//            String role = request.queryParams("role");
//            String responsibilities = request.queryParams("responsibilities");
//            System.out.println(department);
//            Division division = new Division(department,section, name, role, responsibilities);
////            response.redirect("staff-detail.hbs");
////            return null;
//            model.put("division", division);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());

//        get("/posts/all-staff", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Division> divisions = Division.getAll();
//            model.put("division", divisions);
//            return new ModelAndView(model, "staff-detail.hbs");
//        }, new HandlebarsTemplateEngine());


    }


}

































