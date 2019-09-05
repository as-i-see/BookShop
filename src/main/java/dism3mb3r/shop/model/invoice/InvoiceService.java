package dism3mb3r.shop.model.invoice;

import dism3mb3r.shop.model.book.Book;
import dism3mb3r.shop.model.book.BookRepository;
import dism3mb3r.shop.model.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {
    private BookRepository bookRepository;
    private InvoiceRepository invoiceRepository;
    private UserRepository userRepository;

    public InvoiceService(BookRepository bookRepository, InvoiceRepository invoiceRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
    }

    public Invoice createInvoiceForChoices(String[] choices) {
        Invoice invoice = new Invoice();
        Integer price = 0;
        for (String choice : choices) {
            Long choiceId = Long.parseLong(choice);
            Optional<Book> optionalBook = bookRepository.findById(choiceId);

            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                price += book.getPrice();
            }


        }
        invoice.setPrice(price);
        invoiceRepository.save(invoice);
        return invoice;
    }
}
