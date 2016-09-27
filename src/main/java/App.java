
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //Home Page
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Add client to specific Stylist form
    get("/stylists/:id/clients/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist", stylist);
      model.put("template", "templates/stylist-client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylists", Stylist.all());
      model.put("stylist", stylist);
      model.put("template", "templates/clients");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //View all Clients
    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("clients", Client.all());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Add new Stylist form
    get("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Update Client
    post("/stylists/:stylist_id/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client client = Client.find(Integer.parseInt(request.params("id")));
      String cut = request.queryParams("cut");
      Stylist stylist = Stylist.find(client.getStylistId());
      client.update(cut);
      model.put("stylist", stylist);
      model.put("clients", Client.all());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Add new Stylist
    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      String name = request.queryParams("name");
      Stylist newStylist = new Stylist(name);
      newStylist.save();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Update Stylist
    post("/stylists/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      String name = request.queryParams("name");
      stylist.update(name);
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Delete Stylist
    post("/stylists/:id/delete", (request, response) -> {
      HashMap<String, Object> model = new HashMap<>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      stylist.delete();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Delete Client
    post("/clients/:id/delete", (request, response) -> {
      HashMap<String, Object> model = new HashMap<>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      client.delete();
      model.put("clients", Client.all());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Add Client
    post("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
      String name = request.queryParams("name");
      String cut = request.queryParams("cut");
      Client newClient = new Client(name, cut, stylist.getId());
      newClient.save();
      model.put("clients", Client.all());
      model.put("stylist", stylist);
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //View Client Details
    get("/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      Stylist stylist = Stylist.find(client.getStylistId());
      model.put("stylist", stylist);
      model.put("client", client);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //View All Stylists
    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //View Stylist Details
    get("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("clients", Client.all());
      model.put("stylist", stylist);
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
