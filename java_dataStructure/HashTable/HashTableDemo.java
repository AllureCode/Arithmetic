package java_dataStructure.HashTable;

import java.util.Scanner;

/**
 * 编写一个哈希表用来存储展示用户信息
 * 采用数组+链表
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTableArrayLinkedList hashTableArrayLinkedList = new HashTableArrayLinkedList(5);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add");
            System.out.println("find");
            System.out.println("list");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    Employ employ = new Employ(id, name);
                    hashTableArrayLinkedList.add(employ);
                    break;
                case "list":
                    hashTableArrayLinkedList.show();
                    break;
                case "find":
                    System.out.println("id");
                    id = scanner.nextInt();
                    hashTableArrayLinkedList.findEmp(id);
                    break;
            }
        }

    }
}


//定义hashTable
class HashTableArrayLinkedList {
    private int size;
    private EmployLinkedList[] employLinkedLists;

    public HashTableArrayLinkedList(int size) {
        this.size = size;
        employLinkedLists = new EmployLinkedList[size];
        //初始化其他数组链表
        for (int i = 0; i < size; i++) {
            employLinkedLists[i] = new EmployLinkedList();
        }
    }

    //定义一个hash算法 求得每个员工添加的链表位置
    public int NO(int no) {
        return no % size;
    }

    //添加员工
    public void add(Employ employ) {
        int addNO = NO(employ.id);
        employLinkedLists[addNO].add(employ);
    }

    //查询员工
    public void show() {
        for (int i = 0; i < size; i++) {
            employLinkedLists[i].list(i);
        }
    }
    //根据id查询员工
    public void findEmp(int id) {
        int LinkedNo = NO(id);
        Employ e = employLinkedLists[LinkedNo].findById(id);
        if (e == null) {
            System.out.println("没有此员工");
        } else {
            System.out.println("在第" + (LinkedNo + 1) + "条链表找到" + e.id + "：" + e.name);
        }
    }
}


//定义员工链表
class EmployLinkedList {
    private Employ head = null;

    //添加信息
    public void add(Employ employ) {
        if (head == null) {
            head = employ;
            return;
        }
        Employ temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = employ;
    }

    //根据id查询
    public Employ findById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employ tem = head;
        while (tem != null) {
            if (tem.id == id) {
                break;
            }
            tem = tem.next;
        }
        return tem;
    }

    //展示信息
    public void list(int id) {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        Employ currentE = head;
        System.out.println("第" + (id + 1) + "条链表信息");
        while (currentE != null) {
            System.out.println("用户:" + currentE.id + currentE.name);
            currentE = currentE.next;
        }
    }
}

//定义用户类
class Employ {
    public int id;
    public String name;
    public Employ next;

    public Employ(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

