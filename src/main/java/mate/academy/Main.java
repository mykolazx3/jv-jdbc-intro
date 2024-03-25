package mate.academy;

import java.math.BigDecimal;
import mate.academy.dao.BookDao;
import mate.academy.lib.Injector;
import mate.academy.model.Book;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) {
        BookDao bookDao = (BookDao) injector.getInstance(BookDao.class);

        Book myBook = new Book("MyBook", BigDecimal.valueOf(10));
        myBook = bookDao.create(myBook);
        System.out.println("\nCreated book: " + myBook);

        Long id = myBook.getId();
        System.out.println("\nBook by id=" + id + ": " + bookDao.findById(id));

        System.out.println("\nAll book from DB: " + bookDao.findAll());

        Book bookToUpdate = new Book(id, "Updated book", BigDecimal.valueOf(20));
        System.out.println("\nBook to update: " + bookDao.findById(id) + "\nResult: "
                + bookDao.update(bookToUpdate));

        System.out.println("\nBook to delete: " + bookDao.findById(id) + "\nIs deleted: "
                + bookDao.deleteById(id) + "\nResult: " + bookDao.findById(id));

    }
}
