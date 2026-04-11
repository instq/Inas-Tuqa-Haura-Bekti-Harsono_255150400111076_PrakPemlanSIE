import java.util.Scanner;

public class SingleLinkedList {
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
            tail = data;
        }
        size++;
    }

    //Mencari node dengan nilai tertentu, jika tidak ditemukan, maka kembalikan nilai null.
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

    // Mencari node di posisi ke-n, jika tidak ditemukan, maka kembalikan nilai null.
    Node get(int index) {
        if (index < 0 || index >= size) return null;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Menghapus node di posisi (index) ke-n, jika ada/ditemukan.
    void removeAt(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node prev = get(index - 1);
            prev.next = prev.next.next;
            if (index == size - 1) tail = prev;
        }
        size--;
    }

    // Menghapus node dengan nilai data tertentu jika ada/ditemukan.
    void remove(Object data) {
        if (isEmpty()) return;

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
                return;
            }
            current = current.next;
        }
    }

    // Menambah node di posisi (index) ke-n.
    void addAt(int index, Node data) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node prev = get(index - 1);
            data.next = prev.next;
            prev.next = data;
            size++;
        }
    }

    // Menambah node setelah node dengan nilai data tertentu.
    void addAfter(Object key, Node data) {
        Node current = find(key);
        if (current != null) {
            data.next = current.next;
            current.next = data;
            if (current == tail) tail = data;
            size++;
        }
    }

    // Menambah node sebelum node dengan nilai data tertentu.
    void addBefore(Object key, Node data) {
        if (head == null) return;

        if (head.data.equals(key)) {
            addFirst(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(key)) {
                data.next = current.next;
                current.next = data;
                size++;
                return;
            }
            current = current.next;
        }
    }

    //Bisa digunakan untuk bantu print
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // public static void main(String[] args) {
    //     SingleLinkedList list = new SingleLinkedList();

    //     System.out.println("Head: " + list.head);
    //     System.out.println("Tail: " + list.tail);

    //     list.addFirst(new Node("A"));
    //     System.out.println("Head: " + list.head.data);
    //     System.out.println("Tail: " + list.tail.data);

    //     list.addFirst(new Node("B"));
    //     System.out.println("Head: " + list.head.data);
    //     System.out.println("Tail: " + list.tail.data);

    //     list.addLast(new Node("C"));
    //     System.out.println("Head: " + list.head.data);
    //     System.out.println("Tail: " + list.tail.data);
    // }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Scanner input = new Scanner(System.in);


        list.addLast(new Node("A"));
        list.addLast(new Node("B"));
        list.addLast(new Node("C"));

        System.out.print("Data awal: ");
        list.printList();

        // a. Mencari node dengan nilai tertentu, jika tidak ditemukan, maka kembalikan nilai null.
        System.out.print("Masukkan data yang dicari: ");
        String cari = input.nextLine();

        Node hasil = list.find(cari);

        if (hasil != null) {
            System.out.println("Data ditemukan: " + hasil.data);
        } else {
            System.out.println("Data tidak ditemukan");
        }

        // b. Mencari node di posisi ke-n, jika tidak ditemukan, maka kembalikan nilai null.
        System.out.print("Masukkan index yang dicari: ");
        int index = input.nextInt();

        Node temukan = list.get(index);

        if (temukan != null) {
            System.out.println("Data pada index ke-" + index + ": " + hasil.data + 1);
        } else {
            System.out.println("Data tidak ditemukan (null)");
        }

        // c. hapus berdasarkan index
        System.out.print("Masukkan index yang ingin dihapus: ");
        int indexHapus = input.nextInt();
        list.removeAt(indexHapus);
        list.printList();

        input.nextLine(); 

        // d. hapus berdasarkan nilai
        System.out.print("Masukkan data yang ingin dihapus: ");
        String dataHapus = input.nextLine();
        list.remove(dataHapus);
        list.printList();

        // e. tambah di index
        System.out.print("Masukkan index untuk tambah data: ");
        int indexTambah = input.nextInt();
        input.nextLine();

        System.out.print("Masukkan data: ");
        String dataTambah = input.nextLine();
        list.addAt(indexTambah, new Node(dataTambah));
        list.printList();

        // f. tambah setelah nilai tertentu
        System.out.print("Tambah setelah data apa: ");
        String keyAfter = input.nextLine();

        System.out.print("Data yang ditambahkan: ");
        String dataAfter = input.nextLine();
        list.addAfter(keyAfter, new Node(dataAfter));
        list.printList();

        // g. tambah sebelum nilai tertentu
        System.out.print("Tambah sebelum data apa: ");
        String keyBefore = input.nextLine();

        System.out.print("Data yang ditambahkan: ");
        String dataBefore = input.nextLine();
        list.addBefore(keyBefore, new Node(dataBefore));
        list.printList();
    }
}