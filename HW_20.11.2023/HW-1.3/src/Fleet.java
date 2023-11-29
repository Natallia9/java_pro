public class Fleet {
    private String name;
    private String address;
    private String[] listOfManagers;

    public Fleet(String name, String address, String[] listOfManagers) {
        this.name = name;
        this.address = address;
        this.listOfManagers = listOfManagers;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setListOfManagers(String[] listOfManagers) {
        this.listOfManagers = listOfManagers;
    }

    public void addManager(String manager) {
        String[] managers = new String[listOfManagers.length + 1];
        for (int i = 0; i < listOfManagers.length; i++) {
            managers[i] = listOfManagers[i];
        }
        managers[managers.length - 1] = manager;
        listOfManagers = managers;
        System.out.println("Новый сотрудник добавлен - " + manager);
    }
    public String search(String manager) {
        for (int i = 0; i < listOfManagers.length; i++) {
            if (listOfManagers[i].equals(manager)) {
                return manager;
            }
        }
        return null;
    }
}


