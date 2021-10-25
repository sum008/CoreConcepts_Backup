package xx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TT {

    public static void main(String[] args) {

        int[] x = {3, 2, 4, 4};
        int[] y = new TT().twoSum(x, 6);
        System.out.println(y[0] + " " + y[1]);

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//		for (int i:list) {
//			System.out.println(i);
////			if (i==3) {
////				list.remove(i);
////			}
//		}
//		ListIterator<Integer> iterator=list.listIterator();
//		while(iterator.hasNext()) {
//			System.out.println("prev index "+iterator.previousIndex());
//			System.out.println("next index "+iterator.nextIndex());
//			int x=iterator.next();
//			System.out.println(x);
//			if (iterator.nextIndex()==1) {
//				iterator.add(10);
//			}
//		}

//		for (ListIterator<Integer> itr=list.listIterator();itr.hasNext();) {
//			System.out.println(itr.next()+" ff");
//			if (itr.nextIndex()==1) {
//				itr.add(10);
//				System.out.println(itr.next()+" next");
//				System.out.println("next index "+itr.nextIndex());
//				itr.remove();
//			}
//		}
//		ListIterator<Integer> iterator=list.listIterator();
//		while(iterator.hasNext()) {
//			int i=iterator.next();
//			System.out.println(i);
//		}

//		A a  = new A();
//		a.x();
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(map.put(nums[i], i));
        }
        System.out.println(map);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Object val = map.get(target - nums[i]);

            if (val != null && !((target - nums[i]) == nums[i] && i == (int) val)) {
                result[0] = i;
                result[1] = (int) val;
                return result;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //[-1,0,1,2,-1,-4]->[-4,-1,-1,0,1,2]


        return null;
    }

}
