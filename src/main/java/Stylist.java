import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.sql2o.*;

public class Stylist {
  private String name;
  private int id;

  public Stylist(String name) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Stylist> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT id, name FROM stylists";
      return con.createQuery(sql)
                .executeAndFetch(Stylist.class);
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where stylist_id = :id";
      return con.createQuery(sql)
                .addParameter("id", this.id)
                .executeAndFetch(Clients.class);
    }
  }

  public static Stylist find (int id) {
    try(Connection con = sql2o.open()) {
      String sql = "SELECT * FROM stylists where id = :id";
      Stylist stylist = con.createQuery(sql)
                           .addParameter("id", id)
                           .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
                         .addParamter("name", this.name)
                         .executeUpdate()
                         .getKey();
    }
  }

  @Override
  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getId() == newStylist.getId();
    }
  }

}
