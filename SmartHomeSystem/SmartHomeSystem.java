import java.util.Arrays;
import java.util.List;

public class SmartHomeSystem {
    public static void main(String[] args) {
        // Observer Pattern
        UI ui = new UI();
        Log log1 = new Log("Log 1");
        Log log2 = new Log("Log 2");
        ui.addComponent(log1);
        ui.addComponent(log2);

        // Factory Pattern (renamed to DeviceChoice)
        Devices light = DeviceChoice.getDevice("LIGHTING");
        Devices alarm = DeviceChoice.getDevice("ALARMS");
        Devices camera = DeviceChoice.getDevice("CAMERAS");
        Devices lock = DeviceChoice.getDevice("LOCKS");

        List<Devices> allDevices = Arrays.asList(light, alarm, camera, lock);

        // Observer update
        ui.setNewChanges("Living Room Light turned ON");

        // Strategy Pattern
        AutomationController controller = new AutomationController();

        controller.setStrategy(new NightMode());
        controller.applyStrategy(allDevices);

        controller.setStrategy(new VacationMode());
        controller.applyStrategy(allDevices);

        controller.setStrategy(new ManualControl());
        controller.applyStrategy(allDevices);

        // Singleton (optional)
        SmartHomeController shc = SmartHomeController.getInstance();
        shc.controlDevice(light, false);
    }
}

class SmartHomeController {
    private static SmartHomeController instance;

    private SmartHomeController() {
    }

    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void controlDevice(Devices device, boolean turnOn) {
        if (turnOn)
            device.on();
        else
            device.off();
    }
}
