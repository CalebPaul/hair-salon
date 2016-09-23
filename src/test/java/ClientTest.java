import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ClientTest {
  private Client firstClient;
  private Client secondClient;

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Before
  public void initialize() {
    DB.sq2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    firstClient = new Client("Bill", "Buzz", 1);
    secondClient = new Client("Jill", "Curls", 1);
  }

  @Test
  public void client_instantiatesCorrectly_true() {
    assertTrue(true, firstClient instance of Client);
  }

  @Test public void getName_instantiatesCorrectlyWithName_String() {
    assertEquals("Bill", firstClient.getName());
  }

  @Test public void getCut_instantiatesCorrectlyWithCut_String() {
    assertEquals("buzz", firstClient.getCut());
  }

  @Test public void getId_instantiatesCorrectlyWithId() {
    firstClient.save();
    assertTrue(firstClient.getId() > 0);
  }

  @Test public void getId_instantiatesCorrectlyWithId() {
    assertEquals(1, firstClient.getStylistId());
  }

  @Test
  public void save_returnsTrueIfCutsAreTheSame() {
    Client newClient = new Client("Jana", "Short", 1);
    newClient.save();
    Client savedClient = Client.all().get(0);
    assertTrue(Client.all().get(0).equals(newClient));
    assertEquals(newClient.getId(), savedClient.getId());
  }

  @Test
  public void save_saveStylistIdIntoDB() {
    Stylist newStylist = new Stylist("Lisa");
    newStylist.save();
    Client newClient = new Client("Jana", "Short", 1);
    newClient.save();
    Client savedClient = Client.find(newClient.getId());
    assertEquals(savedClient.getStylistId(), newStylist.getId());
  }

  @Test
  public void all_returnsAllInstancesOfClient_true() {
    firstClient.save();
    secondClient.save();
    assertTrue(Client.all().get(0).equals(firstClient));
    assertTrue(Client.all().get(1).equals(secondClient));
  }

  @Test
  public void find_returnClientWithSameId_secondClient() {
    firstClient.save();
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame_true() {
    Client testClient = new Client("Jana", "Short", 1);
  }

}
