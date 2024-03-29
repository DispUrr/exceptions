import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product item1 = new Book(1, "Хоббит или Туда и обратно", 200, "Джон Р.Р. Толкин");
    private Product item2 = new Book(2, "Ученик убийцы", 250, "Робин Хобб");
    private Product item3 = new TShirt(3, "красный", 350, "ASICS");
    private Product item4 = new TShirt(4, "синий", 1000, "Reebok");

    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
    }

    @Test
    void shouldRemoveByExistId() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {item2, item3, item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotExistId(){
        assertThrows(NotFoundException.class, () -> repository.removeById(33));
    }

}
