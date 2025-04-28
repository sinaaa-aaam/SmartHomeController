import java.util.ArrayList;
import java.util.List;

public class UI {
    private String new_changes;
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void notifyLogs() {
        for (Component component : components) {
            component.update(new_changes);
        }
    }

    public void setNewChanges(String new_changes) {
        this.new_changes = new_changes;
        notifyLogs();
    }
}

interface Component {
    void update(String new_changes);
}

class Log implements Component {
    private String name;

    public Log(String name) {
        this.name = name;
    }

    public void update(String new_changes) {
        System.out.println(name + " - New device state change: " + new_changes);
    }
}
