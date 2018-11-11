/**
 * Реализуйте и протестируйте ArrayStorage.update(Resume resume)
 * Сделайте проверки:
 * в update/delete/get - резюме есть в storage?
 * в save- резюме нет в storage?
 * сделайте в save проверку на переполнение
 * выведите соответствующие предупреждения для всех, указанных выше проверок - System.out.println("Resume ...")
 * Избавьтесь от дублирования в коде ArrayStorage
 * Посмотрите на методы класса java.util.Arrays.
 * Некоторые из них помогут упростить реализацию ваших методов clear() и getAll()
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    Integer check(String uuid) {

        for (int i = 0; i <= count - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }

        return null;
    }

    private void update(Resume resume) {

        if (check(resume.uuid) != null) {
            System.out.println("Update possible");
        }
        System.out.println("Error");
    }

    void clear() {
        for (int i = 0; i <= storage.length - 1; i++) {
            storage[i] = null;
        }
        count = 0;
    }

    void save(Resume r) {
        if (check(r.uuid) != null) {
            System.out.println("Error. Resume is on base");
        } else {
            if (count < storage.length) {
                storage[count] = r;
                count++;
            } else {
                System.out.println("Error. Base is full");
            }
        }
    }

    Resume get(String uuid) {

        Integer check = check(uuid);
        if (check != null) {
            return storage[check];
        }
        System.out.println("Error. Uuid didn't found");
        return null;

    }

    void delete(String uuid) {
        Integer r = check(uuid);
        if (r != null) {
            storage[r] = storage[count - 1];
            storage[count - 1] = null;
            count--;
        } else {
            System.out.println("Error. Unknown uuid");
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
