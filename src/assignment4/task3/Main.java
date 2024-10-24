package assignment4.task3;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String headline);
}

class NewsAgency implements Observable {
    private String headline;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(headline);
        }
    }

    public void setHeadline(String newHeadline) {
        this.headline = newHeadline;
        notifyObservers();
    }

    public String getHeadline() {
        return this.headline;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}

// NewsChannel class implements Observer
class NewsChannel implements Observer {
    private String channelHeadline;

    @Override
    public void update(String headline) {
        this.channelHeadline = headline;
        System.out.println("NewsChannel received an update: " + headline);
    }

    public String getChannelHeadline() {
        return this.channelHeadline;
    }
}

public class Main {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        NewsChannel channel1 = new NewsChannel();
        NewsChannel channel2 = new NewsChannel();

        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);

        newsAgency.setHeadline("Fun Fact: Genghis Khan was born as Temüjin around 1162 in what is now Mongolia.");

        System.out.println("Channel 1 current headline: " + channel1.getChannelHeadline());
        System.out.println("Channel 2 current headline: " + channel2.getChannelHeadline());

        // Удаляем обзервер
        newsAgency.removeObserver(channel2);
        newsAgency.setHeadline("Breaking News: Observer Removed from List!");

        // Сново проверяем
        System.out.println("Channel 1 current headline: " + channel1.getChannelHeadline());
        System.out.println("Channel 2 current headline: " + channel2.getChannelHeadline());
    }
}
