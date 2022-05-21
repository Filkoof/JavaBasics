package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Affair> affairs = new HashMap<>();

    public static List<Affair> getAffairs() {
        ArrayList<Affair> affairsList = new ArrayList<>();
        affairsList.addAll(affairs.values());
        return affairsList;
    }

    public static int addAffair(Affair affair) {
        int id = currentId++;
        affair.setId(id);
        affairs.put(id, affair);
        return id;
    }

    public static Affair getAffair(int affairId){
        if (affairs.containsKey(affairId)) {
            return affairs.get(affairId);
        }
        return null;
    }

    public static Affair deleteAffair(int id) {
        if (affairs.containsKey(id)) {
            return affairs.remove(id);
        }
        return null;
    }

    public static Affair patchAffair(Affair affair) {
        if (affairs.containsKey(affair.getId())) {
            return affairs.replace(affair.getId(), affair);
        }
        return null;
    }

    public static List<Affair> deleteAffairs() {
        ArrayList<Affair> affairsList = new ArrayList<>();
        affairs.clear();
        affairsList.addAll(affairs.values());
        return affairsList;
    }
}
