package org.example.db;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.db.typeadapters.LocalDateTypeAdapter;
import org.example.db.typeadapters.LocalTimeTypeAdapter;
import org.example.models.Event;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DBImpl<T extends Event> implements DB<T> {
    private final String DB_PATH = "Events.txt";
    private List<T> events = new ArrayList<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter())
            .create();

    @Override
    public T getById(int id) {
        return events.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<T> getAll() {
        return getDataFromFile();
    }

    @Override
    public void add(T event) {
        if (getDataFromFile() != null) {
            events = getDataFromFile();
        }
        events.add(event);
        writeDataToFile(events);
    }

    @Override
    public void delete(int id) {
        events = getDataFromFile();
        T eventDel = getById(id);
        if (eventDel == null) {
            System.out.println("Неверный Id");
        } else {
            events.remove(eventDel);
            writeDataToFile(events);
            System.out.println("Запись удалена");
        }
    }

    private void writeDataToFile(List<T> events) {
        String jsonEvents = gson.toJson(events);
        try {
            FileWriter writer = new FileWriter(DB_PATH);
            writer.write(jsonEvents);
            writer.close();
        } catch (IOException e) {
            System.out.println("Нет событий");
        }
    }

    private List<T> getDataFromFile() {
        String dbDataJson = null;
        try {
            dbDataJson = Files.readString(Paths.get(DB_PATH));
        } catch (IOException e) {
            System.out.println("Нет событий");
        }
        return gson.fromJson(dbDataJson, new TypeToken<List<T>>() {
        }.getType());
    }
}
