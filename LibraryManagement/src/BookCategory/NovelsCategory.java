package BookCategory;

public class NovelsCategory extends BookCategory{

    public static volatile NovelsCategory novelsCategory;

    public static NovelsCategory getNovelsCategoryInstance(int id, String name) {
        if(novelsCategory == null) {
            synchronized (NovelsCategory.class) {
                if(novelsCategory == null) {
                    novelsCategory = new NovelsCategory(id, name);
                }
            }
        }

        return novelsCategory;
    }

    private NovelsCategory(int id, String name) {
        super(id, name);
    }
}
