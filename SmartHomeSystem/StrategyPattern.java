import java.util.List;

interface ControlStrategy {
    void execute(List<Devices> devices);
}

class ManualControl implements ControlStrategy {
    public void execute(List<Devices> devices) {
        for (Devices device : devices) {
            device.on();
        }
    }
}

class NightMode implements ControlStrategy {
    public void execute(List<Devices> devices) {
        for (Devices device : devices) {
            device.off();
        }
        System.out.println("Night mode activated: All devices are turned off.");
    }
}

class VacationMode implements ControlStrategy {
    public void execute(List<Devices> devices) {
        for (Devices device : devices) {
            if (device instanceof Locks || device instanceof Alarms) {
                device.on();
            } else {
                device.off();
            }
        }
        System.out.println("Vacation mode activated: Security devices are on, others are off.");
    }
}

class AutomationController {
    private ControlStrategy strategy;

    public void setStrategy(ControlStrategy strategy) {
        this.strategy = strategy;
    }

    public void applyStrategy(List<Devices> devices) {
        if (strategy != null) {
            strategy.execute(devices);
        } else {
            System.out.println("No automation strategy set.");
        }
    }
}
