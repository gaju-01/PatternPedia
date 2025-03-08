package Category;

public class ShoeCategory extends Category{

    public static volatile ShoeCategory shoeCategory;
    public static ShoeCategory getShoeCategoryInstance(int categoryId, String categoryName) {
        if(shoeCategory == null) {
            synchronized (ShoeCategory.class) {
                if(shoeCategory == null) {
                    shoeCategory = new ShoeCategory(categoryId, categoryName);
                }
            }
        }

        return shoeCategory;
    }
    private ShoeCategory(int categoryId, String categoryName) {
        super(categoryId, categoryName);
    }
}
