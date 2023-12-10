package Library;

    public interface Maintainable {
    void repairItem();
    void updateItemCondition(ItemCondition condition);
    ItemCondition checkCondition();
}
