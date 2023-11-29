public class Library {
    private String name;
    private String address;
    private String[] listOfLibrarians;

    public Library(String name, String address, String[] listOfLibrarians) {
        this.name = name;
        this.address = address;
        this.listOfLibrarians = listOfLibrarians;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getListOfLibrarians() {
        return listOfLibrarians;
    }

    public void addLibrarian(String nameLibrarian) {
        String[] librarians = new String[listOfLibrarians.length + 1];
        for (int i = 0; i < listOfLibrarians.length; i++) {
            librarians[i] = listOfLibrarians[i];
        }
        librarians[librarians.length - 1] = nameLibrarian;
        listOfLibrarians = librarians;
        System.out.println("Новый сотрудник добавлен - " + nameLibrarian);
    }

    public String search(String name) {
        for (int i = 0; i < listOfLibrarians.length; i++) {
            if (listOfLibrarians[i].equals(name)) {
                return name;
            }
        }
        return null;
    }
}