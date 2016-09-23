import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class StylistTest {
  private Stylist firstStylist;
  private Stylist secondStylist;
  private Client newClient;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    firstStylist = new Stylist("Andre");
    secondStylist = new Stylist("Britt");
    newClient = newClient("Allie", "Straight", 1);
  }

  

}
