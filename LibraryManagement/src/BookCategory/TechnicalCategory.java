package BookCategory;

public class TechnicalCategory extends BookCategory{

    public static volatile TechnicalCategory technicalCategory;

    public static TechnicalCategory getTechnicalCategoryInstance(int id, String name) {
        if(technicalCategory == null) {
            synchronized (TechnicalCategory.class) {
                if(technicalCategory == null) {
                    technicalCategory = new TechnicalCategory(id, name);
                }
            }
        }

        return technicalCategory;
    }

    private TechnicalCategory(int id, String name) {
        super(id, name);
    }
}
