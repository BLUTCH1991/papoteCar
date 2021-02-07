package dao;

public interface DaoInterface<T> {

    public void create(T object);
    public void delete(int id);
    public void update(int id);
    public T get(int id);

}
