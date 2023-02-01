package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repasitories.BookRepasitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepasitory bookRepasitory;

    public BookController(BookRepasitory bookRepasitory) {
        this.bookRepasitory = bookRepasitory;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepasitory.findAll());
        return "books";
    }
}
