package filippov.vitaliy.poibms3_8.Data.Events;

import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import filippov.vitaliy.poibms3_8.Base.Constants;
import filippov.vitaliy.poibms3_8.Base.File.WorkWithFile;
import filippov.vitaliy.poibms3_8.Base.File.WorkWithJSON;

public class Category {
    private static ArrayList<String> categoryNames;

    static {

        loadFromFile();
        if(categoryNames.size() == 0){
            categoryNames = new ArrayList<String>();
            categoryNames.add("Wash");
            categoryNames.add("Service");
            categoryNames.add("Things");
            categoryNames.add("Other");
            synchronizedEventsWithFile();
        }
    }

    public static ArrayList<String> getCategoryNames() {
        return categoryNames;
    }

    public static int getPosItem(String item){
        for(int i = 0; i< categoryNames.size();i++){
            if(categoryNames.get(i).equals(item))
                return i;
        }
        return 0;
    }

    public static void setCategoryNames(ArrayList<String> categoryNames) {
        Category.categoryNames.addAll(categoryNames);
    }

    public static boolean addCategoryNames(String categoryName) {
        if (categoryNames.contains(categoryName)) {
            return true;
        } else {
            categoryNames.add(categoryName);
        }

        task.run();
        return true;
    }

    private static Runnable task = new Runnable() {
        @Override
        public void run() {
            synchronizedEventsWithFile();
        }
    };


    private static void synchronizedEventsWithFile() {
        WorkWithFile wfC = new WorkWithFile(Constants.Category_JSON);
        wfC.createFile(true);
        WorkWithJSON<String> workWithFileJSONS = new WorkWithJSON<String>(wfC);
        for (String s : categoryNames) {
            workWithFileJSONS.saveAsJson(s);
        }
    }

    public static void clear() {
        categoryNames.clear();
        task.run();
    }

    private static void loadFromFile() {
        WorkWithFile wfC = new WorkWithFile(Constants.Category_JSON);
        wfC.createFile(false);
        WorkWithJSON<String> workWithFileJSONS = new WorkWithJSON<String>(wfC);
        categoryNames = workWithFileJSONS.deserialize(new TypeToken<String>() {
        }.getType());
        Log.d("MyEvent", "loadFromFile");
    }

    public static boolean removeCategory(String category) {
        if (categoryNames.contains(category)) {
            categoryNames.remove(category);
            task.run();
            Log.d("MyEvent", "Remove category");
            return true;
        }
        return false;
    }

    public int getCountCategory() {
        return categoryNames.size();
    }
}
