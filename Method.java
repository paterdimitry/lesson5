public class Method {

    public int[] changeArray(int[] array) {
        int count = 1;
        if (array[array.length - 1] == 4)
            return new int[]{};
        while (array[array.length - count] != 4 && array.length >= count) {
            count++;
            if (count > array.length) {
                throw new RuntimeException();
            }
        }
        int[] newArray = new int[count - 1];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[array.length - count + i + 1];
        }
        return newArray;
    }

    public boolean checkArray(int[] array) {
        boolean flag1 = false;
        boolean flag4 = false;
        boolean flagElse = true;
        for (int i : array) {
            if (i == 1)
                flag1 = true;
            if (i == 4)
                flag4 = true;
            if (i != 1 && i != 4)
                flagElse = false;
        }
        return flag1 && flag4 && flagElse;
    }
}
