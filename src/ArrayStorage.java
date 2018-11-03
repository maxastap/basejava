/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        for (int i = 0; i <= storage.length - 1; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    void save(Resume r) {

        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i <= count - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {

        for (int i = 0; i <= count - 1; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = storage[count - 1];
                storage[count - 1] = null;
                count--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume allList[] = new Resume[count];
        for (int i = 0; i <= count - 1; i++) {
            allList[i] = storage[i];
        }
        return allList;
    }

    int size() {
        return count;
    }
}
