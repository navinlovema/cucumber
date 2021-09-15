package designpattern.creational.prototype;

import io.cucumber.java.hu.De;
import io.cucumber.java.hu.Ha;

import java.util.HashMap;

abstract  class Item implements Cloneable {
    private String title;
    private String price;
    private String url;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

class Book extends Item {
    private int numberOfPages;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}

class Movie extends Item {
    private int runtime;

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "runtime=" + runtime +
                '}';
    }
}
public class DeepCopyRegistry {

    HashMap<String, Item> items = new HashMap<>();

    public DeepCopyRegistry(){loadItem();}

    public Item createItem(String type) throws CloneNotSupportedException {
        Item item = null;
        return (Item) items.get(type).clone();
    }


    private void loadItem() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice("299");
        movie.setUrl("");
        movie.setRuntime(2);
        items.put("Movie", movie);

        Book book = new Book();
        book.setTitle("book1");
        book.setPrice("299");
        book.setUrl("");
        book.setNumberOfPages(202);
        items.put("book", book);
    }

}


class caller{
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCopyRegistry deepCopyRegistry = new DeepCopyRegistry();
        Movie movie = (Movie) deepCopyRegistry.createItem("Movie");
        movie.setTitle("AbaraKaDabara");
        System.out.println(movie.getTitle());

    }

}