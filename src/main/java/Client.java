import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.sql2o.*;

public class Client {
  private String name;
  private String cut;
  private int stylist_id;
  private int id;

  public Client(String name, String cut, int stylist_id) {
    this.name = name;
    this.cut = cut;
    this.stylist_id = stylist_id;
  }

  public String getName() {
    return name;
  }

  public String getCut() {
    return cut;
  }

  public int getStylistId() {
    return stylist_id;
  }

  public int getId() {
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, cut, stylist_id) VALUES (:name, :cut, :stylist_id)";
      this.id = (int) con.createQuery(sql, true)
                         .addParameter("name", this.name)
                         .addParameter("cut", this.cut)
                         .addParameter("stylist_id", this.stylist_id)
                         .executeUpdate()
                         .getKey();
    }
  }

  public static List<Client> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT id, name, cut, stylist_id FROM clients";
        return con.createQuery(sql)
                  .executeAndFetch(Client.class);
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where stylist_id = :id";
      return con.createQuery(sql)
                .addParameter("id", this.id)
                .executeAndFetch(Client.class);
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "Select * FROM clients WHERE id = :id";
      Client client = con.createQuery(sql)
                         .addParameter("id", id)
                         .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id;";
      con.createQuery(sql)
         .addParameter("id", id)
         .executeUpdate();
    }
  }

  @Override
  public boolean equals (Object otherClient) {
    if(!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
      this.getCut().equals(newClient.getCut()) &&
      this.getStylistId() == newClient.getStylistId();
    }
  }

}
