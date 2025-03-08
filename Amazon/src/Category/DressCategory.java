package Category;

public class DressCategory extends  Category{

    public static volatile DressCategory dressCategory;

    public static DressCategory getDressCategoryInstance(int categoryId, String categoryName) {
        if(dressCategory == null) {
            synchronized (DressCategory.class) {
                if(dressCategory == null) {
                    dressCategory = new DressCategory(categoryId, categoryName);
                }
            }
        }

        return  dressCategory;
    }

    private DressCategory(int categoryId, String categoryName) {
        super(categoryId, categoryName);
    }
}
