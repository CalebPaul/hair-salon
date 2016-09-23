
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", request, response -> {
      Map<String, Object> model = new HashMap<>();
      //add model.put() and logic here
      //add model.put() and logic here
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
