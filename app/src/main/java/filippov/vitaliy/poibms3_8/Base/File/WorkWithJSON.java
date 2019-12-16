package filippov.vitaliy.poibms3_8.Base.File;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class WorkWithJSON<T>{

    private WorkWithFile wf;

    public WorkWithJSON(WorkWithFile workWithFile){
        this.wf = workWithFile;
    }

    public ArrayList<T> deserialize(Type type){
        Gson gson = new Gson();
        String str = "";
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(wf.file));
            while ((str = br.readLine()) != null) {
                text.append(str);
                text.append('\n');
            }
            Log.d("MyEvent",String.valueOf(text));
            String[] findStrings = String.valueOf(text).split("\n");
            ArrayList<T> findObj = new ArrayList<T>();
            String[] array = new String[2];
            for (String s: findStrings) {
                if(!s.isEmpty()){
                    findObj.add((T)gson.fromJson(String.valueOf(s), type));
                    Log.d("MyEvent","Вынули из файла: "+s);
                }

            }

            return findObj;

        } catch (FileNotFoundException e) {
            Log.d("MyEvent", "Ошибка чтения из файла..");
        } catch (IOException e) {
            Log.d("MyEvent", "Ошибка чтения из файла..");
        }
        return null;
    }

    public boolean saveAsJson(T obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        Log.d("MyEvent","Записали в файл: "+json);
        try{
            FileWriter fileWriter = new FileWriter(wf.file, true);
            fileWriter.append(json);
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            Log.d("MyEvent", "Ошибка записи в файл..");
        }
        return false;
    }
}