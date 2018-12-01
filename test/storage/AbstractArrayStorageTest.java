package storage;

import exeption.NotExistStorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {

    private Storage storage = new ArrayStorage();

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }


    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist(){
        storage.update(new Resume(UUID_4));
    }

    @Test
    public void getAll() {

        Storage str = new ArrayStorage();
        str.clear();
        str.save(new Resume(UUID_1));
        str.save(new Resume(UUID_2));
        str.save(new Resume(UUID_3));

        Assert.assertArrayEquals(str.getAll(), storage.getAll());
    }

    @Test
    public void save() {

        storage.save(new Resume(UUID_4));
        Assert.assertEquals(new Resume(UUID_4), storage.get(UUID_4));
        Assert.assertEquals(4,storage.size());
    }

    @Test
    public void delete() {
        storage.delete(UUID_2);
        Assert.assertEquals(2,storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist(){
        storage.delete("test");
    }

    @Test
    public void get() {
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}