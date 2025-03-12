package org.example.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.model.Human;
import org.example.model.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonManager {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Human.class, new HumanAdapter()) // Кастомний адаптер
            .setPrettyPrinting()
            .create();

    // Метод для конвертації об'єкта в JSON-рядок
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    // Метод для конвертації JSON-рядка в об'єкт
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    // Метод для збереження об'єкта у файл JSON
    public static void saveToJson(Object obj, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для завантаження об'єкта з JSON-файлу
    public static <T> T loadFromJson(String filePath, Class<T> classOfT) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, classOfT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Кастомний адаптер для Human
class HumanAdapter implements JsonSerializer<Human>, JsonDeserializer<Human> {
    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName()); // Додаємо тип
        return jsonObject;
    }

    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString(); // Отримуємо тип

        if ("Student".equals(type)) {
            return context.deserialize(jsonObject, Student.class);
        } else {
            throw new JsonParseException("Unknown type: " + type);
        }
    }
}