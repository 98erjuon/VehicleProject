package Vehicles;

public interface Loadable<T> {
    void load(T obj);
    T drop();
    void showLoadedObjects();

}


