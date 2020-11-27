public class Menu {
    private String search;
    private String file;
    private String category;



    public Menu(String asearch){
        search = asearch;
    }

    public void addFile(String fileLoc){
        file = fileLoc;

    }

    public void setSearch(String s){
        search = s;
    }

    public void MenuSelect(String cat){
        category = cat;
    }

}
