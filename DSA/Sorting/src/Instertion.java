public class Instertion
{
    public static void main(String[] args)
    {

        int arr[] = {2, 4, 5, 1, 23, 22, 12};
        sorting(arr, arr.length);
        printArr(arr);
    }

    public static void sorting(int[] arr, int n)
    {
        for(int i = 0; i < arr.length; i++)
        {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j])
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;

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

