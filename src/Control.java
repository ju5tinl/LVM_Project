import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class Control {

    private String name;
    private int size;
    private String uuid;

    public Control() {}

    public Control(String n, String u) {
        this.name = n;
        this.uuid = u;
        uuid = UUID.randomUUID() + "";
    }

    public Control(String n, int s, String u) {
        this.name = n;
        this.size = s;
        this.uuid = u;
        uuid = UUID.randomUUID() + "";
    }

    public Control(String n, int s) {
        this.name = n;
        this.size = s;
    }

    ArrayList<HD> hdArrayList = new ArrayList();
    ArrayList<PV> pvArrayList = new ArrayList();
    ArrayList<VG> vgArrayList = new ArrayList();
    ArrayList<LV> lvArrayList = new ArrayList();

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getUuid() {
        return uuid;
    }

    public void start(String v) {
        String out = "";
        while (!(v.equals("9"))) {
            Scanner input = new Scanner(System.in);
            if (v.equals("1")) {
                System.out.println("What is the name of your Hard Drive: ");
                String n = input.next();
                System.out.println("Input the size of your Hard Drive in GB: ");
                int s = input.nextInt();
                HD tempHD = new HD (n,s);
                hdArrayList.add(tempHD);
                System.out.println("Hard Drive installed!");
            }
            if (v.equals("2")) {
                {
                    for (HD t : hdArrayList) {
                        System.out.println(t.getName() + "[" + t.getSize() + " GB]");
                    }
                }
            }
            if (v.equals("3")) {
                HD h = null;
                System.out.println("What is the name of your Physical Volume: ");
                String n = input.next();
                String u = UUID.randomUUID() + "";
                PV temp = new PV(n, u, h);
                System.out.println("Enter the name of the Hard Drive you would like to set to the Physical Volume: ");
                for (HD t : hdArrayList) {
                    System.out.print(t.getName() + ", ");
                }
                System.out.println();
                String e = input.next();
                boolean output = temp.hdCheck(e);
                while (output == false) {
                    System.out.println("Please enter the right name of the Hard Drive: ");
                    e = input.next();
                    output = temp.hdCheck(e);
                }
                temp.setDrive(e);
                pvArrayList.add(temp);
                System.out.println("Physical Volume installed!");
            }
            if (v.equals("4")) {
                for (VG t : vgArrayList) {
                    System.out.println(t.getP().getName() + ": " + "[" + t.getP().getDrive().getSize() + " GB] " + "[" + t.getName() + "] " + "[" + t.getUuid() + "]");
                }
            }
            if (v.equals("5")) {
                System.out.println("To add a new Volume Group, enter V. \nTo add a new Physical Drive to the Volume Group, enter P: ");
                String choice = input.next();
                if (choice.equals("V")) {
                    PV p = null;
                    System.out.println("Input the size of your Volume Group in GB: ");
                    int s = input.nextInt();
                    System.out.println("What is the name of your Volume Group: ");
                    String n = input.next();
                    String u = UUID.randomUUID() + "";
                    System.out.println("Input the number of Physical Volumes you would like to be installed on your Volume Group: ");
                    int r = input.nextInt();
                    System.out.println("Below is a list of installed Physical Volumes: ");
                    for (PV t : pvArrayList) {
                        System.out.print(t.getName() + ", ");
                    }
                    System.out.println();
                    VG temp = new VG(n, s, u, p);
                    for (int i = 1; i < r + 1; i++) {
                        System.out.println("Please enter the name of Physical Drive " + i + ": ");
                        String e = input.next();
                        boolean output = temp.vgCheck(e);
                        while (output == false) {
                            System.out.println("Please enter the right name of the Physical Drive: ");
                            e = input.next();
                            output = temp.vgCheck(e);
                        }
                        temp.add(e);
                    }
                    vgArrayList.add(temp);
                }
                if (choice.equals("P")) {
                    VG tempVG = null;
                    System.out.println("Enter the name of the Volume Group you would like to add to. Below is a list of installed Volume Groups");
                    for (VG t : vgArrayList) {
                        System.out.print(t.getName() + ", ");
                    }
                    String e = input.next();
                    for (VG t : vgArrayList) {
                        if (t.getName().equals(e)) {
                            tempVG = t;
                        }
                    }
                    System.out.println("Input the number of Physical Volumes you would like to be installed on your Volume Group: ");
                    int r = input.nextInt();
                    System.out.println("Enter the names of the Physical Volumes you would like to set to the Volume Group. Below is a list of installed Physical Volumes: ");
                    for (PV val : pvArrayList) {
                        System.out.print(val.getName() + ", ");
                    }
                    for (int i = 1; i < r + 1; i++) {
                        System.out.println("Please enter the name of Physical Drive " + i + ": ");
                        boolean output = tempVG.vgCheck(e);
                        while (output == false) {
                            System.out.println("Please enter the right name of the Physical Drive: ");
                            e = input.next();
                            output = tempVG.vgCheck(e);
                        }
                        tempVG.add(e);
                    }
                }
            }

            if (v.equals("6")) {
                for (VG t : vgArrayList) {
                    System.out.println(t.getName() + ": " + "[ " + t.getSize() + " ]" + " [ " + t.getStorage() + " ]" + " [" + t.getPvStore() + " ]" + "[ " + t.getUuid() + " ]");
                }
            }
            if (v.equals("7")) {
                int vgStorage = 0;
                VG vg = null;
                int s = 0;
                System.out.println("Input the name of your Logical Volume: ");
                String n = input.next();
                String u = UUID.randomUUID() + "";
                LV tempLv = new LV(n, s, u, vg);
                System.out.println("Enter the name of the Volume Group you would like to set to the Logical Volume. Below is a list of installed Volume Groups: ");
                for (VG val : vgArrayList) {
                    System.out.print(val.getName() + ", ");
                }
                String e = input.next();
                boolean output = tempLv.vgCheck(e);
                while (output == false) {
                    System.out.println("Please re-enter the name of the Hard Drive: ");
                    e = input.next();
                    output = tempLv.vgCheck(e);
                }
                tempLv.setVol(e);
                System.out.println("Enter the size of the Logical Volume. Note: The Volume Group installed to the Logical Group only has " + tempLv.getVol().getStorage() + " GB left.");
                int f = input.nextInt();
                while (f > tempLv.getVol().getStorage()) {
                    System.out.println("Error Please input a smaller number:");
                    f = input.nextInt();
                }
                s = f;
                lvArrayList.add(tempLv);
            }
            if (v.equals("8")) {
                for (LV t : lvArrayList) {
                    System.out.println(t.getName() + ": [ " + t.getSize() + " ] " + " [ " + t.getVol() + " ]" + "[ " + t.getUuid() + " ]");
                }
            }
            if (v.equals("9")) {
                break;
            }
            break;
        }
    }
}