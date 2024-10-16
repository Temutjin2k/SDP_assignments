package assignment3.IteratorPattern;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface IterableCollection {
    Iterator<String> createIterator();
}

class CoffeeMenuIterator implements Iterator<String> {
    private final String[] items;
    private int position = 0;

    public CoffeeMenuIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public String next() {
        String item = items[position];
        position++;
        return item;
    }
}

class CoffeeMenu implements IterableCollection {
    private String[] items;
    private int count = 0;

    public CoffeeMenu(int maxItems) {
        this.items = new String[maxItems];
    }

    public void addItem(String item) {
        if (count < items.length) {
            items[count] = item;
            count++;
        } else {
            System.out.println("Menu is full, cannot add more items.");
        }
    }

    @Override
    public Iterator<String> createIterator() {
        return new CoffeeMenuIterator(items);
    }
}

public class Main {
    public static void main(String[] args) {
        CoffeeMenu coffeeMenu = new CoffeeMenu(5);
        coffeeMenu.addItem("Espresso");
        coffeeMenu.addItem("Latte");
        coffeeMenu.addItem("Cappuccino");
        coffeeMenu.addItem("Mocha");
        coffeeMenu.addItem("Americano");

        Iterator<String> iterator = coffeeMenu.createIterator();

        System.out.println("Coffee Menu:");
        while (iterator.hasNext()) {
            String coffee = iterator.next();
            System.out.println(coffee);
        }
    }
}
