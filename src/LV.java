public class LV extends Control{

    private VG vol;

    public LV(String n, int s, String u, VG v)
    {
        super(n, s, u);
        this.vol = v;
    }

    public void add(LV l)
    {
        lvArrayList.add(l);
    }

    public VG getVol()
    {
        return vol;
    }

    public void setVol(String val)
    {
        for (VG t : vgArrayList)
        {
            if (t.getName().equals(val))
            {
                vol = t;
            }
        }
    }

    public boolean vgCheck(String v)
    {
        boolean output = false;
        for (VG t : vgArrayList) {
            if (t.getName().equals(v)) {
                if(t.getName().indexOf(t.getLvStore()) == -1) {
                    if (t.getStorage() > 0) {
                        output = true;
                    }
                }
            }
        }
        return output;
    }
}