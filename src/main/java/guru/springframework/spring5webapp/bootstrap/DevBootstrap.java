package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repasitories.AuthorRepasitory;
import guru.springframework.spring5webapp.repasitories.BookRepasitory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepasitory authorRepasitory;
    private BookRepasitory bookRepasitory;

    public DevBootstrap(AuthorRepasitory authorRepasitory, BookRepasitory bookRepasitory) {
        this.authorRepasitory = authorRepasitory;
        this.bookRepasitory = bookRepasitory;
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        //Sardor
        Author sardor=new Author("Sardor","Matkarimov");
        Book ddd=new Book("Domain Driven Design","12340","Worx");
        sardor.getBooks().add(ddd);
        ddd.getAuthors().add(sardor);

        authorRepasitory.save(sardor);
        bookRepasitory.save(ddd);

        //Ibrat
        Author ibrat=new Author("Ibrat","Urinov");
        Book aaa=new Book("Dasturlash asoslari","131","Qosim");
        ibrat.getBooks().add(aaa);
        aaa.getAuthors().add(ibrat);

        authorRepasitory.save(ibrat);
        bookRepasitory.save(aaa);

    }
}
