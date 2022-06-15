public class PV extends Control{

    private HD drive;
    public PV(String n, String u, HD h)
    {
        super(n, u);
        this.drive = h;
    }

    public void add(PV p)
    {
        pvArrayList.add(p);
    }

    public HD getDrive()
    {
        return drive;
    }

    public void setDrive(String e)
    {
        for (HD t : hdArrayList)
        {
            if (t.getName().equals(e))
            {
                drive = t;
            }
        }
    }

    public boolean hdCheck(String d)
    {
        boolean output = true;
        for(int i = 0; i < hdArrayList.size(); i++) {
            if (hdArrayList.get(i).getName().equals(d)) {
                for (int j = 0; j < pvArrayList.size(); j++) {
                    if (pvArrayList.get(j).getDrive().getName().equals(d)) {
                        output = false;
                        System.out.println("Error: Hard Drive already set to Physical Drive.");
                        break;
                    }
                }
            }
        }
        return output;
    }

}