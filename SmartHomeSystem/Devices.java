interface Devices {
    void on();

    void off();
}

class Cameras implements Devices {
    public void on() {
        System.out.println("Cameras are on");
    }

    public void off() {
        System.out.println("Cameras are off");
    }
}

class Alarms implements Devices {
    public void on() {
        System.out.println("Alarms are on");
    }

    public void off() {
        System.out.println("Alarms are off");
    }
}

class Lighting implements Devices {
    public void on() {
        System.out.println("Lights are on");
    }

    public void off() {
        System.out.println("Lights are off");
    }
}

class Locks implements Devices {
    public void on() {
        System.out.println("Locks are on");
    }

    public void off() {
        System.out.println("Locks are off");
    }
}

class DeviceChoice {
    public static Devices getDevice(String type) {
        if (type.equalsIgnoreCase("CAMERAS"))
            return new Cameras();
        if (type.equalsIgnoreCase("ALARMS"))
            return new Alarms();
        if (type.equalsIgnoreCase("LIGHTING"))
            return new Lighting();
        if (type.equalsIgnoreCase("LOCKS"))
            return new Locks();
        return null;
    }
}
