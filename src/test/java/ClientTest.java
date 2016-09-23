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
    secondClient = new Client("Jill", "Curls", 1)
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

}
