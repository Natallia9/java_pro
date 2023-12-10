package Library;
import java.util.List;

public class Librarian implements Maintainable {
    String name;
    String employeeId;
    List<LibraryItem> managedItems;

    @Override
    public void repairItem() {
        // Implementation
    }

    @Override
    public void updateItemCondition(ItemCondition condition) {
        // Implementation
    }

    @Override
    public ItemCondition checkCondition() {
        // Implementation
        return null;
    }
}

