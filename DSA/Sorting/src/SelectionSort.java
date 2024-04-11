public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] arr = {1, 23, 5, 6, 78, 3};
        //System.out.println(arr.length);
        sorting(arr.length, arr);
        printArr(arr);
    }

    public static void sorting(int n, int[] arr)
    {

        for(int i = 0; i < n - 1; i++)
        {
            int min = i;
            for(int j = i + 1; j < n; j++)
            {
                if(arr[j] < arr[min])
                    min = j;

            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArr(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

}


