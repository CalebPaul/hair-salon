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

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    assertTrue(firstStylist instanceof Stylist);
  }

  @Test
  public void getName_instantiatesCorrectlyWithName_String() {
    assertEquals("Andre", firstStylist.getName());
  }

  @Test
  public void getId_instantiatesCorrectlyWithId_int() {
    firstStylist.save();
    assertTrue(firstStylist.getId() > 0);
  }

  @Test
  public void all_checksIfStylistContainsInstance_true() {
    firstStylist.save();
    secondStylist.save();
    assertTrue(Stylist.all().get(0).equals(firstStylist));
    assertTrue(Stylist.all().get(1).equals(secondStylist));
  }

  @Test
  public void getClients_retievesAllClientsFromDB_clientsList() {
    firstStylist.save();
    firstClient = new Client("Bill", "Buzz", 1);
    firstClient.save();
    secondClient = new Client("Jill", "Curls", 1);
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(firstStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    firstStylist.save();
    secondStylist();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

  @Test
  public void save_assignsIDToObject() {
    firstStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(firstStylist.getId(), savedStylist.getId());
  }

  @Test
  public void save_savesIntoDatabase_true() {
    firstStylist.save();
    assertTrue(Stylist.all().get(0).equals(firstStylist));
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame_true() {
    Stylist testStylist = new Stylist("Andre");
    assertTrue(firstStylist.equals(testStylist));
  }

}
