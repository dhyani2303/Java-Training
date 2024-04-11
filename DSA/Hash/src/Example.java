import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Example
{
    public static void getMajority(int[] nums)
    {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet())
        {

            if(e.getValue() > (n / 3))
                System.out.println(e.getKey());
        }


    }

    public static int union(int[] arr1, int[] arr2)
    {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++)
        {
            set.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++)
        {
            set.add(arr2[i]);
        }

        return set.size();
    }

    public static int intersection(int[] arr1, int[] arr2)
    {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++)
        {
            set.add(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++)
        {
            if(set.contains(arr2[i]))
                count++;
            set.remove(arr2[i]);
        }
        return count;


    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 2, 5, 1, 3, 1, 5, 1};

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        getMajority(nums);


        System.out.println(union(arr1, arr2));
        System.out.println(intersection(arr1, arr2));


    }
}

