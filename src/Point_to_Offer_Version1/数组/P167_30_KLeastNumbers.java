package Point_to_Offer_Version1.数组;

public class P167_30_KLeastNumbers
{
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0)
            return new int[0];
        if (k == arr.length)
            return arr;
        int[] heap = new int[k];
        for (int i = 0; i < k; i++)
        {
            heap[i] = arr[i];
        }
        // 构建堆
        buildHeap(heap);

        for (int i = k; i < arr.length; i++)
        {
            if (arr[i] < heap[0]){
                heap[0] = arr[i];
                // 每次替换值后，维护堆：保持堆顶的最大或最小
                heapify(heap, 0);
            }
        }
        return heap;
    }

    // 每次替换值后，维护堆：保持堆顶的最大或最小
    private void heapify(int[] heap, int i)
    {
        if (i >= heap.length)
            return;
        int left = 2 * i + 1, right = 2 * i + 2;
        int max = i;
        if (left < heap.length && heap[left] > heap[max])
            max = left;
        if (right < heap.length && heap[right] > heap[max])
            max = right;
        if (max != i){
            heap[max] = heap[max] + heap[i] - (heap[i] = heap[max]);
            // 每次交换值后，维护堆：保持堆顶的最大或最小
            heapify(heap, max);
        }
    }

    // 构建堆
    private void buildHeap(int[] heap)
    {
        int lastNode = heap.length - 1;
        int startHeapify = (lastNode - 1) / 2;
        while (startHeapify >= 0){
            heapify(heap, startHeapify--);
        }
    }

    public static void main(String[] args){
        P167_30_KLeastNumbers kLeastNumbers = new P167_30_KLeastNumbers();
        int k = 1;
        int[] res = kLeastNumbers.getLeastNumbers(new int[]{0,3,2,1}, k);
        for (int num:res)
        {
            System.out.println(num);
        }
    }

}
