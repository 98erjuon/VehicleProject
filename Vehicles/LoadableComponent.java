package Vehicles;

import java.util.ArrayList;

public class LoadableComponent<T>  {
    private ArrayList<T> objects;
    private Integer capacity;

    public LoadableComponent() {
        this.objects = new ArrayList<>();
    }
    public LoadableComponent(int capacity) {
        this.objects = new ArrayList<>();
        this.capacity = capacity;
    }

    public void load(T obj) throws IndexOutOfBoundsException{
        if (this.capacity == null || this.capacity > objects.size()){
            objects.add(obj);
        }
        else {
            throw new IndexOutOfBoundsException("Note! Capacity = " + capacity);
        }
    }
    public T drop(boolean LAST) throws IndexOutOfBoundsException {
        if (LAST) {
            return objects.remove(objects.size() - 1);
        }
        else {
            return objects.remove(0);
        }
    }
    public T drop(T objectToDrop) throws IllegalArgumentException {
        int index = this.objects.indexOf(objectToDrop);
        if (index != -1) {
            return this.objects.remove(index);
        }
        else {
            throw new IllegalArgumentException(objectToDrop.toString() + " is not loaded!");
        }
    }


    /**
     * Uses the toString method to describe the objects stored. Override toString to get an
     * description that suits the specified object
     */
    public void showLoadedObjects() {
        for (T obj : objects) {
            System.out.println(obj.toString());
        }
    }

}
