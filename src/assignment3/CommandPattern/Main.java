package assignment3.CommandPattern;

interface Command {
    void execute();
}

class Car {
    public void reserve() {
        System.out.println("Car is reserved.");
    }

    public void start() {
        System.out.println("Car has started.");
    }

    public void stop() {
        System.out.println("Car has stopped.");
    }
}

class ReserveCarCommand implements Command {
    private Car car;

    public ReserveCarCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.reserve();
    }
}


class StartCarCommand implements Command {
    private Car car;

    public StartCarCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.start();
    }
}

class StopCarCommand implements Command {
    private Car car;

    public StopCarCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.stop();
    }
}

// Command class
class CarSharingApp {
    private Command reserveCommand;
    private Command startCommand;
    private Command stopCommand;

    public CarSharingApp(Command reserveCommand, Command startCommand, Command stopCommand) {
        this.reserveCommand = reserveCommand;
        this.startCommand = startCommand;
        this.stopCommand = stopCommand;
    }

    public void pressReserve() {
        reserveCommand.execute();
    }

    public void pressStart() {
        startCommand.execute();
    }

    public void pressStop() {
        stopCommand.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        Command reserveCommand = new ReserveCarCommand(car);
        Command startCommand = new StartCarCommand(car);
        Command stopCommand = new StopCarCommand(car);

        CarSharingApp app = new CarSharingApp(reserveCommand, startCommand, stopCommand);

        app.pressReserve();
        app.pressStart();
        app.pressStop();
    }
}
