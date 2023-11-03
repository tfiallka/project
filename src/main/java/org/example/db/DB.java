package org.example.db;

import org.example.models.Event;
import java.util.List;

public interface DB<T extends Event> {
    List<T> getAll();
    void add(T event);
    T getById( int id);
    void delete(int id);
}
