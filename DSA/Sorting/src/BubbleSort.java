

public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] arr = {23, 4, 5, 7, 2, 1};
        sorting(arr, arr.length);
        printArr(arr);
    }

    public static void sorting(int[] arr, int n)
    {
        int temp;
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
