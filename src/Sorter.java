// Класс, реализующий методы сортировки
class Sorter {

    // Пузырьковый метод
    static void bubbleSort(int array[]) {
        for (int ignored : array) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                }
            }
        }
    }

    // Метод перемешивания
    static void shakeSort(int array[]) {
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swapElements(array, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swapElements(array, i, i - 1);
                }
            }
            left++;
        } while (left < right);
    }

    // Быстрая сортировка
    static void fastSort(int[] array) {
        if (array.length <=1)
            return;
        // Находим новое место базового элемента в массиве
        int idx  = baseIdxNew(array);
        // Разбиваем массив на два по позиции базового элемента
        int[] array1 = new int[idx];
        int[] array2 = new int[array.length - idx];
        arrayTransfer(array, array1, 0, idx - 1);
        arrayTransfer(array, array2, idx, array.length - 1);
        // Сортируем половинки (рекурсия)
        if(array1.length > 1)
            fastSort(array1);
        if(array2.length > 1)
            fastSort(array2);
        // Склеиваем остортированые половинки
        arrayGlue(array1, array2, array);
    }

    // Склеивание двух массивов в один
    private static void arrayGlue(int[] array1, int[] array2, int[] resultArray) {
        int idx = 0;
        for (int anArray1 : array1) {
            resultArray[idx] = anArray1;
            idx++;
        }
        for (int anArray2 : array2) {
            resultArray[idx] = anArray2;
            idx++;
        }
    }

    // Запись части массива в другой массив
    private static void arrayTransfer(int[] arrayFrom, int[] arrayTo, int startPos, int endPos) {
        int idx = 0;
        for (int i = startPos; i <= endPos; i++) {
            arrayTo[idx] = arrayFrom[i];
            idx++;
        }
    }

    // Возвращает индекс базового элемента после сдвига массива,
    // таким образом, чтобы справа оказались все элементы
    // больше базового
    private static int baseIdxNew(int[] array) {
        int baseIdx = array.length - 1;
        int checkIdx = 0;
        do {
            if (array[checkIdx] > array[baseIdx]) {
                elemToEnd(array, checkIdx);
                baseIdx--;
            } else {
                checkIdx ++;
            }

        } while (checkIdx < baseIdx);
        return baseIdx;
    }

    // Забрасывает элемент из позиции idx в конец массива
    private static void elemToEnd(int[] array, int idx) {
        int buf = array[idx];
        System.arraycopy(array, idx + 1, array, idx, array.length - idx - 1);
        array[array.length - 1] = buf;
    }

    // Обмен двух элементов массива
    private static void swapElements(int[] array, int idx1, int idx2) {
        int buf = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = buf;
    }

}
