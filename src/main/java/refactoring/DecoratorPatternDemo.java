package refactoring;

import java.util.ArrayList;
import java.util.List;

interface Book {

    public String describe();

}

class BasicBook implements Book {

    @Override
    public String describe() {

        return "Book";

    }

}

abstract class BookDecorator implements Book {

    protected Book book;

    BookDecorator(Book book) {
        this.book = book;
    }

    @Override
    public String describe() {
        return book.describe();
    }
}

class FictionBookDecorator extends BookDecorator {

    FictionBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String describe() {
        return ("Fiction " + super.describe());
    }
}

class ScienceBookDecorator extends BookDecorator {

    ScienceBookDecorator(Book book) {
        super(book);
    }

    @Override
    public String describe() {
        return ("Science " + super.describe());
    }
}

class SoftCoverDecorator extends BookDecorator {

    SoftCoverDecorator(Book book) {
        super(book);
    }

    @Override
    public String describe() {
        return (super.describe() + " with Soft Cover");
    }
}

class HardCoverDecorator extends BookDecorator {

    HardCoverDecorator(Book book) {
        super(book);
    }

    @Override
    public String describe() {
        return (super.describe() + " with Hard Cover");
    }
}


public class DecoratorPatternDemo {

    public static void main(String[] args) {
        BasicBook book = new BasicBook();

        //Specify book as Fiction category
        FictionBookDecorator fictionBook = new FictionBookDecorator(book);

        //Specify that the book has a hard cover
        HardCoverDecorator hardCoverBook = new HardCoverDecorator(book);

        //What if we want to specify both the category and cover type together
        HardCoverDecorator hardCoverFictionBook = new HardCoverDecorator(fictionBook);

        //Specify book as Science category
        ScienceBookDecorator scienceBook = new ScienceBookDecorator(book);

        //What if we want to specify both the category and cover type together
        HardCoverDecorator hardCoverScienceBook = new HardCoverDecorator(scienceBook);

        //Add all the decorated book items in a list
        List<Book> bookList = new ArrayList<Book>() {
            {
                add(book);
                add(fictionBook);
                add(hardCoverBook);
                add(hardCoverFictionBook);
                add(scienceBook);
                add(hardCoverScienceBook);
            }
        };

        //Traverse the list to access all the book items
        for(Book b: bookList) {
            System.out.println(b.describe());
        }
    }
}


class BookDescriptionMainWithLambda {

    public static void main(String [] args) {

        BasicBook book = new BasicBook();

        //Specify book as Fiction category using Lambda expression
        Book fictionBook = () -> "Fiction " + book.describe();

        //Specify that the book has a hard cover using Lambda expression
        Book hardCoverBook = () -> book.describe() + " with Hard Cover";

        //What if we want to specify both the category and cover type together
        Book hardCoverFictionBook = () -> fictionBook.describe() + " with Hard Cover";

        //Specify book as Science category using Lambda expression
        Book scienceBook = () -> "Science " + book.describe();

        //What if we want to specify both the category and cover type together
        Book hardCoverScienceBook = () -> fictionBook.describe() + " with Hard Cover";

        List<Book> bookList = new ArrayList<Book>() {
            {
                add(book);
                add(fictionBook);
                add(hardCoverBook);
                add(hardCoverFictionBook);
                add(scienceBook);
                add(hardCoverScienceBook);
            }
        };

        bookList.forEach(b -> System.out.println(b.describe()));
    }
}