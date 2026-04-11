import java.util.Scanner;

public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init() { head = null; }
    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    //a. Mencari node dengan nilai tertentu
    Node find(Object data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    //b. Mencari node di posisi ke-n
    Node get(int index) {
        if (index < 0 || index >= size) return null;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //c. Menghapus node di posisi ke-n
    void removeAt(int index) {
        Node target = get(index);
        if (target == null) return;

        if (target == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (target == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    //d. Menghapus node dengan nilai tertentu
    void remove(Object data) {
        Node target = find(data);
        if (target == null) return;

        if (target == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (target == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    //e.  Menambah node di posisi (index) ke-n.
    void addAt(int index, Node data) {
        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size) {
            addLast(data);
            return;
        }

        Node current = get(index);
        if (current == null) return;

        data.prev = current.prev;
        data.next = current;
        current.prev.next = data;
        current.prev = data;
        size++;
    }

    //f. Menambah node setelah node dengan nilai data tertentu.
    void addAfter(Object key, Node data) {
        Node current = find(key);
        if (current == null) return;

        if (current == tail) {
            addLast(data);
        } else {
            data.next = current.next;
            data.prev = current;
            current.next.prev = data;
            current.next = data;
            size++;
        }
    }

    //g. Menambah node sebelum node yang memiliki nilai data tertentu
    void addBefore(Object key, Node data) {
        Node current = find(key);
        if (current == null) return;

        if (current == head) {
            addFirst(data);
        } else {
            data.prev = current.prev;
            data.next = current;
            current.prev.next = data;
            current.prev = data;
            size++;
        }
    }
    
    // public static void main(String[] args) {
        // DoubleLinkedList list = new DoubleLinkedList();

        // Node nodeA = new Node("A");
        // Node nodeB = new Node("B");
        // Node nodeC = new Node("C");

        // list.addLast (nodeA);
        // System.out.println("head : " + list.head.data);
        // System.out.println("tail : " + list.tail.data);

        // list.addLast (nodeB);
        // System.out.println("head : " + list.head.data);
        // System.out.println("tail : " + list.tail.data);

        // list.addLast(nodeC);
        // System.out.println("head : " + list.head.data);
        // System.out.println("tail : " + list.tail.data);

        // // list.print();
    //     // System.out.println("Next of B: " + nodeB.next.data);
    //     // System.out.println("Prev of B: " + nodeB.prev.data);

    //     System.out.println("Urutan Reverse: ");
    //     list.printReverse();
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();

        // Data awal
        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));

        int pilih;
        do {
            System.out.println("\n=== DATA SAAT INI ===");
            list.print();

            System.out.println("\n=== MENU ===");
            System.out.println("1. Cari data");
            System.out.println("2. Cari berdasarkan index");
            System.out.println("3. Hapus di index");
            System.out.println("4. Hapus berdasarkan data");
            System.out.println("5. Tambah di index");
            System.out.println("6. Tambah setelah data tertentu");
            System.out.println("7. Tambah sebelum data tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                case 1:
                    System.out.print("Masukkan data: ");
                    String cari = sc.nextLine();
                    Node hasil = list.find(cari);
                    if (hasil != null)
                        System.out.println("Data ditemukan");
                    else
                        System.out.println("Data tidak ditemukan");
                    break;

                case 2:
                    System.out.print("Masukkan index: ");
                    int idx = sc.nextInt();
                    Node node = list.get(idx);
                    if (node != null)
                        System.out.println("Data: " + node.data);
                    else
                        System.out.println("Index tidak ditemukan");
                    break;

                case 3:
                    System.out.print("Masukkan index: ");
                    int idxHapus = sc.nextInt();
                    list.removeAt(idxHapus);
                    break;

                case 4:
                    System.out.print("Masukkan data: ");
                    String hapus = sc.nextLine();
                    list.remove(hapus);
                    break;

                case 5:
                    System.out.print("Masukkan index: ");
                    int idxTambah = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukkan data: ");
                    String dataBaru = sc.nextLine();
                    list.addAt(idxTambah, new Node(dataBaru));
                    break;

                case 6:
                    System.out.print("Setelah data: ");
                    String keyAfter = sc.nextLine();
                    System.out.print("Data baru: ");
                    String dataAfter = sc.nextLine();
                    list.addAfter(keyAfter, new Node(dataAfter));
                    break;

                case 7:
                    System.out.print("Sebelum data: ");
                    String keyBefore = sc.nextLine();
                    System.out.print("Data baru: ");
                    String dataBefore = sc.nextLine();
                    list.addBefore(keyBefore, new Node(dataBefore));
                    break;
            }

        } while (pilih != 0);

        sc.close();
    }
}
