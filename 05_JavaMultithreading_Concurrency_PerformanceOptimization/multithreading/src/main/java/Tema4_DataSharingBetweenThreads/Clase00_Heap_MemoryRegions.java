package Tema4_DataSharingBetweenThreads;

public class Clase00_Heap_MemoryRegions {

    /*
    Heap: is a memory region that belongs to the process where all the threads share that data located in the heap.

    What is allocated on the Heap?
        - Objects (anything created with the new operator): String, Object, Collection, ..
        - Members of classes
        - Static variables

    Heap Memory Management:
        - Governed and managed by Garbage Collector
        - Objects - stay as long as we have reference to them
        - Members of classes - exist as long as their parent object exist (samy life cycle as their parents)
        . Static variables - stay forever

    What is allocated where?
        - References:
            - Can be allocated on the stack
            - Can be allocated on the heap´if they are members of a class
        - Objects:
            - Always allocated on the heap
    */
}
