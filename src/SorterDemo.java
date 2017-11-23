// Приложение, демонстрирующее работу методов сортировки
public class SorterDemo {

    // Точка входа в приложение
    public static void main(String[] args) {
        // Массив, который надо отсортировать
        int[] intArray = {9, 9, -1, 8, 9, 5, 1, 11, 0};
        conPrn("Выберите алгоритм сортировки:");
        conPrn("1 - Пузырьковый метод");
        conPrn("2 - Метод перемешивания");
        conPrn("3 - Быстрая сортировка");
        char sortMethod = '0';
        try {
            sortMethod = (char) System.in.read();
        } catch (Exception e) {
            System.out.println("Ошибка ввода:" + e.getMessage());
        }
        conPrn("Не отсортировано:");
        showArray(intArray);
        switch (sortMethod) {
            case '1':
                Sorter.bubbleSort(intArray);
                break;
            case '2':
                Sorter.shakeSort(intArray);
                break;
            case '3':
                Sorter.fastSort(intArray);
                break;
            default:
                System.out.println("Неверный выбор, сортировка не произведена.");
                return;
        }
        conPrn("Отсортировано:");
        showArray(intArray);
    }

    // Вывод сообщения на консоль
    private static  void conPrn(String strLine) {
        System.out.println(strLine);
    }

    // Печать массива
    private static void showArray(int[] array) {
        for (int anArray : array) System.out.print(anArray + " ");
        conPrn("");
    }

}
