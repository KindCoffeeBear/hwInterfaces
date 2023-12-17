import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Мальдивы", "Каир", 23_000, 2, 19);
    Ticket ticket2 = new Ticket("Мальдивы", "Каир", 76_000, 22, 9);
    Ticket ticket3 = new Ticket("Мальдивы", "Каир", 10_000, 15, 22);
    Ticket ticket4 = new Ticket("Мальдивы", "Каир", 23_000, 1, 15);
    Ticket ticket5 = new Ticket("Москва", "Сочи", 23_000, 23, 6);
    Ticket ticket6 = new Ticket("Мальдивы", "Сочи", 23_000, 23, 6);
    AviaSouls tickets = new AviaSouls();

    TicketTimeComparator timeComparator = new TicketTimeComparator();

    @Test
    public void testAdd() {
        tickets.add(ticket1);
        tickets.add(ticket4);
        tickets.add(ticket3);
        tickets.add(ticket2);

        Ticket[] expected = { ticket1, ticket4, ticket3, ticket2 };
        Ticket[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected1 = { ticket3, ticket1, ticket4, ticket2 };
        Ticket[] actual1 = tickets.search("Мальдивы", "Каир");

        Ticket[] expected2 = {  };
        Ticket[] actual2 = tickets.search("Бразилиа", "Москва");

        Assertions.assertArrayEquals(expected1, actual1);
        Assertions.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testSearchAndSortBy() {
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        Ticket[] expected1 = { ticket3, ticket2, ticket4, ticket1 };
        Ticket[] actual1 = tickets.searchAndSortBy("Мальдивы", "Каир", timeComparator);

        Ticket[] expected2 = {  };
        Ticket[] actual2 = tickets.searchAndSortBy("Бразилиа", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected1, actual1);
        Assertions.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void testCompare() {
        int expected1 = -1;
        int actual1 = timeComparator.compare(ticket2, ticket1);

        int expected2 = 1;
        int actual2 = timeComparator.compare(ticket1, ticket4);

        int expected3 = 0;
        int actual3 = timeComparator.compare(ticket3, ticket5);

        Assertions.assertEquals(expected1,actual1);
        Assertions.assertEquals(expected2,actual2);
        Assertions.assertEquals(expected3,actual3);
    }

    @Test
    public void testCompareTo() {
        int expected1 = -1;
        int actual1 = ticket1.compareTo(ticket2);

        int expected2 = 1;
        int actual2 = ticket1.compareTo(ticket3);

        int expected3 = 0;
        int actual3 = ticket1.compareTo(ticket4);

        Assertions.assertEquals(expected1,actual1);
        Assertions.assertEquals(expected2,actual2);
        Assertions.assertEquals(expected3,actual3);
    }

    @Test
    public void testGetPrice() {
        int expected = 23_000;
        int actual = ticket1.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetFrom() {
        String expected = "Мальдивы";
        String actual = ticket1.getFrom();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetTo() {
        String expected = "Каир";
        String actual = ticket1.getTo();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetTimeFrom() {
        int expected = 2;
        int actual = ticket1.getTimeFrom();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetTimeTo() {
        int expected = 19;
        int actual = ticket1.getTimeTo();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        int expected = 828301708;
        int actual = ticket1.hashCode();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldEqualsIfSameObject() {
        boolean expected = true;
        boolean actual = ticket1.equals(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsIfNull() {
        boolean expected = false;
        boolean actual = ticket1.equals(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsFrom() {
        Ticket newTicket = new Ticket("Кипр", "Каир", 23_000, 2, 19);
        boolean expected = false;
        boolean actual = ticket1.equals(newTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsTo() {
        Ticket newTicket = new Ticket("Мальдивы", "Москва", 23_000, 2, 19);
        boolean expected = false;
        boolean actual = ticket1.equals(newTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsPrice() {
        Ticket newTicket = new Ticket("Мальдивы", "Каир", 22_000, 2, 19);
        boolean expected = false;
        boolean actual = ticket1.equals(newTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsTimeFrom() {
        Ticket newTicket = new Ticket("Мальдивы", "Каир", 23_000, 5, 19);
        boolean expected = false;
        boolean actual = ticket1.equals(newTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsTimeTo() {
        Ticket newTicket = new Ticket("Мальдивы", "Каир", 23_000, 2, 17);
        boolean expected = false;
        boolean actual = ticket1.equals(newTicket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldEquals() {
        Ticket newProduct = new Ticket("Мальдивы", "Каир", 23_000, 2, 19);
        boolean expected = true;
        boolean actual = ticket1.equals(newProduct);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotEqualsWithOtherClass() {
        class NewClass {
            String from = "Мальдивы"; // аэропорт откуда
            String to = "Каир"; // аэропорт куда
            int price = 23_000; // цена
            int timeFrom = 2; // время вылета (по москве)
            int timeTo = 19; // время прилёта (по москве)
        }

        NewClass newClass = new NewClass();

        boolean expected = false;
        boolean actual = ticket1.equals(newClass);

        Assertions.assertEquals(expected, actual);
    }
}
