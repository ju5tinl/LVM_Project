import java.util.ArrayList;

public class VG extends Control{

    private PV p;
    private ArrayList<PV> pvStore = new ArrayList();
    private ArrayList<LV> lvStore = new ArrayList();

    public VG(String n, int s, String u, PV p)
    {
        super(n, s, u);
        this.p = p;
    }

    public void add(String v)
    {
        for (PV t : pvArrayList)
            if(t.getName().equals(v))
            {
                pvStore.add(t);
            }
    }

    public String getPvStore()
    {
        String output = "";
        for (PV t : pvStore)
        {
            output += t.getName() + ", ";
        }
        return output;
    }

    public String getLvStore()
    {
        String output = "";
        for (LV t : lvStore)
        {
            output += t.getName() + ", ";
        }
        return output;
    }

    public PV getP()
    {
        return p;
    }

    public boolean hasPV()
    {
        boolean output = true;
        if(this.getP() == null)
        {
            output = false;
        }
        return output;
    }

    public int getStorage()
    {
        int storage = 0;
        for (PV t : pvStore)
        {
            storage += t.getDrive().getSize();
        }
        int output = this.getSize() - storage;
        return output;
    }

    public void lvSet(PV p)
    {
        for(int i = 0; i < pvArrayList.size(); i++)
        {
            if (pvArrayList.get(i).getName() == p.getName())
            {
                break;
            }
        }
        for (int i = 0; i < vgArrayList.size(); i++)
        {
            if(pvArrayList.get(i).getDrive().equals(p.getName()))
            {
                break;
            }
        }
        pvStore.add(p);
        System.out.println(p.getName() + " is now attached to Volume Group: " + super.getName());
    }


    public boolean vgCheck(String l)
    {
        boolean output = true;
        for(int i = 0; i < lvArrayList.size(); i++) {
            if (lvArrayList.get(i).getName().equals(l)) {
                for (int j = 0; j < pvStore.size(); j++) {
                    if (pvStore.get(j).getName().equals(l)) {
                        output = false;
                        System.out.println("Error: Hard Drive already set to Physical Drive.");
                    }
                    if (this.getStorage() < lvArrayList.get(i).getSize())
                    {
                        output = false;
                        System.out.println("Error: Volume Group does not have enough storage.");
                    }
                }
            }
        }
        return output;
    }

}
