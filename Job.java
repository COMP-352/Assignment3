package A3;
import java.util.*;
public class Job {
    private int [] Heap;
    String jobName; //  name of job
    int jobLength; //   needed CPU cycles for this job to terminate
    int currentLength; //   remaining length of the job at any given time
    int jobPriority; // indicates initial priority of this job
    int finalPriority; //   final priority of the job at termination time
    long entryTime; //  time the job entered the priorityQueue
    long endTime; //    when the job finally terminated;
    long waitTime; //   total amount of wait time a process had to wait from entering the queue until it terminates
    int size;
    int maxSize;
    int currentPriority;

    public Job(String jobName, int jobLength, int currentLength, int jobPriority, int finalPriority, long entryTime, long endTime, long waitTime) { // Job object
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.currentLength = currentLength;
        this.jobPriority = jobPriority;
        this.finalPriority = finalPriority;
        this.entryTime = entryTime;
        this.endTime = endTime;
        this.waitTime = waitTime;
        Heap = new int[this.jobPriority +1];
        Heap[0] = Integer.MIN_VALUE;
    }


    //job with the highest job priority gets output at hte top of the tree

    private int parent(int position){   // node for the parent position
        return position / 2;
    }

    public static void insert(int Arr[], int n){
        int temp, i = n;
        temp = Arr[n];
        while (i > 1 && temp > Arr[i/2]){
            Arr[i] = Arr[i/2];
            i = i/2;
        }
        Arr[i] = temp;
    }

    public void swap(int first, int second){
        int temp;
        temp = Heap[first];
        Heap [first] = Heap [second];
        Heap [second] = temp;
    }

    public void insert(int n){  /// inputs jobPriority
        if(size>= maxSize){ //  If the n we input is greater than parent, just return
            return;
        }

        Heap[size]= n;
        int currentPriority = size;

        while (Heap [currentPriority] < Heap[parent(currentPriority)]){
            swap(currentPriority, parent(currentPriority));
            currentPriority = parent(currentPriority);
        }

    }
    public static void createHeap(int Arr[], int n){
       int i;
       for (i = 2; i < n; i++){
           insert(Arr, i);

       }
        System.out.println("Heap created.");
    }
    public static void outputHeap(){
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 40, 30, 5, 48};

        createHeap(arr, 2);

    }
}
